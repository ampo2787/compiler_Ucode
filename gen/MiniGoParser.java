// Generated from /Users/jihoonpark/IdeaProjects/cp_pr2/src/MiniGo.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniGoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, VOID=21, VAR=22, FUNC=23, FMT=24, INT=25, 
		FOR=26, IF=27, ELSE=28, ELSE_IF=29, CASE=30, SWITCH=31, DEFAULT=32, RETURN=33, 
		OR=34, AND=35, LE=36, GE=37, EQ=38, NE=39, IDENT=40, LITERAL=41, DecimalConstant=42, 
		OctalConstant=43, HexadecimalConstant=44, WS=45;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_expr_stmt = 8, 
		RULE_assign_stmt = 9, RULE_compound_stmt = 10, RULE_if_stmt = 11, RULE_for_stmt = 12, 
		RULE_switch_stmt = 13, RULE_return_stmt = 14, RULE_local_decl = 15, RULE_loop_expr = 16, 
		RULE_expr = 17, RULE_args = 18;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
		"stmt", "expr_stmt", "assign_stmt", "compound_stmt", "if_stmt", "for_stmt", 
		"switch_stmt", "return_stmt", "local_decl", "loop_expr", "expr", "args"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'['", "']'", "'('", "')'", "':='", "'{'", "'}'", "';'", 
		"'++'", "'--'", "'.'", "'-'", "'+'", "'!'", "'*'", "'/'", "'%'", "'<'", 
		"'>'", "'void'", "'var'", "'func'", "'fmt'", "'int'", "'for'", "'if'", 
		"'else'", "'else if'", "'case'", "'switch'", "'default'", "'return'", 
		"'or'", "'and'", "'<='", "'>='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "VOID", "VAR", "FUNC", 
		"FMT", "INT", "FOR", "IF", "ELSE", "ELSE_IF", "CASE", "SWITCH", "DEFAULT", 
		"RETURN", "OR", "AND", "LE", "GE", "EQ", "NE", "IDENT", "LITERAL", "DecimalConstant", 
		"OctalConstant", "HexadecimalConstant", "WS"
	};
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
	public String getGrammarFileName() { return "MiniGo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniGoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				decl();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==FUNC );
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

	public static class DeclContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				var_decl();
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				fun_decl();
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

	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public List<TerminalNode> IDENT() { return getTokens(MiniGoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(MiniGoParser.IDENT, i);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(VAR);
				setState(48);
				match(IDENT);
				setState(49);
				type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(VAR);
				setState(51);
				match(IDENT);
				setState(52);
				match(T__0);
				setState(53);
				match(IDENT);
				setState(54);
				type_spec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(VAR);
				setState(56);
				match(IDENT);
				setState(57);
				match(T__1);
				setState(58);
				match(LITERAL);
				setState(59);
				match(T__2);
				setState(60);
				type_spec();
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

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniGoParser.INT, 0); }
		public TerminalNode VOID() { return getToken(MiniGoParser.VOID, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitType_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitType_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_spec);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(INT);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(VOID);
				}
				break;
			case EOF:
			case T__0:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case VAR:
			case FUNC:
			case FMT:
			case FOR:
			case IF:
			case SWITCH:
			case RETURN:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class Fun_declContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(MiniGoParser.FUNC, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitFun_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitFun_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun_decl);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(FUNC);
				setState(69);
				match(IDENT);
				setState(70);
				match(T__3);
				setState(71);
				params();
				setState(72);
				match(T__4);
				setState(73);
				type_spec();
				setState(74);
				compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(FUNC);
				setState(77);
				match(IDENT);
				setState(78);
				match(T__3);
				setState(79);
				params();
				setState(80);
				match(T__4);
				setState(81);
				match(T__3);
				setState(82);
				type_spec();
				setState(83);
				match(T__0);
				setState(84);
				type_spec();
				setState(85);
				match(T__4);
				setState(86);
				compound_stmt();
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				param();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(92);
					match(T__0);
					setState(93);
					param();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(IDENT);
				setState(102);
				type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(IDENT);
				setState(104);
				match(T__1);
				setState(105);
				match(T__2);
				setState(106);
				type_spec();
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

	public static class StmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Switch_stmtContext switch_stmt() {
			return getRuleContext(Switch_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				expr_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				compound_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				assign_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				if_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				for_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				switch_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				return_stmt();
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			expr(0);
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public List<TerminalNode> IDENT() { return getTokens(MiniGoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(MiniGoParser.IDENT, i);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public List<TerminalNode> LITERAL() { return getTokens(MiniGoParser.LITERAL); }
		public TerminalNode LITERAL(int i) {
			return getToken(MiniGoParser.LITERAL, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign_stmt);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(VAR);
				setState(121);
				match(IDENT);
				setState(122);
				match(T__0);
				setState(123);
				match(IDENT);
				setState(124);
				type_spec();
				setState(125);
				match(T__5);
				setState(126);
				match(LITERAL);
				setState(127);
				match(T__0);
				setState(128);
				match(LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(VAR);
				setState(131);
				match(IDENT);
				setState(132);
				type_spec();
				setState(133);
				match(T__5);
				setState(134);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(IDENT);
				setState(137);
				type_spec();
				setState(138);
				match(T__5);
				setState(139);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(IDENT);
				setState(142);
				match(T__1);
				setState(143);
				expr(0);
				setState(144);
				match(T__2);
				setState(145);
				match(T__5);
				setState(146);
				expr(0);
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compound_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__6);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					local_decl();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << VAR) | (1L << FMT) | (1L << FOR) | (1L << IF) | (1L << SWITCH) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(157);
				stmt();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			match(T__7);
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniGoParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Compound_stmtContext> compound_stmt() {
			return getRuleContexts(Compound_stmtContext.class);
		}
		public Compound_stmtContext compound_stmt(int i) {
			return getRuleContext(Compound_stmtContext.class,i);
		}
		public List<TerminalNode> ELSE_IF() { return getTokens(MiniGoParser.ELSE_IF); }
		public TerminalNode ELSE_IF(int i) {
			return getToken(MiniGoParser.ELSE_IF, i);
		}
		public TerminalNode ELSE() { return getToken(MiniGoParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IF);
			setState(166);
			expr(0);
			setState(167);
			compound_stmt();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSE_IF) {
				{
				{
				setState(168);
				match(ELSE_IF);
				setState(169);
				expr(0);
				setState(170);
				compound_stmt();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(177);
				match(ELSE);
				setState(178);
				compound_stmt();
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniGoParser.FOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Loop_exprContext loop_expr() {
			return getRuleContext(Loop_exprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_stmt);
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(FOR);
				setState(182);
				expr(0);
				setState(183);
				compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(FOR);
				setState(186);
				loop_expr();
				setState(187);
				stmt();
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

	public static class Switch_stmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(MiniGoParser.SWITCH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> CASE() { return getTokens(MiniGoParser.CASE); }
		public TerminalNode CASE(int i) {
			return getToken(MiniGoParser.CASE, i);
		}
		public List<TerminalNode> LITERAL() { return getTokens(MiniGoParser.LITERAL); }
		public TerminalNode LITERAL(int i) {
			return getToken(MiniGoParser.LITERAL, i);
		}
		public TerminalNode DEFAULT() { return getToken(MiniGoParser.DEFAULT, 0); }
		public Switch_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterSwitch_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitSwitch_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitSwitch_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_stmtContext switch_stmt() throws RecognitionException {
		Switch_stmtContext _localctx = new Switch_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_switch_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(SWITCH);
			setState(192);
			expr(0);
			setState(193);
			match(T__6);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(194);
				match(CASE);
				setState(195);
				match(LITERAL);
				setState(196);
				expr(0);
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(202);
				match(DEFAULT);
				setState(203);
				expr(0);
				}
			}

			setState(206);
			match(T__7);
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniGoParser.RETURN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return_stmt);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(RETURN);
				setState(209);
				expr(0);
				setState(210);
				match(T__0);
				setState(211);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(RETURN);
				setState(214);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(RETURN);
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

	public static class Local_declContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitLocal_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitLocal_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_local_decl);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(VAR);
				setState(219);
				match(IDENT);
				setState(220);
				type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(VAR);
				setState(222);
				match(IDENT);
				setState(223);
				match(T__1);
				setState(224);
				match(LITERAL);
				setState(225);
				match(T__2);
				setState(226);
				type_spec();
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

	public static class Loop_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Loop_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterLoop_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitLoop_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitLoop_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_exprContext loop_expr() throws RecognitionException {
		Loop_exprContext _localctx = new Loop_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loop_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			expr(0);
			setState(230);
			match(T__8);
			setState(231);
			expr(0);
			setState(232);
			match(T__8);
			setState(233);
			expr(0);
			setState(234);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<TerminalNode> LITERAL() { return getTokens(MiniGoParser.LITERAL); }
		public TerminalNode LITERAL(int i) {
			return getToken(MiniGoParser.LITERAL, i);
		}
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode FMT() { return getToken(MiniGoParser.FMT, 0); }
		public TerminalNode EQ() { return getToken(MiniGoParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniGoParser.NE, 0); }
		public TerminalNode LE() { return getToken(MiniGoParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniGoParser.GE, 0); }
		public TerminalNode AND() { return getToken(MiniGoParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniGoParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(237);
				_la = _input.LA(1);
				if ( !(_la==IDENT || _la==LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				setState(238);
				match(T__3);
				setState(239);
				expr(0);
				setState(240);
				match(T__4);
				}
				break;
			case 3:
				{
				setState(242);
				match(IDENT);
				setState(243);
				match(T__1);
				setState(244);
				expr(0);
				setState(245);
				match(T__2);
				}
				break;
			case 4:
				{
				setState(247);
				match(IDENT);
				setState(248);
				match(T__3);
				setState(249);
				args();
				setState(250);
				match(T__4);
				}
				break;
			case 5:
				{
				setState(252);
				match(FMT);
				setState(253);
				match(T__11);
				setState(254);
				match(IDENT);
				setState(255);
				match(T__3);
				setState(256);
				args();
				setState(257);
				match(T__4);
				}
				break;
			case 6:
				{
				setState(259);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(260);
				expr(7);
				}
				break;
			case 7:
				{
				setState(261);
				match(LITERAL);
				setState(262);
				match(T__0);
				setState(263);
				match(LITERAL);
				}
				break;
			case 8:
				{
				setState(264);
				match(IDENT);
				setState(265);
				match(T__5);
				setState(266);
				expr(2);
				}
				break;
			case 9:
				{
				setState(267);
				match(IDENT);
				setState(268);
				match(T__1);
				setState(269);
				expr(0);
				setState(270);
				match(T__2);
				setState(271);
				match(T__5);
				setState(272);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(285);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(277);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(278);
						((ExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(280);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(281);
						((ExprContext)_localctx).right = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(283);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << OR) | (1L << AND) | (1L << LE) | (1L << GE) | (1L << EQ) | (1L << NE))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						((ExprContext)_localctx).right = expr(5);
						}
						break;
					}
					} 
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniGoVisitor ) return ((MiniGoVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_args);
		int _la;
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case FMT:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				expr(0);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(291);
					match(T__0);
					setState(292);
					expr(0);
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0130\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\5\3\60\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\3\5"+
		"\5\5E\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13\7"+
		"\5\7f\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\tw\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0097\n\13\3\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e"+
		"\13\f\3\f\7\f\u00a1\n\f\f\f\16\f\u00a4\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\r\u00af\n\r\f\r\16\r\u00b2\13\r\3\r\3\r\5\r\u00b6\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c0\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u00c8\n\17\f\17\16\17\u00cb\13\17\3\17\3\17\5\17\u00cf"+
		"\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00db\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e6\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0115\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0120\n\23\f\23\16\23\u0123\13\23\3\24\3\24\3\24\7\24\u0128\n\24\f\24"+
		"\16\24\u012b\13\24\3\24\5\24\u012e\n\24\3\24\2\3$\25\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&\2\b\3\2\f\r\3\2*+\4\2\f\r\17\21\3\2\22\24\3"+
		"\2\17\20\4\2\25\26$)\2\u0146\2)\3\2\2\2\4/\3\2\2\2\6?\3\2\2\2\bD\3\2\2"+
		"\2\nZ\3\2\2\2\fe\3\2\2\2\16m\3\2\2\2\20v\3\2\2\2\22x\3\2\2\2\24\u0096"+
		"\3\2\2\2\26\u0098\3\2\2\2\30\u00a7\3\2\2\2\32\u00bf\3\2\2\2\34\u00c1\3"+
		"\2\2\2\36\u00da\3\2\2\2 \u00e5\3\2\2\2\"\u00e7\3\2\2\2$\u0114\3\2\2\2"+
		"&\u012d\3\2\2\2(*\5\4\3\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3"+
		"\2\2\2-\60\5\6\4\2.\60\5\n\6\2/-\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\62"+
		"\7\30\2\2\62\63\7*\2\2\63@\5\b\5\2\64\65\7\30\2\2\65\66\7*\2\2\66\67\7"+
		"\3\2\2\678\7*\2\28@\5\b\5\29:\7\30\2\2:;\7*\2\2;<\7\4\2\2<=\7+\2\2=>\7"+
		"\5\2\2>@\5\b\5\2?\61\3\2\2\2?\64\3\2\2\2?9\3\2\2\2@\7\3\2\2\2AE\7\33\2"+
		"\2BE\7\27\2\2CE\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\t\3\2\2\2FG\7\31"+
		"\2\2GH\7*\2\2HI\7\6\2\2IJ\5\f\7\2JK\7\7\2\2KL\5\b\5\2LM\5\26\f\2M[\3\2"+
		"\2\2NO\7\31\2\2OP\7*\2\2PQ\7\6\2\2QR\5\f\7\2RS\7\7\2\2ST\7\6\2\2TU\5\b"+
		"\5\2UV\7\3\2\2VW\5\b\5\2WX\7\7\2\2XY\5\26\f\2Y[\3\2\2\2ZF\3\2\2\2ZN\3"+
		"\2\2\2[\13\3\2\2\2\\f\3\2\2\2]b\5\16\b\2^_\7\3\2\2_a\5\16\b\2`^\3\2\2"+
		"\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2db\3\2\2\2e\\\3\2\2\2e]\3\2"+
		"\2\2f\r\3\2\2\2gh\7*\2\2hn\5\b\5\2ij\7*\2\2jk\7\4\2\2kl\7\5\2\2ln\5\b"+
		"\5\2mg\3\2\2\2mi\3\2\2\2n\17\3\2\2\2ow\5\22\n\2pw\5\26\f\2qw\5\24\13\2"+
		"rw\5\30\r\2sw\5\32\16\2tw\5\34\17\2uw\5\36\20\2vo\3\2\2\2vp\3\2\2\2vq"+
		"\3\2\2\2vr\3\2\2\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\21\3\2\2\2xy\5$\23\2"+
		"y\23\3\2\2\2z{\7\30\2\2{|\7*\2\2|}\7\3\2\2}~\7*\2\2~\177\5\b\5\2\177\u0080"+
		"\7\b\2\2\u0080\u0081\7+\2\2\u0081\u0082\7\3\2\2\u0082\u0083\7+\2\2\u0083"+
		"\u0097\3\2\2\2\u0084\u0085\7\30\2\2\u0085\u0086\7*\2\2\u0086\u0087\5\b"+
		"\5\2\u0087\u0088\7\b\2\2\u0088\u0089\5$\23\2\u0089\u0097\3\2\2\2\u008a"+
		"\u008b\7*\2\2\u008b\u008c\5\b\5\2\u008c\u008d\7\b\2\2\u008d\u008e\5$\23"+
		"\2\u008e\u0097\3\2\2\2\u008f\u0090\7*\2\2\u0090\u0091\7\4\2\2\u0091\u0092"+
		"\5$\23\2\u0092\u0093\7\5\2\2\u0093\u0094\7\b\2\2\u0094\u0095\5$\23\2\u0095"+
		"\u0097\3\2\2\2\u0096z\3\2\2\2\u0096\u0084\3\2\2\2\u0096\u008a\3\2\2\2"+
		"\u0096\u008f\3\2\2\2\u0097\25\3\2\2\2\u0098\u009c\7\t\2\2\u0099\u009b"+
		"\5 \21\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u00a2\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\5\20"+
		"\t\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7\n"+
		"\2\2\u00a6\27\3\2\2\2\u00a7\u00a8\7\35\2\2\u00a8\u00a9\5$\23\2\u00a9\u00b0"+
		"\5\26\f\2\u00aa\u00ab\7\37\2\2\u00ab\u00ac\5$\23\2\u00ac\u00ad\5\26\f"+
		"\2\u00ad\u00af\3\2\2\2\u00ae\u00aa\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b4\7\36\2\2\u00b4\u00b6\5\26\f\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3"+
		"\2\2\2\u00b6\31\3\2\2\2\u00b7\u00b8\7\34\2\2\u00b8\u00b9\5$\23\2\u00b9"+
		"\u00ba\5\26\f\2\u00ba\u00c0\3\2\2\2\u00bb\u00bc\7\34\2\2\u00bc\u00bd\5"+
		"\"\22\2\u00bd\u00be\5\20\t\2\u00be\u00c0\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf"+
		"\u00bb\3\2\2\2\u00c0\33\3\2\2\2\u00c1\u00c2\7!\2\2\u00c2\u00c3\5$\23\2"+
		"\u00c3\u00c9\7\t\2\2\u00c4\u00c5\7 \2\2\u00c5\u00c6\7+\2\2\u00c6\u00c8"+
		"\5$\23\2\u00c7\u00c4\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\""+
		"\2\2\u00cd\u00cf\5$\23\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d1\7\n\2\2\u00d1\35\3\2\2\2\u00d2\u00d3\7#\2\2"+
		"\u00d3\u00d4\5$\23\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\5$\23\2\u00d6\u00db"+
		"\3\2\2\2\u00d7\u00d8\7#\2\2\u00d8\u00db\5$\23\2\u00d9\u00db\7#\2\2\u00da"+
		"\u00d2\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\37\3\2\2"+
		"\2\u00dc\u00dd\7\30\2\2\u00dd\u00de\7*\2\2\u00de\u00e6\5\b\5\2\u00df\u00e0"+
		"\7\30\2\2\u00e0\u00e1\7*\2\2\u00e1\u00e2\7\4\2\2\u00e2\u00e3\7+\2\2\u00e3"+
		"\u00e4\7\5\2\2\u00e4\u00e6\5\b\5\2\u00e5\u00dc\3\2\2\2\u00e5\u00df\3\2"+
		"\2\2\u00e6!\3\2\2\2\u00e7\u00e8\5$\23\2\u00e8\u00e9\7\13\2\2\u00e9\u00ea"+
		"\5$\23\2\u00ea\u00eb\7\13\2\2\u00eb\u00ec\5$\23\2\u00ec\u00ed\t\2\2\2"+
		"\u00ed#\3\2\2\2\u00ee\u00ef\b\23\1\2\u00ef\u0115\t\3\2\2\u00f0\u00f1\7"+
		"\6\2\2\u00f1\u00f2\5$\23\2\u00f2\u00f3\7\7\2\2\u00f3\u0115\3\2\2\2\u00f4"+
		"\u00f5\7*\2\2\u00f5\u00f6\7\4\2\2\u00f6\u00f7\5$\23\2\u00f7\u00f8\7\5"+
		"\2\2\u00f8\u0115\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa\u00fb\7\6\2\2\u00fb"+
		"\u00fc\5&\24\2\u00fc\u00fd\7\7\2\2\u00fd\u0115\3\2\2\2\u00fe\u00ff\7\32"+
		"\2\2\u00ff\u0100\7\16\2\2\u0100\u0101\7*\2\2\u0101\u0102\7\6\2\2\u0102"+
		"\u0103\5&\24\2\u0103\u0104\7\7\2\2\u0104\u0115\3\2\2\2\u0105\u0106\t\4"+
		"\2\2\u0106\u0115\5$\23\t\u0107\u0108\7+\2\2\u0108\u0109\7\3\2\2\u0109"+
		"\u0115\7+\2\2\u010a\u010b\7*\2\2\u010b\u010c\7\b\2\2\u010c\u0115\5$\23"+
		"\4\u010d\u010e\7*\2\2\u010e\u010f\7\4\2\2\u010f\u0110\5$\23\2\u0110\u0111"+
		"\7\5\2\2\u0111\u0112\7\b\2\2\u0112\u0113\5$\23\3\u0113\u0115\3\2\2\2\u0114"+
		"\u00ee\3\2\2\2\u0114\u00f0\3\2\2\2\u0114\u00f4\3\2\2\2\u0114\u00f9\3\2"+
		"\2\2\u0114\u00fe\3\2\2\2\u0114\u0105\3\2\2\2\u0114\u0107\3\2\2\2\u0114"+
		"\u010a\3\2\2\2\u0114\u010d\3\2\2\2\u0115\u0121\3\2\2\2\u0116\u0117\f\b"+
		"\2\2\u0117\u0118\t\5\2\2\u0118\u0120\5$\23\t\u0119\u011a\f\7\2\2\u011a"+
		"\u011b\t\6\2\2\u011b\u0120\5$\23\b\u011c\u011d\f\6\2\2\u011d\u011e\t\7"+
		"\2\2\u011e\u0120\5$\23\7\u011f\u0116\3\2\2\2\u011f\u0119\3\2\2\2\u011f"+
		"\u011c\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122%\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0129\5$\23\2\u0125\u0126"+
		"\7\3\2\2\u0126\u0128\5$\23\2\u0127\u0125\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012e\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\u012e\3\2\2\2\u012d\u0124\3\2\2\2\u012d\u012c\3\2\2\2\u012e"+
		"\'\3\2\2\2\32+/?DZbemv\u0096\u009c\u00a2\u00b0\u00b5\u00bf\u00c9\u00ce"+
		"\u00da\u00e5\u0114\u011f\u0121\u0129\u012d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}