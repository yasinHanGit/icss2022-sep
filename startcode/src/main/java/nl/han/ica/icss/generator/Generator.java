package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;

import java.util.ArrayList;

public class Generator {
	StringBuilder cssBuilder = new StringBuilder();

	public String generate(AST ast) {

		generateNodes(ast.root.getChildren());

        return cssBuilder.toString();


	}

	public void generateNodes(ArrayList<ASTNode> nodes){
		for (ASTNode node : nodes){
			if(node instanceof Stylerule){
				cssBuilder.append(((Stylerule) node).selectors.get(0)).append(" {\n");
				generateNodes(((Stylerule) node).body);
				cssBuilder.append("}\n");
			} else if (node instanceof Declaration) {
				cssBuilder.append(((Declaration) node).property.name).append(": ");
				cssBuilder.append(((IntLiteral)((Declaration) node).expression).value).append(";\n");
			}else if (node instanceof VariableAssignment){
				cssBuilder.append(((VariableAssignment) node).name.name).append(": ");
//				cssBuilder.app
			}
		}
	}

	
}
