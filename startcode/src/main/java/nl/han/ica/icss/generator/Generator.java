package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.ColorLiteral;

import java.util.ArrayList;

public class Generator {
    StringBuilder cssBuilder = new StringBuilder();
    int tab = 0;

    public String generate(AST ast) {
        generateNodes(ast.root.getChildren());
        return cssBuilder.toString();
    }

    public void generateNodes(ArrayList<ASTNode> nodes) {
        for (ASTNode node : nodes) {
            addIndent();
            if (node instanceof StyleRule) {
				generateStyleRule((StyleRule) node);
            } else if (node instanceof Declaration) {
                generateDeclaration((Declaration) node);
            } else if (node instanceof VariableAssignment) {
				generateVariableAssignment((VariableAssignment) node);
                cssBuilder.append(((VariableAssignment) node).name.name).append(": ");
                var expression = ((VariableAssignment) node).expression;
                if (expression instanceof IntLiteral) {
                    cssBuilder.append(((IntLiteral) expression).value).append(";\n");
                } else if (expression instanceof BoolLiteral) {
                    cssBuilder.append(((BoolLiteral) expression).value).append(";\n");
                } else if (expression instanceof ColorLiteral) {
                    cssBuilder.append(((ColorLiteral) expression).value).append(";\n");
                }

            }
        }
    }

	private void generateVariableAssignment(VariableAssignment node) {

	}

	private void generateStyleRule(StyleRule styleRule) {
		cssBuilder.append(styleRule.selectors.get(0)).append(" {\n");
		increaseIdent();
		generateNodes(styleRule.body);
		cssBuilder.append("}\n");
		decreaseIdent();
	}

	private void generateDeclaration(Declaration declaration) {
        cssBuilder.append(((Declaration) declaration).property.name).append(": ");

        if (declaration.expression instanceof IntLiteral) {
            cssBuilder.append(((IntLiteral) declaration.expression).value).append(";\n");
        }
    }

    public void addIndent() {
        cssBuilder.append(" ".repeat(Math.max(0, tab)));
    }

    public void increaseIdent() {
        tab++;
    }

    public void decreaseIdent() {
        tab--;
    }

}
