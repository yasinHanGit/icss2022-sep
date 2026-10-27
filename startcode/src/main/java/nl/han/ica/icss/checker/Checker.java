package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.ArrayList;
import java.util.HashMap;

public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        variableTypes.addFirst(new HashMap<>());
        checkNodes(ast.root.getChildren());
    }

    private void checkNodes(ArrayList<ASTNode> nodes) {
        for (ASTNode node : nodes) {
            if (node instanceof VariableAssignment) {
                assignVariable((VariableAssignment) node);
            } else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof StyleRule) {
                variableTypes.addFirst(new HashMap<>());
                checkNodes(((StyleRule) node).body);
                variableTypes.removeFirst();
            } else if (node instanceof IfClause) {
                IfClause ifClause = (IfClause) node;
                boolCheck(ifClause.conditionalExpression);
                variableTypes.addFirst(new HashMap<>());
                checkNodes(ifClause.body);
                variableTypes.removeFirst();
                if (ifClause.elseClause != null) {
                    variableTypes.addFirst(new HashMap<>());
                    checkNodes(ifClause.elseClause.body);
                    variableTypes.removeFirst();
                }
            } else if (node instanceof ElseClause) {
                variableTypes.addFirst(new HashMap<>());
                checkNodes(((ElseClause) node).body);
                variableTypes.removeFirst();
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
        var variableName = variableAssignment.name.name;
        var expressionType = getExpressionType(variableAssignment.expression);

        for (int i = 0; i < variableTypes.getSize(); i++) {
            if (variableTypes.get(i).containsKey(variableName)) {
                variableTypes.get(i).put(variableName, expressionType);
                return;
            }
        }

        variableTypes.getFirst().put(variableName, expressionType);
    }

    private void checkDeclaration(Declaration declaration) {
        if (declaration.property == null || declaration.expression == null) return;

        ExpressionType expressionType = getExpressionType(declaration.expression);
        String propertyName = declaration.property.name;

        if (declaration.expression instanceof Operation) {
            if (propertyName.equals("color") || propertyName.equals("background-color")) {
                declaration.setError("Invalid value: Operations on " + propertyName + " are not possible");
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
        if (operation.lhs instanceof Operation) operationCheck((Operation) operation.lhs);
        if (operation.rhs instanceof Operation) operationCheck((Operation) operation.rhs);


        if ((operation instanceof AddOperation || operation instanceof SubtractOperation) &&
                !getExpressionType(operation.lhs).equals(getExpressionType(operation.rhs)) &&
                !(operation.lhs instanceof Operation || operation.rhs instanceof Operation)) {
            operation.setError("Invalid input: " + operation.lhs + " & " + operation.rhs + " are not from the same type ");
            return;
        }
        if (operation instanceof MultiplyOperation &&
                !(operation.lhs instanceof ScalarLiteral || operation.rhs instanceof ScalarLiteral) &&
                !(operation.lhs instanceof Operation || operation.rhs instanceof Operation)) {
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
