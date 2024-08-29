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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ATTRIBUTION=9, 
		TYPE=10, LOG_OP=11, OPEN_PAREN=12, CLOSE_PAREN=13, OPEN_CB=14, CLOSE_CB=15, 
		OP=16, ID=17, INT=18, DOUBLE=19, VIRG=20, PV=21, DP=22, WS=23, STRING=24;
	public static final int
		RULE_program = 0, RULE_declare_var = 1, RULE_command = 2, RULE_cmdAttrib = 3, 
		RULE_cmdRead = 4, RULE_cmdWrite = 5, RULE_expression = 6, RULE_term = 7, 
		RULE_expression_md = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare_var", "command", "cmdAttrib", "cmdRead", "cmdWrite", 
			"expression", "term", "expression_md"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'LET'", "'INT'", "'STRING'", "'DOUBLE'", "'read'", 
			"'print'", "'='", null, null, "'('", "')'", "'{'", "'}'", null, null, 
			null, null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "ATTRIBUTION", 
			"TYPE", "LOG_OP", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", "CLOSE_CB", 
			"OP", "ID", "INT", "DOUBLE", "VIRG", "PV", "DP", "WS", "STRING"
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
			setState(18);
			match(T__0);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				declare_var();
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(26);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(24);
					command();
					}
					break;
				case 2:
					{
					setState(25);
					expression();
					}
					break;
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17695104L) != 0) );
			setState(30);
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
			setState(32);
			match(T__2);
			 currentDecl.clear(); 
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(34);
				match(T__3);
				currentType = Types.INT;
				}
				break;
			case T__4:
				{
				setState(36);
				match(T__4);
				currentType = Types.STRING;
				}
				break;
			case T__5:
				{
				setState(38);
				match(T__5);
				currentType = Types.DOUBLE;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(42);
			match(ID);
			 if (isDeclared(_input.LT(-1).getText())) {
				           throw new SemanticException(_input.LT(-1).getText()+" has already been declared.");
				       }
				     
			 currentDecl.add(new Variable(_input.LT(-1).getText())); 
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(45);
				match(VIRG);
				setState(46);
				match(ID);
				 currentDecl.add(new Variable(_input.LT(-1).getText()));
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			updateType();
			setState(54);
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
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(56);
				cmdAttrib();
				}
				break;
			case T__6:
				{
				setState(57);
				cmdRead();
				}
				break;
			case T__7:
				{
				setState(58);
				cmdWrite();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode ATTRIBUTION() { return getToken(ProjGramParser.ATTRIBUTION, 0); }
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
			setState(63);
			match(ID);
			 
				    String curr_id = _input.LT(-1).getText();
				    if ( !isDeclared(curr_id) ) {
				      throw new SemanticException(curr_id+" has not been declared.");
				    }
				    leftType = symbolTable.get(curr_id).getType();
				  
			setState(65);
			match(ATTRIBUTION);
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(66);
				expression();
				}
				break;
			case 2:
				{
				setState(67);
				match(STRING);
				}
				break;
			}

				  	if (leftType.getValue() < rightType.getValue()) {
				  	  throw new TypeMismatchException(symbolTable.get(curr_id).getId()+" expected "+leftType+". Received "+rightType+".");
				  	}
				  	symbolTable.get(curr_id).setInitialized(true);
					leftType = rightType = null;
				  
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
			 if (!isDeclared(_input.LT(-1).getText())) {
				          throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
				        }
				      
			setState(76);
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
			setState(78);
			match(T__7);
			setState(79);
			match(OPEN_PAREN);
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(80);
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
				setState(82);
				expression();
				}
				break;
			}
			setState(85);
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
		enterRule(_localctx, 12, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			term();
			setState(88);
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
		enterRule(_localctx, 14, RULE_term);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
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
				setState(92);
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
				setState(94);
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
				setState(96);
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
		enterRule(_localctx, 16, RULE_expression_md);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(100);
				match(OP);
				setState(101);
				term();
				}
				}
				setState(106);
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
		"\u0004\u0001\u0018l\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0004\u0000\u0015\b\u0000\u000b\u0000"+
		"\f\u0000\u0016\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b"+
		"\u0000\f\u0000\u001c\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001)\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u00011\b\u0001\n\u0001\f\u00014\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002<\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003E\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005T\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007c\b\u0007\u0001\b\u0001\b\u0005"+
		"\bg\b\b\n\b\f\bj\t\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0000\u0000p\u0000\u0012\u0001\u0000\u0000\u0000\u0002"+
		" \u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006?\u0001"+
		"\u0000\u0000\u0000\bH\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000"+
		"\fW\u0001\u0000\u0000\u0000\u000eb\u0001\u0000\u0000\u0000\u0010h\u0001"+
		"\u0000\u0000\u0000\u0012\u0014\u0005\u0001\u0000\u0000\u0013\u0015\u0003"+
		"\u0002\u0001\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001"+
		"\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001"+
		"\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u001b\u0003"+
		"\u0004\u0002\u0000\u0019\u001b\u0003\f\u0006\u0000\u001a\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0002"+
		"\u0000\u0000\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u0003\u0000\u0000"+
		"!(\u0006\u0001\uffff\uffff\u0000\"#\u0005\u0004\u0000\u0000#)\u0006\u0001"+
		"\uffff\uffff\u0000$%\u0005\u0005\u0000\u0000%)\u0006\u0001\uffff\uffff"+
		"\u0000&\'\u0005\u0006\u0000\u0000\')\u0006\u0001\uffff\uffff\u0000(\""+
		"\u0001\u0000\u0000\u0000($\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000)*\u0001\u0000\u0000\u0000*+\u0005\u0011\u0000\u0000+,\u0006\u0001"+
		"\uffff\uffff\u0000,2\u0006\u0001\uffff\uffff\u0000-.\u0005\u0014\u0000"+
		"\u0000./\u0005\u0011\u0000\u0000/1\u0006\u0001\uffff\uffff\u00000-\u0001"+
		"\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000056\u0006\u0001\uffff\uffff\u000067\u0005\u0015\u0000\u00007\u0003"+
		"\u0001\u0000\u0000\u00008<\u0003\u0006\u0003\u00009<\u0003\b\u0004\u0000"+
		":<\u0003\n\u0005\u0000;8\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0005\u0015\u0000"+
		"\u0000>\u0005\u0001\u0000\u0000\u0000?@\u0005\u0011\u0000\u0000@A\u0006"+
		"\u0003\uffff\uffff\u0000AD\u0005\t\u0000\u0000BE\u0003\f\u0006\u0000C"+
		"E\u0005\u0018\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0006\u0003\uffff\uffff\u0000G\u0007"+
		"\u0001\u0000\u0000\u0000HI\u0005\u0007\u0000\u0000IJ\u0005\f\u0000\u0000"+
		"JK\u0005\u0011\u0000\u0000KL\u0006\u0004\uffff\uffff\u0000LM\u0005\r\u0000"+
		"\u0000M\t\u0001\u0000\u0000\u0000NO\u0005\b\u0000\u0000OS\u0005\f\u0000"+
		"\u0000PQ\u0005\u0011\u0000\u0000QT\u0006\u0005\uffff\uffff\u0000RT\u0003"+
		"\f\u0006\u0000SP\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UV\u0005\r\u0000\u0000V\u000b\u0001\u0000\u0000\u0000"+
		"WX\u0003\u000e\u0007\u0000XY\u0003\u0010\b\u0000Y\r\u0001\u0000\u0000"+
		"\u0000Z[\u0005\u0011\u0000\u0000[c\u0006\u0007\uffff\uffff\u0000\\]\u0005"+
		"\u0012\u0000\u0000]c\u0006\u0007\uffff\uffff\u0000^_\u0005\u0013\u0000"+
		"\u0000_c\u0006\u0007\uffff\uffff\u0000`a\u0005\u0018\u0000\u0000ac\u0006"+
		"\u0007\uffff\uffff\u0000bZ\u0001\u0000\u0000\u0000b\\\u0001\u0000\u0000"+
		"\u0000b^\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000c\u000f\u0001"+
		"\u0000\u0000\u0000de\u0005\u0010\u0000\u0000eg\u0003\u000e\u0007\u0000"+
		"fd\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000i\u0011\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000\n\u0016\u001a\u001c(2;DSbh";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}