package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;

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

            }
        }
    }

	private void generateStyleRule(StyleRule styleRule) {
		cssBuilder.append(styleRule.selectors.get(0)).append(" {\n");
		increaseIdent();
		generateNodes(styleRule.body);
		cssBuilder.append("}\n");
		decreaseIdent();
	}

	private void generateDeclaration(Declaration declaration) {
        cssBuilder.append(declaration.property.name).append(": ");

        if (declaration.expression instanceof PixelLiteral) {
            cssBuilder.append(((PixelLiteral) declaration.expression).value).append("px;\n");
        } else if (declaration.expression instanceof PercentageLiteral) {
            cssBuilder.append(((PercentageLiteral) declaration.expression).value).append("%;\n");
        } else if (declaration.expression instanceof ColorLiteral) {
            cssBuilder.append(((ColorLiteral) declaration.expression).value).append(";\n");
        } else if (declaration.expression instanceof BoolLiteral) {
            cssBuilder.append(((BoolLiteral) declaration.expression).value).append(";\n");
        } else {
            cssBuilder.append(((IntLiteral) declaration.expression).value).append(";\n");
        }
    }

    public void addIndent() {
        cssBuilder.append("  ".repeat(Math.max(0, tab)));
    }

    public void increaseIdent() {
        tab++;
    }

    public void decreaseIdent() {
        tab--;
    }

}
