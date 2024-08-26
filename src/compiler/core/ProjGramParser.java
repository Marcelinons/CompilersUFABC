// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ProjGramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ATTRIBUTION=10, TYPE=11, LOG_OP=12, OPEN_PAREN=13, CLOSE_PAREN=14, OPEN_CB=15, 
		CLOSE_CB=16, OP=17, ID=18, NUM=19, VIRG=20, PV=21, DP=22, WS=23, TEXTO=24;
	public static final int
		RULE_program = 0, RULE_declare_var = 1, RULE_command = 2, RULE_cmdAttrib = 3, 
		RULE_cmdRead = 4, RULE_cmdWrite = 5, RULE_expr = 6, RULE_termo = 7, RULE_expr_md = 8, 
		RULE_repetition = 9, RULE_instruction_block = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare_var", "command", "cmdAttrib", "cmdRead", "cmdWrite", 
			"expr", "termo", "expr_md", "repetition", "instruction_block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'begin'", "'end'", "'let'", "'number'", "'text'", "'boolean'", 
			"'read'", "'print'", "'while'", "'='", null, null, "'('", "')'", "'{'", 
			"'}'", null, null, null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ATTRIBUTION", 
			"TYPE", "LOG_OP", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", "CLOSE_CB", 
			"OP", "ID", "NUM", "VIRG", "PV", "DP", "WS", "TEXTO"
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
	public String getGrammarFileName() { return "ProjGram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private HashMap<String, Variable> varMap = new HashMap<String, Variable>();
	    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
	    private Types currentType;
	    
	    public void updateType(){
	    	for(Variable v: currentDecl){
	    	   v.setType(currentType);
	    	   varMap.put(v.getId(), v);
	    	}
	    }
	    public void showVariables(){
	        for (String id: varMap.keySet()){
	        	System.out.println(varMap.get(id));
	        }
	    }
	    public boolean isDeclared(Variable var) {
	    	for (String id: varMap.keySet()) {
	    		if (var.getId() == id) return true;
	    	}
	    	return false;
	    }

	public ProjGramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<Declare_varContext> declare_var() {
			return getRuleContexts(Declare_varContext.class);
		}
		public Declare_varContext declare_var(int i) {
			return getRuleContext(Declare_varContext.class,i);
		}
		public List<TerminalNode> PV() { return getTokens(ProjGramParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(ProjGramParser.PV, i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				declare_var();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(28);
					command();
					}
					break;
				case 2:
					{
					setState(29);
					expr();
					}
					break;
				}
				setState(32);
				match(PV);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17564032L) != 0) );
			setState(38);
			match(T__1);
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
	public static class Declare_varContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProjGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjGramParser.ID, i);
		}
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(ProjGramParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(ProjGramParser.VIRG, i);
		}
		public Declare_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterDeclare_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitDeclare_var(this);
		}
	}

	public final Declare_varContext declare_var() throws RecognitionException {
		Declare_varContext _localctx = new Declare_varContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declare_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__2);
			 currentDecl.clear(); 
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(42);
				match(T__3);
				currentType = Types.NUMBER;
				}
				break;
			case T__4:
				{
				setState(44);
				match(T__4);
				currentType = Types.TEXT;
				}
				break;
			case T__5:
				{
				setState(46);
				match(T__5);
				currentType = Types.BOOLEAN;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(50);
			match(ID);
			 currentDecl.add(new Variable(_input.LT(-1).getText()));
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(52);
				match(VIRG);
				setState(53);
				match(ID);
				 currentDecl.add(new Variable(_input.LT(-1).getText()));
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			updateType();
			setState(61);
			match(PV);
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
	public static class CommandContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				cmdAttrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				cmdRead();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				cmdWrite();
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
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode ATTRIBUTION() { return getToken(ProjGramParser.ATTRIBUTION, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ID);
			setState(69);
			match(ATTRIBUTION);
			setState(70);
			expr();
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
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdRead(this);
		}
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__6);
			setState(73);
			match(OPEN_PAREN);
			setState(74);
			match(ID);
			setState(75);
			match(CLOSE_PAREN);
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
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdWrite(this);
		}
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdWrite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__7);
			setState(78);
			match(OPEN_PAREN);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				termo();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17563648L) != 0) );
			setState(84);
			match(CLOSE_PAREN);
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
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Expr_mdContext expr_md() {
			return getRuleContext(Expr_mdContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			termo();
			setState(87);
			expr_md();
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
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode NUM() { return getToken(ProjGramParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(ProjGramParser.TEXTO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17563648L) != 0)) ) {
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
	public static class Expr_mdContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(ProjGramParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(ProjGramParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public Expr_mdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_md; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterExpr_md(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitExpr_md(this);
		}
	}

	public final Expr_mdContext expr_md() throws RecognitionException {
		Expr_mdContext _localctx = new Expr_mdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_md);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(91);
				match(OP);
				setState(92);
				termo();
				}
				}
				setState(97);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RepetitionContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode LOG_OP() { return getToken(ProjGramParser.LOG_OP, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_CB() { return getToken(ProjGramParser.OPEN_CB, 0); }
		public Instruction_blockContext instruction_block() {
			return getRuleContext(Instruction_blockContext.class,0);
		}
		public TerminalNode CLOSE_CB() { return getToken(ProjGramParser.CLOSE_CB, 0); }
		public List<TerminalNode> ID() { return getTokens(ProjGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjGramParser.ID, i);
		}
		public List<TerminalNode> NUM() { return getTokens(ProjGramParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(ProjGramParser.NUM, i);
		}
		public RepetitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterRepetition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitRepetition(this);
		}
	}

	public final RepetitionContext repetition() throws RecognitionException {
		RepetitionContext _localctx = new RepetitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_repetition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__8);
			setState(99);
			match(OPEN_PAREN);
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(101);
			match(LOG_OP);
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(103);
			match(CLOSE_PAREN);
			setState(104);
			match(OPEN_CB);
			setState(105);
			instruction_block();
			setState(106);
			match(CLOSE_CB);
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
	public static class Instruction_blockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public Instruction_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterInstruction_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitInstruction_block(this);
		}
	}

	public final Instruction_blockContext instruction_block() throws RecognitionException {
		Instruction_blockContext _localctx = new Instruction_blockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_instruction_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			expr();
			setState(109);
			match(PV);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0018p\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\u001f\b\u0000\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000"+
		"\u000b\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00011\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00018\b\u0001\n\u0001\f\u0001;\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"C\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005Q\b\u0005\u000b\u0005\f\u0005R\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0005\b^\b\b\n\b\f\ba\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0000\u0002\u0002\u0000\u0012\u0013\u0018\u0018\u0001\u0000\u0012\u0013"+
		"n\u0000\u0016\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004"+
		"B\u0001\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000\bH\u0001\u0000"+
		"\u0000\u0000\nM\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000e"+
		"Y\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012b\u0001"+
		"\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016\u0018\u0005\u0001"+
		"\u0000\u0000\u0017\u0019\u0003\u0002\u0001\u0000\u0018\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\"\u0001\u0000\u0000"+
		"\u0000\u001c\u001f\u0003\u0004\u0002\u0000\u001d\u001f\u0003\f\u0006\u0000"+
		"\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000"+
		"\u001f \u0001\u0000\u0000\u0000 !\u0005\u0015\u0000\u0000!#\u0001\u0000"+
		"\u0000\u0000\"\u001e\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&\'\u0005\u0002\u0000\u0000\'\u0001\u0001\u0000\u0000\u0000()\u0005"+
		"\u0003\u0000\u0000)0\u0006\u0001\uffff\uffff\u0000*+\u0005\u0004\u0000"+
		"\u0000+1\u0006\u0001\uffff\uffff\u0000,-\u0005\u0005\u0000\u0000-1\u0006"+
		"\u0001\uffff\uffff\u0000./\u0005\u0006\u0000\u0000/1\u0006\u0001\uffff"+
		"\uffff\u00000*\u0001\u0000\u0000\u00000,\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0005\u0012\u0000\u0000"+
		"39\u0006\u0001\uffff\uffff\u000045\u0005\u0014\u0000\u000056\u0005\u0012"+
		"\u0000\u000068\u0006\u0001\uffff\uffff\u000074\u0001\u0000\u0000\u0000"+
		"8;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0006\u0001"+
		"\uffff\uffff\u0000=>\u0005\u0015\u0000\u0000>\u0003\u0001\u0000\u0000"+
		"\u0000?C\u0003\u0006\u0003\u0000@C\u0003\b\u0004\u0000AC\u0003\n\u0005"+
		"\u0000B?\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BA\u0001\u0000"+
		"\u0000\u0000C\u0005\u0001\u0000\u0000\u0000DE\u0005\u0012\u0000\u0000"+
		"EF\u0005\n\u0000\u0000FG\u0003\f\u0006\u0000G\u0007\u0001\u0000\u0000"+
		"\u0000HI\u0005\u0007\u0000\u0000IJ\u0005\r\u0000\u0000JK\u0005\u0012\u0000"+
		"\u0000KL\u0005\u000e\u0000\u0000L\t\u0001\u0000\u0000\u0000MN\u0005\b"+
		"\u0000\u0000NP\u0005\r\u0000\u0000OQ\u0003\u000e\u0007\u0000PO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0005\u000e\u0000\u0000"+
		"U\u000b\u0001\u0000\u0000\u0000VW\u0003\u000e\u0007\u0000WX\u0003\u0010"+
		"\b\u0000X\r\u0001\u0000\u0000\u0000YZ\u0007\u0000\u0000\u0000Z\u000f\u0001"+
		"\u0000\u0000\u0000[\\\u0005\u0011\u0000\u0000\\^\u0003\u000e\u0007\u0000"+
		"][\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`\u0011\u0001\u0000\u0000\u0000a_\u0001"+
		"\u0000\u0000\u0000bc\u0005\t\u0000\u0000cd\u0005\r\u0000\u0000de\u0007"+
		"\u0001\u0000\u0000ef\u0005\f\u0000\u0000fg\u0007\u0001\u0000\u0000gh\u0005"+
		"\u000e\u0000\u0000hi\u0005\u000f\u0000\u0000ij\u0003\u0014\n\u0000jk\u0005"+
		"\u0010\u0000\u0000k\u0013\u0001\u0000\u0000\u0000lm\u0003\f\u0006\u0000"+
		"mn\u0005\u0015\u0000\u0000n\u0015\u0001\u0000\u0000\u0000\b\u001a\u001e"+
		"$09BR_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}