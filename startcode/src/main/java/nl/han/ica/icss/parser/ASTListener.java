package nl.han.ica.icss.parser;

import java.util.ArrayList;
import java.util.Stack;


import nl.han.ica.datastructures.HANStack;
import nl.han.ica.icss.parser.ICSSBaseListener;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {

    //Accumulator attributes:
    private AST ast;

    //Use this to keep track of the parent nodes when recursively traversing the ast
    private IHANStack<ASTNode> currentContainer;

    public ASTListener() {
        ast = new AST();
        currentContainer = new HANStack<>();
    }

    public AST getAST() {
        return ast;
    }



    @Override
    public void enterStylesheet(ICSSParser.StylesheetContext ctx) {
        currentContainer.push(new Stylesheet());
    }

    @Override
    public void exitStylesheet(ICSSParser.StylesheetContext ctx) {
        ast.root = (Stylesheet) currentContainer.pop();
    }

	@Override
	public void enterVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
		currentContainer.push(new VariableAssignment());
	}

	@Override
	public void exitVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
		VariableAssignment variableAssignment = (VariableAssignment) currentContainer.pop();
		currentContainer.peek().addChild(variableAssignment);
	}

	@Override
	public void enterVariableReference(ICSSParser.VariableReferenceContext ctx) {
		currentContainer.push(new VariableReference(ctx.getText()));
	}

	@Override
	public void exitVariableReference(ICSSParser.VariableReferenceContext ctx) {
		VariableReference variableReference = (VariableReference) currentContainer.pop();
		currentContainer.peek().addChild(variableReference);
	}

	@Override
    public void enterStyleRule(ICSSParser.StyleRuleContext ctx) {
        currentContainer.push(new Stylerule());
    }

    @Override
    public void exitStyleRule(ICSSParser.StyleRuleContext ctx) {
        Stylerule styleRule = (Stylerule) currentContainer.pop();
        currentContainer.peek().addChild(styleRule);
    }

    @Override
    public void enterSelector(ICSSParser.SelectorContext ctx) {
        Selector selector = null;

        if (ctx.ID_IDENT() != null) selector = new IdSelector(ctx.ID_IDENT().getText());
        if (ctx.LOWER_IDENT() != null) selector = new TagSelector(ctx.LOWER_IDENT().getText());
        if (ctx.CLASS_IDENT() != null) selector = new ClassSelector(ctx.CLASS_IDENT().getText());

        currentContainer.push(selector);

    }

    @Override
    public void exitSelector(ICSSParser.SelectorContext ctx) {
        Selector selector = (Selector) currentContainer.pop();
        currentContainer.peek().addChild(selector);
    }

	@Override
	public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
		currentContainer.push(new Declaration());
	}

	@Override
	public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
		Declaration declaration = (Declaration) currentContainer.pop();
		currentContainer.peek().addChild(declaration);
	}


    @Override
	public void enterPropertyName(ICSSParser.PropertyNameContext ctx) {
		currentContainer.push(new PropertyName(ctx.getText()));
	}

	@Override
	public void exitPropertyName(ICSSParser.PropertyNameContext ctx) {
		PropertyName propertyName = (PropertyName) currentContainer.pop();
		currentContainer.peek().addChild(propertyName);
	}



    @Override
    public void enterAddOperation(ICSSParser.AddOperationContext ctx) {
        currentContainer.push(new AddOperation());
    }

    @Override
    public void exitAddOperation(ICSSParser.AddOperationContext ctx) {
        AddOperation addOperation = (AddOperation) currentContainer.pop();
        currentContainer.peek().addChild(addOperation);
    }

    @Override
    public void enterMulOperation(ICSSParser.MulOperationContext ctx) {
        currentContainer.push(new MultiplyOperation());
    }

    @Override
    public void exitMulOperation(ICSSParser.MulOperationContext ctx) {
        MultiplyOperation multiplyOperation = (MultiplyOperation) currentContainer.pop();
        currentContainer.peek().addChild(multiplyOperation);
    }

    @Override
    public void enterLiteral(ICSSParser.LiteralContext ctx) {
        Literal literal = null;

        if (ctx.bool() != null) literal = new BoolLiteral(ctx.getText());
        if (ctx.COLOR() != null) literal = new ColorLiteral(ctx.getText());
        if (ctx.PERCENTAGE() != null) literal = new PercentageLiteral(ctx.getText());
        if (ctx.PIXELSIZE() != null) literal = new PixelLiteral(ctx.getText());
        if (ctx.SCALAR() != null) literal = new ScalarLiteral(ctx.getText());

        currentContainer.push(literal);
    }

    @Override
    public void exitLiteral(ICSSParser.LiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }

    @Override
    public void enterIfClause(ICSSParser.IfClauseContext ctx) {
        currentContainer.push(new IfClause());
    }

    @Override
    public void exitIfClause(ICSSParser.IfClauseContext ctx) {
        IfClause ifClause = (IfClause) currentContainer.pop();
        currentContainer.peek().addChild(ifClause);
    }

    @Override
    public void enterElseClause(ICSSParser.ElseClauseContext ctx) {
        currentContainer.push(new ElseClause());
    }

    @Override
    public void exitElseClause(ICSSParser.ElseClauseContext ctx) {
        ElseClause elseClause = (ElseClause) currentContainer.pop();
        currentContainer.peek().addChild(elseClause);
    }

    @Override
    public void enterBool(nl.han.ica.icss.parser.ICSSParser.BoolContext ctx) {
        currentContainer.push(new BoolLiteral(ctx.getText()));
    }

    @Override
    public void exitBool(nl.han.ica.icss.parser.ICSSParser.BoolContext ctx) {
        BoolLiteral boolLiteral = (BoolLiteral) currentContainer.pop();
        currentContainer.peek().addChild(boolLiteral);
    }
}