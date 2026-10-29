package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.operations.boolOperations.BiggerBool;
import nl.han.ica.icss.ast.operations.boolOperations.EqualBool;
import nl.han.ica.icss.ast.operations.boolOperations.NotEqualBool;
import nl.han.ica.icss.ast.operations.boolOperations.SmallerBool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Literal>> variableValues;
    private ASTNode childNode;


    public Evaluator() {
        variableValues = new HANLinkedList<>();
    }

    @Override
    public void apply(AST ast) {
        variableValues = new HANLinkedList<>();
        variableValues.addFirst(new HashMap<>());
        transformNodes(ast.root.getChildren());
    }

    private void transformNodes(ArrayList<ASTNode> nodes) {
        ListIterator<ASTNode> iterator = nodes.listIterator();
        while (iterator.hasNext()) {
            ASTNode node = iterator.next();
            if (node instanceof VariableAssignment) {
                assignVariable((VariableAssignment) node);
                iterator.remove();
            } else if (node instanceof StyleRule) {
                variableValues.addFirst(new HashMap<>());
                transformNodes(((StyleRule) node).body);
                variableValues.removeFirst();
            } else if (node instanceof Declaration) {
                transformDeclaration((Declaration) node);
            } else if (node instanceof IfClause) {
                variableValues.addFirst(new HashMap<>());
                transformIfClause((IfClause) node);
                variableValues.removeFirst();
                iterator.remove();
                if (childNode != null) iterator.add(childNode);
                childNode = null;
            }
        }
    }


    private void transformIfClause(IfClause ifClause) {
        if (boolCheck(ifClause.conditionalExpression)) {
            transformNodes(ifClause.body);
        } else if (ifClause.elseClause != null) {
            transformNodes(ifClause.elseClause.body);
        }
    }

    private boolean boolCheck(Expression expression) {
        if (expression instanceof BoolLiteral) {
            return ((BoolLiteral) expression).value;
        } else if (expression instanceof VariableReference) {
            return boolCheck(getVariableValue((VariableReference) expression));
        } else if (expression instanceof BoolOperation) {
            return transformBoolOperation((BoolOperation) expression).value;
        }
        return false;
    }

    private void transformDeclaration(Declaration declaration) {
        declaration.expression = transformExpression(declaration.expression);
        childNode = declaration;
    }

    private Literal transformExpression(Expression expression) {
        if (expression instanceof VariableReference) {
            expression = getVariableValue((VariableReference) expression);
        } else if (expression instanceof AddOperation | expression instanceof SubtractOperation
                | expression instanceof MultiplyOperation) {
            expression = getSumOperation((Operation) expression);
        } else if (expression instanceof BoolOperation) {
            expression = transformBoolOperation((BoolOperation) expression);
        }
        return (Literal) expression;
    }

    private BoolLiteral transformBoolOperation(BoolOperation operation) {
        IntLiteral lsh = (IntLiteral) transformExpression(operation.lhs);
        IntLiteral rsh = (IntLiteral) transformExpression(operation.rhs);

        if (operation instanceof SmallerBool) {
            return (new BoolLiteral(lsh.value < rsh.value));
        } else if (operation instanceof BiggerBool) {
            return (new BoolLiteral(lsh.value > rsh.value));
        } else if (operation instanceof EqualBool) {
            return (new BoolLiteral(lsh.value == rsh.value));
        } else {
            return (new BoolLiteral(lsh.value != rsh.value));
        }
    }


    private Literal getSumOperation(Operation operation) {
        IntLiteral lsh = (IntLiteral) transformExpression(operation.lhs);
        IntLiteral rsh = (IntLiteral) transformExpression(operation.rhs);

        if (operation instanceof AddOperation) {
            lsh.value = lsh.value + rsh.value;
        } else if (operation instanceof SubtractOperation) {
            lsh.value = lsh.value - rsh.value;
        } else if (operation instanceof MultiplyOperation) {
            if (lsh instanceof ScalarLiteral) { //keep the right literal type
                var temp = lsh;
                lsh = rsh;
                rsh = temp;
            }
            lsh.value = lsh.value * rsh.value;
        }
        return lsh;
    }

    private Literal getVariableValue(VariableReference variableReference) {
        for (int i = 0; i < variableValues.getSize(); i++) {
            if (variableValues.get(i).containsKey(variableReference.name)) {
                return variableValues.get(i).get(variableReference.name);
            }
        }
        return null;
    }

    private void assignVariable(VariableAssignment variableAssignment) {
        var variableName = variableAssignment.name.name;
        var variableValue = transformExpression(variableAssignment.expression);
        for (int i = 0; i < variableValues.getSize(); i++) {
            if (variableValues.get(i).containsKey(variableName)) {
                variableValues.get(i).put(variableName, variableValue);
                return;
            }
        }
        variableValues.getFirst().put(variableName, variableValue);
    }

}
