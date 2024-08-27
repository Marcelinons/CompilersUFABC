// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;
	import compiler.core.exceptions.*;

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
		CLOSE_CB=16, OP=17, ID=18, INT=19, FLOAT=20, VIRG=21, PV=22, DP=23, WS=24, 
		TEXTO=25;
	public static final int
		RULE_program = 0, RULE_declare_var = 1, RULE_command = 2, RULE_cmdAttrib = 3, 
		RULE_cmdRead = 4, RULE_cmdWrite = 5, RULE_num_expr = 6, RULE_num_term = 7, 
		RULE_expr_md = 8, RULE_repetition = 9, RULE_instruction_block = 10, RULE_number = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare_var", "command", "cmdAttrib", "cmdRead", "cmdWrite", 
			"num_expr", "num_term", "expr_md", "repetition", "instruction_block", 
			"number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'LET'", "'INT'", "'TEXT'", "'FLOAT'", "'read'", 
			"'print'", "'while'", "'='", null, null, "'('", "')'", "'{'", "'}'", 
			null, null, null, null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ATTRIBUTION", 
			"TYPE", "LOG_OP", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", "CLOSE_CB", 
			"OP", "ID", "INT", "FLOAT", "VIRG", "PV", "DP", "WS", "TEXTO"
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
	    
	    public void updateType() {
	    	for(Variable v: currentDecl){
	    	   v.setType(currentType);
	    	   varMap.put(v.getId(), v);
	    	}
	    }
	    
	    public void updateValue(String id, String value) {
	    	if (isString(value)) {
			  varMap.get(id).setValue((String)value);
	    	} else if (isInteger(value)) {
	    	  varMap.get(id).setValue(Integer.parseInt(value));
	    	} else if (isFloat(value)) {
	    	  varMap.get(id).setValue(Double.parseDouble(value));
	    	}
	    }
	    
	    public void showVariables(){
	        for (String id: varMap.keySet()){
	        	System.out.println(varMap.get(id));
	        }
	    }
	    
	    // Variavel declarada returns True
	    public boolean isDeclared(String id) {
	    	return varMap.get(id) != null;
	    }
	    
	    // Checar tipo de variavel
	    public boolean typeMatch(String id, String value) {    	
	    	if (varMap.get(id) == null) {return false;} 
	    	Types tipo_var = varMap.get(id).getType();
	    	
	    	if (value.matches("[0-9]+") && (tipo_var == Types.INT)) {;
	    		return true;
	    	}
	    	else if (value.matches("[0-9]+ ('.' [0-9]+ )?") && (tipo_var == Types.FLOAT)) {
	    		return true;
	    	}
	    	else if (value.matches("\"([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-')* \"") && (tipo_var == Types.TEXT) ) {
	    		return true;
	    	}
	    	else {return false;}	
	    }
	    
	    // Checa se eh inteiro
	    public boolean isInteger(String value) {
	    	if (value.matches("[0-9]+")) {;
	    		return true;
	    	} else return false;
	    }
	    
	    // Checa se eh float
	    public boolean isFloat(String value) {
	    	if (value.matches("-?\\d*(\\.\\d+)?")) {
	    		return true;
	    	} else return false;
	    }
	    
	    /**
	    * Verifica se um valor eh uma string
	    */
	    public boolean isString(String value) {
	    	if (value.matches("^\".*\"$")) {
	    		return true;
	    	} else return false;
	    }
	    
	    public boolean isNumber(String value) {
	    	if (isFloat(value) || isInteger(value)) return true;
	    	else return false;
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
		public List<Num_exprContext> num_expr() {
			return getRuleContexts(Num_exprContext.class);
		}
		public Num_exprContext num_expr(int i) {
			return getRuleContext(Num_exprContext.class,i);
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
			setState(24);
			match(T__0);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				declare_var();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(30);
					command();
					}
					break;
				case 2:
					{
					setState(31);
					num_expr();
					}
					break;
				}
				setState(34);
				match(PV);
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1835392L) != 0) );
			setState(40);
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
			setState(42);
			match(T__2);
			 currentDecl.clear(); 
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(44);
				match(T__3);
				currentType = Types.INT;
				}
				break;
			case T__4:
				{
				setState(46);
				match(T__4);
				currentType = Types.TEXT;
				}
				break;
			case T__5:
				{
				setState(48);
				match(T__5);
				currentType = Types.FLOAT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(52);
			match(ID);
			 if (isDeclared(_input.LT(-1).getText())) {
				           throw new SemanticException(_input.LT(-1).getText()+" is already declared.");
				       }
				     
			 currentDecl.add(new Variable(_input.LT(-1).getText())); 
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(55);
				match(VIRG);
				setState(56);
				match(ID);
				 currentDecl.add(new Variable(_input.LT(-1).getText()));
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			updateType();
			setState(64);
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
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdAttrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdRead();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
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
		public Num_exprContext num_expr() {
			return getRuleContext(Num_exprContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(ProjGramParser.TEXTO, 0); }
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
			setState(71);
			match(ID);
			 
					String curr_id = _input.LT(-1).getText();
				    if (!isDeclared(curr_id)) {
				      throw new SemanticException(curr_id+" has not been declared.");
				    }
				    currentType = varMap.get(curr_id).getType();
				  
			setState(73);
			match(ATTRIBUTION);
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case INT:
			case FLOAT:
				{
				setState(74);
				num_expr();
				}
				break;
			case TEXTO:
				{
				setState(75);
				match(TEXTO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 
				    updateValue(curr_id, _input.LT(-1).getText()); 
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
			setState(80);
			match(T__6);
			setState(81);
			match(OPEN_PAREN);
			setState(82);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
				          throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
				        }
				      
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
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public List<Num_exprContext> num_expr() {
			return getRuleContexts(Num_exprContext.class);
		}
		public Num_exprContext num_expr(int i) {
			return getRuleContext(Num_exprContext.class,i);
		}
		public List<TerminalNode> TEXTO() { return getTokens(ProjGramParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(ProjGramParser.TEXTO, i);
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
			setState(86);
			match(T__7);
			setState(87);
			match(OPEN_PAREN);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(90);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
				case INT:
				case FLOAT:
					{
					setState(88);
					num_expr();
					}
					break;
				case TEXTO:
					{
					setState(89);
					match(TEXTO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 35389440L) != 0) );
			setState(94);
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
	public static class Num_exprContext extends ParserRuleContext {
		public Num_termContext num_term() {
			return getRuleContext(Num_termContext.class,0);
		}
		public Expr_mdContext expr_md() {
			return getRuleContext(Expr_mdContext.class,0);
		}
		public Num_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterNum_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitNum_expr(this);
		}
	}

	public final Num_exprContext num_expr() throws RecognitionException {
		Num_exprContext _localctx = new Num_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_num_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			num_term();
			setState(97);
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
	public static class Num_termContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Num_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterNum_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitNum_term(this);
		}
	}

	public final Num_termContext num_term() throws RecognitionException {
		Num_termContext _localctx = new Num_termContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_num_term);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(ID);
				 
				        if ( !isDeclared(_input.LT(-1).getText()) ) {
						  throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
					    }
					    if ( !isInteger(_input.LT(-1).getText()) || !isFloat(_input.LT(-1).getText()) ) {
					      throw new TypeMismatchException(_input.LT(-1).getText()+" is of type "+ varMap.get(_input.LT(-1).getText()).getType() +". INT or FLOAT expected.");
					    }
					  
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				number();
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
	public static class Expr_mdContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(ProjGramParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(ProjGramParser.OP, i);
		}
		public List<Num_termContext> num_term() {
			return getRuleContexts(Num_termContext.class);
		}
		public Num_termContext num_term(int i) {
			return getRuleContext(Num_termContext.class,i);
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
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(104);
				match(OP);
				setState(105);
				num_term();
				}
				}
				setState(110);
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
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__8);
			setState(112);
			match(OPEN_PAREN);
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(113);
				match(ID);
				}
				break;
			case INT:
			case FLOAT:
				{
				setState(114);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(117);
			match(LOG_OP);
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(118);
				match(ID);
				}
				break;
			case INT:
			case FLOAT:
				{
				setState(119);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(122);
			match(CLOSE_PAREN);
			setState(123);
			match(OPEN_CB);
			setState(124);
			instruction_block();
			setState(125);
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
		public Num_exprContext num_expr() {
			return getRuleContext(Num_exprContext.class,0);
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
			setState(127);
			num_expr();
			setState(128);
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
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ProjGramParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ProjGramParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u0085\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000"+
		"\u001c\u0001\u0000\u0001\u0000\u0003\u0000!\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000%\b\u0000\u000b\u0000\f\u0000&\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00013\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001;\b\u0001"+
		"\n\u0001\f\u0001>\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002F\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003M\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005"+
		"[\b\u0005\u000b\u0005\f\u0005\\\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007g\b"+
		"\u0007\u0001\b\u0001\b\u0005\bk\b\b\n\b\f\bn\t\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\tt\b\t\u0001\t\u0001\t\u0001\t\u0003\ty\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0000\u0001\u0001\u0000\u0013\u0014\u0087\u0000\u0018\u0001"+
		"\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004E\u0001\u0000\u0000"+
		"\u0000\u0006G\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\nV\u0001"+
		"\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000"+
		"\u0000\u0010l\u0001\u0000\u0000\u0000\u0012o\u0001\u0000\u0000\u0000\u0014"+
		"\u007f\u0001\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018"+
		"\u001a\u0005\u0001\u0000\u0000\u0019\u001b\u0003\u0002\u0001\u0000\u001a"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d"+
		"$\u0001\u0000\u0000\u0000\u001e!\u0003\u0004\u0002\u0000\u001f!\u0003"+
		"\f\u0006\u0000 \u001e\u0001\u0000\u0000\u0000 \u001f\u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005\u0016\u0000\u0000#%\u0001\u0000"+
		"\u0000\u0000$ \u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"()\u0005\u0002\u0000\u0000)\u0001\u0001\u0000\u0000\u0000*+\u0005\u0003"+
		"\u0000\u0000+2\u0006\u0001\uffff\uffff\u0000,-\u0005\u0004\u0000\u0000"+
		"-3\u0006\u0001\uffff\uffff\u0000./\u0005\u0005\u0000\u0000/3\u0006\u0001"+
		"\uffff\uffff\u000001\u0005\u0006\u0000\u000013\u0006\u0001\uffff\uffff"+
		"\u00002,\u0001\u0000\u0000\u00002.\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0012\u0000\u000056\u0006"+
		"\u0001\uffff\uffff\u00006<\u0006\u0001\uffff\uffff\u000078\u0005\u0015"+
		"\u0000\u000089\u0005\u0012\u0000\u00009;\u0006\u0001\uffff\uffff\u0000"+
		":7\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000?@\u0006\u0001\uffff\uffff\u0000@A\u0005\u0016\u0000\u0000"+
		"A\u0003\u0001\u0000\u0000\u0000BF\u0003\u0006\u0003\u0000CF\u0003\b\u0004"+
		"\u0000DF\u0003\n\u0005\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000F\u0005\u0001\u0000\u0000\u0000GH\u0005"+
		"\u0012\u0000\u0000HI\u0006\u0003\uffff\uffff\u0000IL\u0005\n\u0000\u0000"+
		"JM\u0003\f\u0006\u0000KM\u0005\u0019\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0006\u0003\uffff"+
		"\uffff\u0000O\u0007\u0001\u0000\u0000\u0000PQ\u0005\u0007\u0000\u0000"+
		"QR\u0005\r\u0000\u0000RS\u0005\u0012\u0000\u0000ST\u0006\u0004\uffff\uffff"+
		"\u0000TU\u0005\u000e\u0000\u0000U\t\u0001\u0000\u0000\u0000VW\u0005\b"+
		"\u0000\u0000WZ\u0005\r\u0000\u0000X[\u0003\f\u0006\u0000Y[\u0005\u0019"+
		"\u0000\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^_\u0005\u000e\u0000\u0000_\u000b\u0001\u0000"+
		"\u0000\u0000`a\u0003\u000e\u0007\u0000ab\u0003\u0010\b\u0000b\r\u0001"+
		"\u0000\u0000\u0000cd\u0005\u0012\u0000\u0000dg\u0006\u0007\uffff\uffff"+
		"\u0000eg\u0003\u0016\u000b\u0000fc\u0001\u0000\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000g\u000f\u0001\u0000\u0000\u0000hi\u0005\u0011\u0000\u0000"+
		"ik\u0003\u000e\u0007\u0000jh\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0011\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\t\u0000\u0000ps\u0005"+
		"\r\u0000\u0000qt\u0005\u0012\u0000\u0000rt\u0003\u0016\u000b\u0000sq\u0001"+
		"\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"ux\u0005\f\u0000\u0000vy\u0005\u0012\u0000\u0000wy\u0003\u0016\u000b\u0000"+
		"xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000z{\u0005\u000e\u0000\u0000{|\u0005\u000f\u0000\u0000|}\u0003\u0014"+
		"\n\u0000}~\u0005\u0010\u0000\u0000~\u0013\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0003\f\u0006\u0000\u0080\u0081\u0005\u0016\u0000\u0000\u0081\u0015"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0007\u0000\u0000\u0000\u0083\u0017"+
		"\u0001\u0000\u0000\u0000\r\u001c &2<ELZ\\flsx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}