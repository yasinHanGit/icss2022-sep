package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
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
            }else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof Stylerule) {
                checkNodes(((Stylerule) node).body);
            }  else if (node instanceof IfClause) {
                IfClause ifClause = (IfClause) node;
                boolCheck(ifClause.conditionalExpression);
                checkNodes(ifClause.body);
                if (ifClause.elseClause != null) {
                    checkNodes(ifClause.elseClause.body);
                }
            } else if (node instanceof ElseClause) {
                checkNodes(((ElseClause) node).body);
            }
        }
    }


    private void boolCheck(Expression expression) {
        if (!getExpressionType(expression).equals(ExpressionType.BOOL)) {
            expression.setError(((VariableReference) expression).name +
                    " : Required type boolean. Provided type: " + getExpressionType(expression));
        }
    }

    private void assignVariable(VariableAssignment variableAssignment) {
        var hashMap = new HashMap<String, ExpressionType>();
        var variableName = variableAssignment.name.name;
        if (variableName.equals("TRUE") || variableName.equals("FALSE") ||
                variableName.equals("ONVOLDOENDE")) {
            variableAssignment.setError("Invalid value: " + variableName);
            return;
        }
        for (int i = 0; i < variableTypes.getSize(); i++) {
            if (variableTypes.get(i).containsKey(variableName)) {
                variableAssignment.setError("Variable: \"" + variableName + "\" already exists");
                return;
            }
        }
        hashMap.put(variableName, getExpressionType(variableAssignment.expression));
        variableTypes.addFirst(hashMap);
    }

    private void checkDeclaration(Declaration declaration) {
        if (declaration.property == null || declaration.expression == null) return;

        ExpressionType expressionType = getExpressionType(declaration.expression);
        String propertyName = declaration.property.name;

        if (declaration.expression instanceof Operation) {
            if (propertyName.equals("color") || propertyName.equals("background-color")){
                declaration.setError("Invalid value: operations on " + propertyName + " are not possible");
                return;
            }
            operationCheck((Operation) declaration.expression);
        } else if ((propertyName.equals("color") || propertyName.equals("background-color")) &&
                !(expressionType.equals(ExpressionType.COLOR))) {
            declaration.setError("Invalid value: " + declaration.expression);
        } else if ((propertyName.equals("width") || propertyName.equals("height")) &&
                (!(expressionType.equals(ExpressionType.PIXEL) || expressionType.equals(ExpressionType.PERCENTAGE)))) {
            declaration.setError("Invalid value: " + declaration.expression);
        }
    }

    private void operationCheck(Operation operation) {
        for (var child : operation.getChildren()) {
            if (child instanceof ColorLiteral) {
                operation.setError("Invalid input: " + child);
                return;
            }
        }
//        if (operation.lhs instanceof ScalarLiteral && operation.rhs instanceof ScalarLiteral) {
//            operation.setError("Invalid input: no type specified");
//            return;
//        }
        if (operation instanceof AddOperation &&
                !getExpressionType(operation.lhs).equals(getExpressionType(operation.rhs))){
            operation.setError("Invalid input: " + operation.lhs + " & " + operation.rhs + " are not from the same type ");
            return;
        }
        if (operation instanceof MultiplyOperation &&
                !(operation.lhs instanceof ScalarLiteral || operation.rhs instanceof ScalarLiteral)){
            operation.setError("Invalid input: " + operation.lhs + " & " + operation.rhs + " can not be multiplied ");
        }
    }

    private ExpressionType getExpressionType(Expression expression) {
        if (expression instanceof VariableReference) {
            return getVariableExpression(expression);
        } else if (expression instanceof BoolLiteral) {
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

    private ExpressionType getVariableExpression(Expression expression) {
        for (int i = 0; i < variableTypes.getSize(); i++) {
            if (variableTypes.get(i).containsKey(((VariableReference) expression).name)) {
                return variableTypes.get(i).get(((VariableReference) expression).name);
            }
        }
        expression.setError("Variable: \"" + ((VariableReference) expression).name + "\" does not exist");

        return ExpressionType.UNDEFINED;
    }


}
