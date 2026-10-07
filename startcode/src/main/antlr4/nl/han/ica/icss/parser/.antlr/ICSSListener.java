// Generated from C:/Users/yasin/Documents/GitHub/icss2022-sep/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(ICSSParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(ICSSParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#backgroundColor}.
	 * @param ctx the parse tree
	 */
	void enterBackgroundColor(ICSSParser.BackgroundColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#backgroundColor}.
	 * @param ctx the parse tree
	 */
	void exitBackgroundColor(ICSSParser.BackgroundColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#width}.
	 * @param ctx the parse tree
	 */
	void enterWidth(ICSSParser.WidthContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#width}.
	 * @param ctx the parse tree
	 */
	void exitWidth(ICSSParser.WidthContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#height}.
	 * @param ctx the parse tree
	 */
	void enterHeight(ICSSParser.HeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#height}.
	 * @param ctx the parse tree
	 */
	void exitHeight(ICSSParser.HeightContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(ICSSParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(ICSSParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(ICSSParser.StylesheetContext ctx);
}