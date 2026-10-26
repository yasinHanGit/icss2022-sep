package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

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
            } else if (node instanceof Stylerule) {
                variableValues.addFirst(new HashMap<>());
                transformNodes(((Stylerule) node).body);
                variableValues.removeFirst();
            }else if (node instanceof Declaration) {
                transformExpression(((Declaration) node).expression);
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

    private Literal transformExpression(Expression expression) {

        if (expression instanceof VariableReference) {
            expression = getVariableValue((VariableReference) expression);
        } else if (expression instanceof AddOperation) {
            expression = getSumAddOperation((AddOperation) expression);
        } else if (expression instanceof MultiplyOperation) {
            expression = getSumMulOperation((MultiplyOperation) expression);
        }
        System.out.println(expression);
        return (Literal) expression;
    }

    private Literal getSumMulOperation(MultiplyOperation expression) {
        Literal lsh = transformExpression(expression.lhs);
        Literal rsh = transformExpression(expression.rhs);

        if (rsh instanceof ScalarLiteral) {
            var temp = lsh;
            lsh = rsh;
            rsh = temp;
        }

        if (rsh instanceof ScalarLiteral) {
            return new ScalarLiteral(((ScalarLiteral) lsh).value * ((ScalarLiteral) rsh).value);
        } else if (rsh instanceof PixelLiteral) {
            return new PixelLiteral(((ScalarLiteral) lsh).value * ((PixelLiteral) rsh).value);
        } else if (rsh instanceof PercentageLiteral) {
            return new PercentageLiteral(((ScalarLiteral) lsh).value * ((PercentageLiteral) rsh).value);
        }
        return null;
    }

    private Literal getSumAddOperation(AddOperation expression) {
        Literal lsh = transformExpression(expression.lhs);
        Literal rsh = transformExpression(expression.rhs);

        //maak interface?
        if (lsh instanceof ScalarLiteral) {
            return new ScalarLiteral(((ScalarLiteral) lsh).value + ((ScalarLiteral) rsh).value);
        } else if (lsh instanceof PixelLiteral) {
            return new PixelLiteral(((PixelLiteral) lsh).value + ((PixelLiteral) rsh).value);
        } else if (lsh instanceof PercentageLiteral) {
            return new PercentageLiteral(((PercentageLiteral) lsh).value + ((PercentageLiteral) rsh).value);
        }
        return null;
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
