package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Literal>> variableValues;

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
        for (ASTNode node : nodes) {
            if (node instanceof VariableAssignment) {
                assignVariable((VariableAssignment) node);
            } else if (node instanceof StyleRule) {
                variableValues.addFirst(new HashMap<>());
                transformNodes(((StyleRule) node).body);
                variableValues.removeFirst();
            }else if (node instanceof Declaration) {
                transformDeclaration((Declaration) node);
            } else if (node instanceof IfClause) {
                variableValues.addFirst(new HashMap<>());
                transformIfClause((IfClause) node);
                variableValues.removeFirst();
            }

        }

    }

    private void transformIfClause(IfClause ifClause) {
        if (boolCheck(ifClause.conditionalExpression)){
            transformNodes(ifClause.body);
        } else if (ifClause.elseClause != null) {
            transformNodes(ifClause.elseClause.body);
        }
    }
    private boolean boolCheck(Expression expression) {
        if (expression instanceof BoolLiteral) {
          return ((BoolLiteral) expression).value;
        }else if (expression instanceof VariableReference){
            return boolCheck(getVariableValue((VariableReference)expression));
        }
        return false;
    }

    private void transformDeclaration(Declaration declaration){
        declaration.expression = transformExpression(declaration.expression);
    }

    private Literal transformExpression(Expression expression) {
        if (expression instanceof VariableReference) {
            expression = getVariableValue((VariableReference) expression);
        } else if (expression instanceof AddOperation | expression instanceof SubtractOperation
                | expression instanceof MultiplyOperation) {
            expression = getSumOperation((Operation) expression);
        }
        return (Literal) expression;
    }


    private Literal getSumOperation(Operation operation) {
        Literal lsh = transformExpression(operation.lhs);
        Literal rsh = transformExpression(operation.rhs);

        if (operation instanceof AddOperation) {
            ((IntLiteral) lsh).value = ((IntLiteral) lsh).value + ((IntLiteral) rsh).value;
        } else if (operation instanceof SubtractOperation) {
            ((IntLiteral) lsh).value =((IntLiteral) lsh).value - ((IntLiteral) rsh).value;
        } else {
            ((IntLiteral) lsh).value =((IntLiteral) lsh).value * ((IntLiteral) rsh).value;
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
        var variableValue = (Literal) variableAssignment.expression;
        for (int i = 0; i < variableValues.getSize(); i++) {
            if (variableValues.get(i).containsKey(variableName)) {
                variableValues.get(i).put(variableName, variableValue);
                return;
            }
        }
        variableValues.getFirst().put(variableName, variableValue);
    }

}
