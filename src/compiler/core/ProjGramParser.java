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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ATTRIBUTION=15, TYPE=16, 
		LOG_OP=17, OPEN_PAREN=18, CLOSE_PAREN=19, OPEN_CB=20, CLOSE_CB=21, OP=22, 
		ID=23, INT=24, DOUBLE=25, VIRG=26, PV=27, DP=28, WS=29, STRING=30;
	public static final int
		RULE_program = 0, RULE_declare_var = 1, RULE_command = 2, RULE_cmdAttrib = 3, 
		RULE_cmdRead = 4, RULE_cmdWrite = 5, RULE_cmdIf = 6, RULE_cmdWhile = 7, 
		RULE_logical_expression = 8, RULE_expression = 9, RULE_term = 10, RULE_expression_md = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare_var", "command", "cmdAttrib", "cmdRead", "cmdWrite", 
			"cmdIf", "cmdWhile", "logical_expression", "expression", "term", "expression_md"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROGRAM'", "'BEGIN'", "'END'", "'LET'", "'INT'", "'STRING'", 
			"'DOUBLE'", "'read'", "'print'", "'if'", "'else'", "'while'", "'&&'", 
			"'||'", "'='", null, null, "'('", "')'", "'{'", "'}'", null, null, null, 
			null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ATTRIBUTION", "TYPE", "LOG_OP", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_CB", "CLOSE_CB", "OP", "ID", "INT", "DOUBLE", "VIRG", "PV", "DP", 
			"WS", "STRING"
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


	    private HashMap<String, Variable> symbolTable = new HashMap<String, Variable>();
	    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
	    private Types currentType, leftType=null, rightType=null;
	    
	    public void updateType() {
	    	for(Variable v: currentDecl){
	    	   v.setType(currentType);
	    	   symbolTable.put(v.getId(), v);
	    	}
	    }
	    
	    /**
	    * Returns all declared IDs that have not been used on the program
	    */
	    public void declaredNotUsed() {
	    	boolean first = true;
	    	for (String id: symbolTable.keySet()) {
	    	    if (!symbolTable.get(id).isInitialized()) {
	    	      if (first) { 
	    	        System.out.print("\nWarning: the following variables have not been used: \n[");
	    	        first = false;
	    	      }
	    	      System.out.print(symbolTable.get(id).getId()+", ");
	    	    }
	    	}
	    	if (!first) System.out.println("]");
	    }
	    
	    /**
	    * Prints all of declared variables
	    */
	    public void showVariables(){
	        for (String id: symbolTable.keySet()){
	        	System.out.println(symbolTable.get(id));
	        }
	    }
	    
	    /**
	    * Checks if given Id is declared
	    */
	    public boolean isDeclared(String id) {
	    	return symbolTable.get(id) != null;
	    }
	    
	    /**
	    * Checks if given value is of type INT
	    */
	    public boolean isNumeric(String value) {
	    	if (value.matches("-?\\d*(\\.\\d+)?")) {
	    		return true;
	    	} else return false;
	    }
	    
	    /**
	    * Checks if a given value is of type STRING
	    */
	    public boolean isString(String value) {
	    	if (value.matches("^\".*\"$")) {
	    		return true;
	    	} else return false;
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
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
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
			} while ( _la==T__3 );
			setState(30);
			match(T__1);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				command();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8394496L) != 0) );
			setState(36);
			match(T__2);
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
			setState(38);
			match(T__3);
			 currentDecl.clear(); 
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(40);
				match(T__4);
				currentType = Types.INT;
				}
				break;
			case T__5:
				{
				setState(42);
				match(T__5);
				currentType = Types.STRING;
				}
				break;
			case T__6:
				{
				setState(44);
				match(T__6);
				currentType = Types.DOUBLE;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(48);
			match(ID);
			 if (isDeclared(_input.LT(-1).getText())) {
				           throw new SemanticException(_input.LT(-1).getText()+" has already been declared.");
				       }
				     
			 currentDecl.add(new Variable(_input.LT(-1).getText())); 
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(51);
				match(VIRG);
				setState(52);
				match(ID);
				 currentDecl.add(new Variable(_input.LT(-1).getText()));
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			updateType();
			setState(60);
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
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdAttrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdRead();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdWrite();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdIf();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdWhile();
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
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ProjGramParser.STRING, 0); }
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
			setState(69);
			match(ID);
			 
				    String curr_id = _input.LT(-1).getText();
				    if ( !isDeclared(curr_id) ) {
				      throw new SemanticException(curr_id+" has not been declared.");
				    }
				    leftType = symbolTable.get(curr_id).getType();
				  
			setState(71);
			match(ATTRIBUTION);
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(72);
				expression();
				}
				break;
			case 2:
				{
				setState(73);
				match(STRING);
				}
				break;
			}

				  	if (leftType.getValue() < rightType.getValue()) {
				  	  throw new TypeMismatchException(symbolTable.get(curr_id).getId()+" expected "+leftType+". Received "+rightType+".");
				  	}
				  	symbolTable.get(curr_id).setInitialized(true);
					leftType = rightType = null;
				  
			setState(77);
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
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
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
			setState(79);
			match(T__7);
			setState(80);
			match(OPEN_PAREN);
			setState(81);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
				          throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
				        }
				      
			setState(83);
			match(CLOSE_PAREN);
			setState(84);
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
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__8);
			setState(87);
			match(OPEN_PAREN);
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(88);
				match(ID);
				 
					     if ( !isDeclared(_input.LT(-1).getText()) ) {
					       throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
					     } 
					     if ( !symbolTable.get(_input.LT(-1).getText()).isInitialized() ) {
					       throw new SemanticException(_input.LT(-1).getText()+" has no value associated with it.");
					     }
					   
				}
				break;
			case 2:
				{
				setState(90);
				expression();
				leftType = rightType = null;
				}
				break;
			}
			setState(95);
			match(CLOSE_PAREN);
			setState(96);
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
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public List<TerminalNode> OPEN_CB() { return getTokens(ProjGramParser.OPEN_CB); }
		public TerminalNode OPEN_CB(int i) {
			return getToken(ProjGramParser.OPEN_CB, i);
		}
		public List<TerminalNode> CLOSE_CB() { return getTokens(ProjGramParser.CLOSE_CB); }
		public TerminalNode CLOSE_CB(int i) {
			return getToken(ProjGramParser.CLOSE_CB, i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__9);
			setState(99);
			match(OPEN_PAREN);
			setState(100);
			logical_expression();
			setState(101);
			match(CLOSE_PAREN);
			setState(102);
			match(OPEN_CB);
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(103);
					command();
					}
					break;
				case 2:
					{
					setState(104);
					expression();
					}
					break;
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1132467968L) != 0) );
			setState(109);
			match(CLOSE_CB);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(110);
				match(T__10);
				setState(111);
				cmdIf();
				}
				break;
			}
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(114);
				match(T__10);
				setState(115);
				match(OPEN_CB);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1132467968L) != 0)) {
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(116);
						command();
						}
						break;
					case 2:
						{
						setState(117);
						expression();
						}
						break;
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(CLOSE_CB);
				}
				break;
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
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_CB() { return getToken(ProjGramParser.OPEN_CB, 0); }
		public TerminalNode CLOSE_CB() { return getToken(ProjGramParser.CLOSE_CB, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__11);
			setState(127);
			match(OPEN_PAREN);
			setState(128);
			logical_expression();
			setState(129);
			match(CLOSE_PAREN);
			setState(130);
			match(OPEN_CB);
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(131);
					command();
					}
					break;
				case 2:
					{
					setState(132);
					expression();
					}
					break;
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1132467968L) != 0) );
			setState(137);
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
	public static class Logical_expressionContext extends ParserRuleContext {
		public List<TerminalNode> LOG_OP() { return getTokens(ProjGramParser.LOG_OP); }
		public TerminalNode LOG_OP(int i) {
			return getToken(ProjGramParser.LOG_OP, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(ProjGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjGramParser.ID, i);
		}
		public Logical_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterLogical_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitLogical_expression(this);
		}
	}

	public final Logical_expressionContext logical_expression() throws RecognitionException {
		Logical_expressionContext _localctx = new Logical_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logical_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(139);
				expression();
				}
				break;
			case 2:
				{
				setState(140);
				match(ID);
				}
				break;
			}
			setState(143);
			match(LOG_OP);
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(144);
				expression();
				}
				break;
			case 2:
				{
				setState(145);
				match(ID);
				}
				break;
			}
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(148);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(151);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(149);
						expression();
						}
						break;
					case 2:
						{
						setState(150);
						match(ID);
						}
						break;
					}
					setState(153);
					match(LOG_OP);
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(154);
						expression();
						}
						break;
					case 2:
						{
						setState(155);
						match(ID);
						}
						break;
					}
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Expression_mdContext expression_md() {
			return getRuleContext(Expression_mdContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			term();
			setState(164);
			expression_md();
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
	public static class TermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode INT() { return getToken(ProjGramParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ProjGramParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(ProjGramParser.STRING, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(ID);
				 
				        if ( !isDeclared(_input.LT(-1).getText()) ) {
						  throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
					    } 
					    if ( !symbolTable.get(_input.LT(-1).getText()).isInitialized() ) {
					      throw new SemanticException(_input.LT(-1).getText()+" has no value associated with it.");
					    }
					    if ( rightType == null ) {
					      rightType = symbolTable.get(_input.LT(-1).getText()).getType();
					    } else {
					      if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
					        rightType = symbolTable.get(_input.LT(-1).getText()).getType();
					      }
					    }
					  
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(INT);
				 
				        if ( rightType == null ) {
					      rightType = Types.INT;
					    } else { 
					      if (rightType.getValue() < Types.INT.getValue()) {
					        rightType = Types.INT;
					      }
					    } 
					  
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(DOUBLE);

						if ( rightType == null ) {
						  rightType = Types.DOUBLE;
						} else {
						  if (rightType.getValue() < Types.DOUBLE.getValue()) {
						    rightType = Types.DOUBLE;
						  }
						}
					
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(STRING);

					    if ( rightType == null ) {
					      rightType = Types.STRING;
					    } else { 
					      if (rightType.getValue() < Types.STRING.getValue()) {
					        rightType = Types.STRING;
					      }
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_mdContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(ProjGramParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(ProjGramParser.OP, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Expression_mdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_md; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterExpression_md(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitExpression_md(this);
		}
	}

	public final Expression_mdContext expression_md() throws RecognitionException {
		Expression_mdContext _localctx = new Expression_mdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression_md);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(176);
				match(OP);
				setState(177);
				term();
				}
				}
				setState(182);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00b8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000"+
		"\u001c\u0001\u0000\u0001\u0000\u0004\u0000!\b\u0000\u000b\u0000\f\u0000"+
		"\"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00017\b\u0001\n\u0001\f\u0001:\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002D\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003K\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005^\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006j\b\u0006\u000b\u0006\f\u0006k\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006q\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006w\b\u0006\n\u0006\f\u0006z\t"+
		"\u0006\u0001\u0006\u0003\u0006}\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u0086"+
		"\b\u0007\u000b\u0007\f\u0007\u0087\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0003\b\u008e\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u0093\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u0098\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u009d"+
		"\b\b\u0005\b\u009f\b\b\n\b\f\b\u00a2\t\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00af"+
		"\b\n\u0001\u000b\u0001\u000b\u0005\u000b\u00b3\b\u000b\n\u000b\f\u000b"+
		"\u00b6\t\u000b\u0001\u000b\u0001\u00a0\u0000\f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001\u0001\u0000\r\u000e\u00c7"+
		"\u0000\u0018\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004"+
		"C\u0001\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000\bO\u0001\u0000"+
		"\u0000\u0000\nV\u0001\u0000\u0000\u0000\fb\u0001\u0000\u0000\u0000\u000e"+
		"~\u0001\u0000\u0000\u0000\u0010\u008d\u0001\u0000\u0000\u0000\u0012\u00a3"+
		"\u0001\u0000\u0000\u0000\u0014\u00ae\u0001\u0000\u0000\u0000\u0016\u00b4"+
		"\u0001\u0000\u0000\u0000\u0018\u001a\u0005\u0001\u0000\u0000\u0019\u001b"+
		"\u0003\u0002\u0001\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e \u0005"+
		"\u0002\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \u001f\u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0005\u0003\u0000\u0000"+
		"%\u0001\u0001\u0000\u0000\u0000&\'\u0005\u0004\u0000\u0000\'.\u0006\u0001"+
		"\uffff\uffff\u0000()\u0005\u0005\u0000\u0000)/\u0006\u0001\uffff\uffff"+
		"\u0000*+\u0005\u0006\u0000\u0000+/\u0006\u0001\uffff\uffff\u0000,-\u0005"+
		"\u0007\u0000\u0000-/\u0006\u0001\uffff\uffff\u0000.(\u0001\u0000\u0000"+
		"\u0000.*\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000001\u0005\u0017\u0000\u000012\u0006\u0001\uffff\uffff\u0000"+
		"28\u0006\u0001\uffff\uffff\u000034\u0005\u001a\u0000\u000045\u0005\u0017"+
		"\u0000\u000057\u0006\u0001\uffff\uffff\u000063\u0001\u0000\u0000\u0000"+
		"7:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;<\u0006\u0001"+
		"\uffff\uffff\u0000<=\u0005\u001b\u0000\u0000=\u0003\u0001\u0000\u0000"+
		"\u0000>D\u0003\u0006\u0003\u0000?D\u0003\b\u0004\u0000@D\u0003\n\u0005"+
		"\u0000AD\u0003\f\u0006\u0000BD\u0003\u000e\u0007\u0000C>\u0001\u0000\u0000"+
		"\u0000C?\u0001\u0000\u0000\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000CB\u0001\u0000\u0000\u0000D\u0005\u0001\u0000\u0000\u0000"+
		"EF\u0005\u0017\u0000\u0000FG\u0006\u0003\uffff\uffff\u0000GJ\u0005\u000f"+
		"\u0000\u0000HK\u0003\u0012\t\u0000IK\u0005\u001e\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0006"+
		"\u0003\uffff\uffff\u0000MN\u0005\u001b\u0000\u0000N\u0007\u0001\u0000"+
		"\u0000\u0000OP\u0005\b\u0000\u0000PQ\u0005\u0012\u0000\u0000QR\u0005\u0017"+
		"\u0000\u0000RS\u0006\u0004\uffff\uffff\u0000ST\u0005\u0013\u0000\u0000"+
		"TU\u0005\u001b\u0000\u0000U\t\u0001\u0000\u0000\u0000VW\u0005\t\u0000"+
		"\u0000W]\u0005\u0012\u0000\u0000XY\u0005\u0017\u0000\u0000Y^\u0006\u0005"+
		"\uffff\uffff\u0000Z[\u0003\u0012\t\u0000[\\\u0006\u0005\uffff\uffff\u0000"+
		"\\^\u0001\u0000\u0000\u0000]X\u0001\u0000\u0000\u0000]Z\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0013\u0000\u0000`a\u0005\u001b"+
		"\u0000\u0000a\u000b\u0001\u0000\u0000\u0000bc\u0005\n\u0000\u0000cd\u0005"+
		"\u0012\u0000\u0000de\u0003\u0010\b\u0000ef\u0005\u0013\u0000\u0000fi\u0005"+
		"\u0014\u0000\u0000gj\u0003\u0004\u0002\u0000hj\u0003\u0012\t\u0000ig\u0001"+
		"\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mp\u0005\u0015\u0000\u0000no\u0005\u000b\u0000\u0000oq\u0003\f\u0006"+
		"\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q|\u0001\u0000"+
		"\u0000\u0000rs\u0005\u000b\u0000\u0000sx\u0005\u0014\u0000\u0000tw\u0003"+
		"\u0004\u0002\u0000uw\u0003\u0012\t\u0000vt\u0001\u0000\u0000\u0000vu\u0001"+
		"\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000{}\u0005\u0015\u0000\u0000|r\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}\r\u0001\u0000\u0000\u0000~\u007f\u0005\f\u0000\u0000\u007f"+
		"\u0080\u0005\u0012\u0000\u0000\u0080\u0081\u0003\u0010\b\u0000\u0081\u0082"+
		"\u0005\u0013\u0000\u0000\u0082\u0085\u0005\u0014\u0000\u0000\u0083\u0086"+
		"\u0003\u0004\u0002\u0000\u0084\u0086\u0003\u0012\t\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u0015\u0000\u0000\u008a\u000f\u0001\u0000\u0000\u0000\u008b\u008e\u0003"+
		"\u0012\t\u0000\u008c\u008e\u0005\u0017\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u0092\u0005\u0011\u0000\u0000\u0090\u0093\u0003\u0012"+
		"\t\u0000\u0091\u0093\u0005\u0017\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u00a0\u0001\u0000\u0000"+
		"\u0000\u0094\u0097\u0007\u0000\u0000\u0000\u0095\u0098\u0003\u0012\t\u0000"+
		"\u0096\u0098\u0005\u0017\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009c\u0005\u0011\u0000\u0000\u009a\u009d\u0003\u0012\t\u0000\u009b"+
		"\u009d\u0005\u0017\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009b\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e"+
		"\u0094\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1"+
		"\u0011\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0003\u0014\n\u0000\u00a4\u00a5\u0003\u0016\u000b\u0000\u00a5\u0013"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0017\u0000\u0000\u00a7\u00af"+
		"\u0006\n\uffff\uffff\u0000\u00a8\u00a9\u0005\u0018\u0000\u0000\u00a9\u00af"+
		"\u0006\n\uffff\uffff\u0000\u00aa\u00ab\u0005\u0019\u0000\u0000\u00ab\u00af"+
		"\u0006\n\uffff\uffff\u0000\u00ac\u00ad\u0005\u001e\u0000\u0000\u00ad\u00af"+
		"\u0006\n\uffff\uffff\u0000\u00ae\u00a6\u0001\u0000\u0000\u0000\u00ae\u00a8"+
		"\u0001\u0000\u0000\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00ae\u00ac"+
		"\u0001\u0000\u0000\u0000\u00af\u0015\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005\u0016\u0000\u0000\u00b1\u00b3\u0003\u0014\n\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u0017\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u0016\u001c\"."+
		"8CJ]ikpvx|\u0085\u0087\u008d\u0092\u0097\u009c\u00a0\u00ae\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}