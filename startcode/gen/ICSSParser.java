// Generated from C:/Users/yasin/Documents/GitHub/icss2022-sep/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ICSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, IF=5, ELSE=6, BOX_BRACKET_OPEN=7, BOX_BRACKET_CLOSE=8, 
		TRUE=9, FALSE=10, PIXELSIZE=11, PERCENTAGE=12, SCALAR=13, COLOR=14, ID_IDENT=15, 
		CLASS_IDENT=16, LOWER_IDENT=17, CAPITAL_IDENT=18, WS=19, OPEN_BRACE=20, 
		CLOSE_BRACE=21, SEMICOLON=22, COLON=23, PLUS=24, MIN=25, MUL=26, ASSIGNMENT_OPERATOR=27, 
		SMALLER=28, BIGGER=29, EQUAL=30, NOTEQUAL=31;
	public static final int
		RULE_propertyName = 0, RULE_variableReference = 1, RULE_bool = 2, RULE_literal = 3, 
		RULE_variableAssignment = 4, RULE_selector = 5, RULE_declaration = 6, 
		RULE_expression = 7, RULE_styleRule = 8, RULE_operand = 9, RULE_statement = 10, 
		RULE_ifClause = 11, RULE_elseClause = 12, RULE_boolOperation = 13, RULE_stylesheet = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"propertyName", "variableReference", "bool", "literal", "variableAssignment", 
			"selector", "declaration", "expression", "styleRule", "operand", "statement", 
			"ifClause", "elseClause", "boolOperation", "stylesheet"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'background-color'", "'color'", "'width'", "'height'", "'if'", 
			"'else'", "'['", "']'", "'TRUE'", "'FALSE'", null, null, null, null, 
			null, null, null, null, null, "'{'", "'}'", "';'", "':'", "'+'", "'-'", 
			"'*'", "':='", "'<'", "'>'", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", 
			"TRUE", "FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", 
			"CLASS_IDENT", "LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", 
			"SEMICOLON", "COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR", "SMALLER", 
			"BIGGER", "EQUAL", "NOTEQUAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ICSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyNameContext extends ParserRuleContext {
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_propertyName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode CAPITAL_IDENT() { return getToken(ICSSParser.CAPITAL_IDENT, 0); }
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(CAPITAL_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ICSSParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ICSSParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode PIXELSIZE() { return getToken(ICSSParser.PIXELSIZE, 0); }
		public TerminalNode PERCENTAGE() { return getToken(ICSSParser.PERCENTAGE, 0); }
		public TerminalNode COLOR() { return getToken(ICSSParser.COLOR, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode SCALAR() { return getToken(ICSSParser.SCALAR, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_literal);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIXELSIZE:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(PIXELSIZE);
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(PERCENTAGE);
				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				match(COLOR);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				bool();
				}
				break;
			case SCALAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				match(SCALAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignmentContext extends ParserRuleContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(ICSSParser.ASSIGNMENT_OPERATOR, 0); }
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BoolOperationContext boolOperation() {
			return getRuleContext(BoolOperationContext.class,0);
		}
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			variableReference();
			setState(44);
			match(ASSIGNMENT_OPERATOR);
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(45);
				expression(0);
				}
				break;
			case 2:
				{
				setState(46);
				boolOperation();
				}
				break;
			}
			setState(49);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public TerminalNode ID_IDENT() { return getToken(ICSSParser.ID_IDENT, 0); }
		public TerminalNode CLASS_IDENT() { return getToken(ICSSParser.CLASS_IDENT, 0); }
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ICSSParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			propertyName();
			setState(54);
			match(COLON);
			setState(55);
			expression(0);
			setState(56);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ExpressionContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public OpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ICSSParser.MUL, 0); }
		public MulOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterMulOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitMulOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitMulOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ICSSParser.PLUS, 0); }
		public AddOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterAddOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitAddOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitAddOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MIN() { return getToken(ICSSParser.MIN, 0); }
		public SubtractOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSubtractOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSubtractOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitSubtractOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new OpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(59);
			operand();
			}
			_ctx.stop = _input.LT(-1);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(70);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new MulOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(61);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(62);
						match(MUL);
						setState(63);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new AddOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(64);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(65);
						match(PLUS);
						setState(66);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new SubtractOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(67);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(68);
						match(MIN);
						setState(69);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StyleRuleContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<IfClauseContext> ifClause() {
			return getRuleContexts(IfClauseContext.class);
		}
		public IfClauseContext ifClause(int i) {
			return getRuleContext(IfClauseContext.class,i);
		}
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public StyleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStyleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStyleRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStyleRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleRuleContext styleRule() throws RecognitionException {
		StyleRuleContext _localctx = new StyleRuleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_styleRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			selector();
			setState(76);
			match(OPEN_BRACE);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(80);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__2:
				case T__3:
					{
					setState(77);
					declaration();
					}
					break;
				case IF:
					{
					setState(78);
					ifClause();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(79);
					variableAssignment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 262206L) != 0) );
			setState(84);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperandContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operand);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case PIXELSIZE:
			case PERCENTAGE:
			case SCALAR:
			case COLOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				literal();
				}
				break;
			case CAPITAL_IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				variableReference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<IfClauseContext> ifClause() {
			return getRuleContexts(IfClauseContext.class);
		}
		public IfClauseContext ifClause(int i) {
			return getRuleContext(IfClauseContext.class,i);
		}
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(OPEN_BRACE);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(94);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__2:
				case T__3:
					{
					setState(91);
					declaration();
					}
					break;
				case IF:
					{
					setState(92);
					ifClause();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(93);
					variableAssignment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 262206L) != 0) );
			setState(98);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfClauseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ICSSParser.IF, 0); }
		public TerminalNode BOX_BRACKET_OPEN() { return getToken(ICSSParser.BOX_BRACKET_OPEN, 0); }
		public TerminalNode BOX_BRACKET_CLOSE() { return getToken(ICSSParser.BOX_BRACKET_CLOSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolOperationContext boolOperation() {
			return getRuleContext(BoolOperationContext.class,0);
		}
		public ElseClauseContext elseClause() {
			return getRuleContext(ElseClauseContext.class,0);
		}
		public IfClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitIfClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfClauseContext ifClause() throws RecognitionException {
		IfClauseContext _localctx = new IfClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(IF);
			setState(101);
			match(BOX_BRACKET_OPEN);
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(102);
				variableReference();
				}
				break;
			case 2:
				{
				setState(103);
				bool();
				}
				break;
			case 3:
				{
				setState(104);
				boolOperation();
				}
				break;
			}
			setState(107);
			match(BOX_BRACKET_CLOSE);
			setState(108);
			statement();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(109);
				elseClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseClauseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ICSSParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterElseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitElseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitElseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseClauseContext elseClause() throws RecognitionException {
		ElseClauseContext _localctx = new ElseClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_elseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(ELSE);
			setState(113);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolOperationContext extends ParserRuleContext {
		public BoolOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOperation; }
	 
		public BoolOperationContext() { }
		public void copyFrom(BoolOperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SmallerBoolContext extends BoolOperationContext {
		public TerminalNode SMALLER() { return getToken(ICSSParser.SMALLER, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<VariableReferenceContext> variableReference() {
			return getRuleContexts(VariableReferenceContext.class);
		}
		public VariableReferenceContext variableReference(int i) {
			return getRuleContext(VariableReferenceContext.class,i);
		}
		public SmallerBoolContext(BoolOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSmallerBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSmallerBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitSmallerBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotEqualBoolContext extends BoolOperationContext {
		public TerminalNode NOTEQUAL() { return getToken(ICSSParser.NOTEQUAL, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<VariableReferenceContext> variableReference() {
			return getRuleContexts(VariableReferenceContext.class);
		}
		public VariableReferenceContext variableReference(int i) {
			return getRuleContext(VariableReferenceContext.class,i);
		}
		public NotEqualBoolContext(BoolOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterNotEqualBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitNotEqualBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitNotEqualBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BiggerBoolContext extends BoolOperationContext {
		public TerminalNode BIGGER() { return getToken(ICSSParser.BIGGER, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<VariableReferenceContext> variableReference() {
			return getRuleContexts(VariableReferenceContext.class);
		}
		public VariableReferenceContext variableReference(int i) {
			return getRuleContext(VariableReferenceContext.class,i);
		}
		public BiggerBoolContext(BoolOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterBiggerBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitBiggerBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitBiggerBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualBoolContext extends BoolOperationContext {
		public TerminalNode EQUAL() { return getToken(ICSSParser.EQUAL, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<VariableReferenceContext> variableReference() {
			return getRuleContexts(VariableReferenceContext.class);
		}
		public VariableReferenceContext variableReference(int i) {
			return getRuleContext(VariableReferenceContext.class,i);
		}
		public EqualBoolContext(BoolOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterEqualBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitEqualBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitEqualBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperationContext boolOperation() throws RecognitionException {
		BoolOperationContext _localctx = new BoolOperationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boolOperation);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new SmallerBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(115);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(116);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(119);
				match(SMALLER);
				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(120);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(121);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new BiggerBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(124);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(125);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(128);
				match(BIGGER);
				setState(131);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(129);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(130);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new EqualBoolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(133);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(134);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(137);
				match(EQUAL);
				setState(140);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(138);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(139);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				_localctx = new NotEqualBoolContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(142);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(143);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(146);
				match(NOTEQUAL);
				setState(149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case PIXELSIZE:
				case PERCENTAGE:
				case SCALAR:
				case COLOR:
					{
					setState(147);
					literal();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(148);
					variableReference();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesheetContext extends ParserRuleContext {
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public List<StyleRuleContext> styleRule() {
			return getRuleContexts(StyleRuleContext.class);
		}
		public StyleRuleContext styleRule(int i) {
			return getRuleContext(StyleRuleContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAPITAL_IDENT) {
				{
				{
				setState(153);
				variableAssignment();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) {
				{
				{
				setState(159);
				styleRule();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00a6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003*\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u00040\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007G\b\u0007\n\u0007\f\u0007J\t"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\bQ\b\b\u000b\b\f"+
		"\bR\u0001\b\u0001\b\u0001\t\u0001\t\u0003\tY\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0004\n_\b\n\u000b\n\f\n`\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bj\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bo\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0003\rv\b\r\u0001\r\u0001\r\u0001\r\u0003\r{\b\r\u0001"+
		"\r\u0001\r\u0003\r\u007f\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u0084\b\r"+
		"\u0001\r\u0001\r\u0003\r\u0088\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u008d"+
		"\b\r\u0001\r\u0001\r\u0003\r\u0091\b\r\u0001\r\u0001\r\u0001\r\u0003\r"+
		"\u0096\b\r\u0003\r\u0098\b\r\u0001\u000e\u0005\u000e\u009b\b\u000e\n\u000e"+
		"\f\u000e\u009e\t\u000e\u0001\u000e\u0005\u000e\u00a1\b\u000e\n\u000e\f"+
		"\u000e\u00a4\t\u000e\u0001\u000e\u0000\u0001\u000e\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0003"+
		"\u0001\u0000\u0001\u0004\u0001\u0000\t\n\u0001\u0000\u000f\u0011\u00b5"+
		"\u0000\u001e\u0001\u0000\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004"+
		"\"\u0001\u0000\u0000\u0000\u0006)\u0001\u0000\u0000\u0000\b+\u0001\u0000"+
		"\u0000\u0000\n3\u0001\u0000\u0000\u0000\f5\u0001\u0000\u0000\u0000\u000e"+
		":\u0001\u0000\u0000\u0000\u0010K\u0001\u0000\u0000\u0000\u0012X\u0001"+
		"\u0000\u0000\u0000\u0014Z\u0001\u0000\u0000\u0000\u0016d\u0001\u0000\u0000"+
		"\u0000\u0018p\u0001\u0000\u0000\u0000\u001a\u0097\u0001\u0000\u0000\u0000"+
		"\u001c\u009c\u0001\u0000\u0000\u0000\u001e\u001f\u0007\u0000\u0000\u0000"+
		"\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u0012\u0000\u0000!\u0003"+
		"\u0001\u0000\u0000\u0000\"#\u0007\u0001\u0000\u0000#\u0005\u0001\u0000"+
		"\u0000\u0000$*\u0005\u000b\u0000\u0000%*\u0005\f\u0000\u0000&*\u0005\u000e"+
		"\u0000\u0000\'*\u0003\u0004\u0002\u0000(*\u0005\r\u0000\u0000)$\u0001"+
		"\u0000\u0000\u0000)%\u0001\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000"+
		")\'\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*\u0007\u0001\u0000"+
		"\u0000\u0000+,\u0003\u0002\u0001\u0000,/\u0005\u001b\u0000\u0000-0\u0003"+
		"\u000e\u0007\u0000.0\u0003\u001a\r\u0000/-\u0001\u0000\u0000\u0000/.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0005\u0016\u0000\u0000"+
		"2\t\u0001\u0000\u0000\u000034\u0007\u0002\u0000\u00004\u000b\u0001\u0000"+
		"\u0000\u000056\u0003\u0000\u0000\u000067\u0005\u0017\u0000\u000078\u0003"+
		"\u000e\u0007\u000089\u0005\u0016\u0000\u00009\r\u0001\u0000\u0000\u0000"+
		":;\u0006\u0007\uffff\uffff\u0000;<\u0003\u0012\t\u0000<H\u0001\u0000\u0000"+
		"\u0000=>\n\u0003\u0000\u0000>?\u0005\u001a\u0000\u0000?G\u0003\u000e\u0007"+
		"\u0004@A\n\u0002\u0000\u0000AB\u0005\u0018\u0000\u0000BG\u0003\u000e\u0007"+
		"\u0003CD\n\u0001\u0000\u0000DE\u0005\u0019\u0000\u0000EG\u0003\u000e\u0007"+
		"\u0002F=\u0001\u0000\u0000\u0000F@\u0001\u0000\u0000\u0000FC\u0001\u0000"+
		"\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000I\u000f\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000KL\u0003\n\u0005\u0000LP\u0005\u0014\u0000\u0000MQ\u0003\f\u0006"+
		"\u0000NQ\u0003\u0016\u000b\u0000OQ\u0003\b\u0004\u0000PM\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TU\u0005\u0015\u0000\u0000U\u0011\u0001\u0000\u0000"+
		"\u0000VY\u0003\u0006\u0003\u0000WY\u0003\u0002\u0001\u0000XV\u0001\u0000"+
		"\u0000\u0000XW\u0001\u0000\u0000\u0000Y\u0013\u0001\u0000\u0000\u0000"+
		"Z^\u0005\u0014\u0000\u0000[_\u0003\f\u0006\u0000\\_\u0003\u0016\u000b"+
		"\u0000]_\u0003\b\u0004\u0000^[\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bc\u0005\u0015\u0000\u0000c\u0015\u0001\u0000\u0000\u0000de\u0005\u0005"+
		"\u0000\u0000ei\u0005\u0007\u0000\u0000fj\u0003\u0002\u0001\u0000gj\u0003"+
		"\u0004\u0002\u0000hj\u0003\u001a\r\u0000if\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"kl\u0005\b\u0000\u0000ln\u0003\u0014\n\u0000mo\u0003\u0018\f\u0000nm\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u0017\u0001\u0000\u0000"+
		"\u0000pq\u0005\u0006\u0000\u0000qr\u0003\u0014\n\u0000r\u0019\u0001\u0000"+
		"\u0000\u0000sv\u0003\u0006\u0003\u0000tv\u0003\u0002\u0001\u0000us\u0001"+
		"\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wz\u0005\u001c\u0000\u0000x{\u0003\u0006\u0003\u0000y{\u0003\u0002\u0001"+
		"\u0000zx\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000{\u0098\u0001"+
		"\u0000\u0000\u0000|\u007f\u0003\u0006\u0003\u0000}\u007f\u0003\u0002\u0001"+
		"\u0000~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0083\u0005\u001d\u0000\u0000\u0081\u0084"+
		"\u0003\u0006\u0003\u0000\u0082\u0084\u0003\u0002\u0001\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0098"+
		"\u0001\u0000\u0000\u0000\u0085\u0088\u0003\u0006\u0003\u0000\u0086\u0088"+
		"\u0003\u0002\u0001\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008c"+
		"\u0005\u001e\u0000\u0000\u008a\u008d\u0003\u0006\u0003\u0000\u008b\u008d"+
		"\u0003\u0002\u0001\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u0098\u0001\u0000\u0000\u0000\u008e\u0091"+
		"\u0003\u0006\u0003\u0000\u008f\u0091\u0003\u0002\u0001\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u0092\u0095\u0005\u001f\u0000\u0000\u0093\u0096"+
		"\u0003\u0006\u0003\u0000\u0094\u0096\u0003\u0002\u0001\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0001\u0000\u0000\u0000\u0097u\u0001\u0000\u0000\u0000\u0097~\u0001\u0000"+
		"\u0000\u0000\u0097\u0087\u0001\u0000\u0000\u0000\u0097\u0090\u0001\u0000"+
		"\u0000\u0000\u0098\u001b\u0001\u0000\u0000\u0000\u0099\u009b\u0003\b\u0004"+
		"\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u00a2\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00a1\u0003\u0010\b\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u001d\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u0016)/FHPRX^`inuz~\u0083\u0087\u008c"+
		"\u0090\u0095\u0097\u009c\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}