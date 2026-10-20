package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.ArrayList;
import java.util.HashMap;

public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        checkNodes(ast.root.getChildren());
    }

    private void checkNodes(ArrayList<ASTNode> nodes) {
        for (ASTNode node : nodes) {
            if (node instanceof VariableAssignment) {
                assignVariable((VariableAssignment) node);
            } else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof Stylerule) {
                checkNodes(((Stylerule) node).body);
            } else if (node instanceof IfClause) {
                IfClause ifClause = (IfClause) node;
                checkNodes(ifClause.body);
                if (ifClause.elseClause != null) {
                    checkNodes(ifClause.elseClause.body);
                }
            } else if (node instanceof ElseClause) {
                checkNodes(((ElseClause) node).body);
            }
        }
    }

    private void assignVariable(VariableAssignment variableAssignment) {
        var hashMap = new HashMap<String, ExpressionType>();

        for (int i = 0; i < variableTypes.getSize(); i++){
            if (variableTypes.get(i).containsKey(variableAssignment.name.name)){
                variableAssignment.setError("Variable: \""
                        + variableAssignment.name.name+"\" already exists: ");
                return;
            }
        }
        hashMap.put(variableAssignment.name.name, getExpressionType(variableAssignment.expression));
        variableTypes.addFirst(hashMap);
    }


    private void checkDeclaration(Declaration declaration) {
        if (declaration.property == null || declaration.expression == null) return;

        ExpressionType expressionType = getExpressionType(declaration.expression);
        String propertyName = declaration.property.name;

        if (declaration.expression instanceof VariableReference) {

            for (int i = 0; i < variableTypes.getSize(); i++) {
                if (variableTypes.get(i).containsKey(((VariableReference) declaration.expression).name)) {
                    expressionType = variableTypes.get(i).get(((VariableReference) declaration.expression).name);
                }
            }
        }
        if ((propertyName.equals("color") || propertyName.equals("background-color")) &&
                !(expressionType.equals(ExpressionType.COLOR))) {
            declaration.setError("Invalid value: "
                    + declaration.expression);
        } else if ((propertyName.equals("width") || propertyName.equals("height")) &&
                (!(expressionType.equals(ExpressionType.PIXEL) || expressionType.equals(ExpressionType.PERCENTAGE)))) {
            declaration.setError("Invalid value: "
                    + declaration.expression);
        }
    }


    private ExpressionType getExpressionType(Expression expression) {
        if (expression instanceof BoolLiteral) {
            return ExpressionType.BOOL;
        } else if (expression instanceof ScalarLiteral) {
            return ExpressionType.SCALAR;
        } else if (expression instanceof PercentageLiteral) {
            return ExpressionType.PERCENTAGE;
        } else if (expression instanceof PixelLiteral) {
            return ExpressionType.PIXEL;
        } else if (expression instanceof ColorLiteral) {
            return ExpressionType.COLOR;
        } else {
            return ExpressionType.UNDEFINED;
        }
    }

}
