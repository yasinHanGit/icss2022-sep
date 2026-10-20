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
        for (int i = 0; i < variableTypes.getSize(); i++) {
            System.out.println(variableTypes.get(i));
        }

    }

    private void assignVariable(VariableAssignment variableAssignment) {
        var hashMap = new HashMap<String, ExpressionType>();

        if (variableAssignment.expression instanceof BoolLiteral) {
            hashMap.put(variableAssignment.name.name, ExpressionType.BOOL);
        } else if (variableAssignment.expression instanceof ScalarLiteral) {
            hashMap.put(variableAssignment.name.name, ExpressionType.SCALAR);
        } else if (variableAssignment.expression instanceof PercentageLiteral) {
            hashMap.put(variableAssignment.name.name, ExpressionType.PERCENTAGE);
        } else if (variableAssignment.expression instanceof PixelLiteral) {
            hashMap.put(variableAssignment.name.name, ExpressionType.PIXEL);
        } else if (variableAssignment.expression instanceof ColorLiteral) {
            hashMap.put(variableAssignment.name.name, ExpressionType.COLOR);
        } else {
            hashMap.put(variableAssignment.name.name, ExpressionType.UNDEFINED);
        }


        variableTypes.addFirst(hashMap);
    }

    private void checkDeclaration(Declaration declaration) {
        if (declaration.property == null || declaration.expression == null) return;


        if ((declaration.property.name.equals("color") || declaration.property.name.equals("background-color")) && !(declaration.expression instanceof ColorLiteral)) {
            declaration.setError("Invalid value: "
                    + declaration.expression);
        } else if ((declaration.property.name.equals("width") || declaration.property.name.equals("height")) &&
                (!(declaration.expression instanceof PixelLiteral)) || (declaration.expression instanceof PercentageLiteral)) {
            declaration.setError("Invalid value: "
                    + declaration.expression);
        }


    }
}
