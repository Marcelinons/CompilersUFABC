// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import compiler.core.types.*;
	import compiler.core.ast.*;
	import compiler.core.exceptions.*;
	import compiler.core.expressions.*;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ATTRIBUTION=16, 
		LOGIC_OP=17, OPEN_PAREN=18, CLOSE_PAREN=19, OPEN_CB=20, CLOSE_CB=21, SUM=22, 
		SUB=23, DIV=24, MUL=25, MOD=26, ID=27, INT=28, DOUBLE=29, VIRG=30, PV=31, 
		DP=32, WS=33, STRING=34;
	public static final int
		RULE_program = 0, RULE_declare_var = 1, RULE_tipo = 2, RULE_varList = 3, 
		RULE_command = 4, RULE_cmdComment = 5, RULE_cmdAttrib = 6, RULE_cmdRead = 7, 
		RULE_cmdWrite = 8, RULE_cmdWrite_ln = 9, RULE_cmdIf = 10, RULE_cmdWhile = 11, 
		RULE_expression = 12, RULE_term = 13, RULE_expression_md = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare_var", "tipo", "varList", "command", "cmdComment", 
			"cmdAttrib", "cmdRead", "cmdWrite", "cmdWrite_ln", "cmdIf", "cmdWhile", 
			"expression", "term", "expression_md"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROGRAM'", "'BEGIN'", "'END'", "'LET'", "'INT'", "'DOUBLE'", 
			"'STRING'", "'--'", "'read'", "'print'", "'println'", "'if'", "'else'", 
			"'endif'", "'while'", "'='", null, "'('", "')'", "'{'", "'}'", "'+'", 
			"'-'", "'/'", "'*'", "'%'", null, null, null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ATTRIBUTION", "LOGIC_OP", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_CB", "CLOSE_CB", "SUM", "SUB", "DIV", "MUL", "MOD", "ID", "INT", 
			"DOUBLE", "VIRG", "PV", "DP", "WS", "STRING"
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
		private AbstractExpression head = null;
	    
		private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
	    private Types currentType, leftType=null, rightType=null;
	    
	    private Stack<ArrayList<Command>> commandStack = new Stack<ArrayList<Command>>();
	    
		private String exprString;
	    private Stack<AbstractExpression> exprStack = new Stack<AbstractExpression>();

		private Program program = new Program();
		

		public double generateValue() {
			if (head == null) {
				head = exprStack.pop();
			}
			return head.evaluate();
		}

		public String generateJson() {
			if (head == null) {
				head = exprStack.pop();
			}
			return head.toJson();
		}

		public String generateExpression() {
			if (head == null) {
				head = exprStack.pop();
			}
			return head.toString();
		}

	    public Program getProgram() {
	    	return this.program;
	    }
	    
	    public void updateType() {
	    	for(Variable v: currentDecl){
	    	   v.setType(currentType);
	    	   symbolTable.put(v.getId(), v);
	    	}
	    }
	    
	    /**
	    * Returns all declared IDs that have not been used on the program
	    */
	    public String declaredNotUsed() {
	    	StringBuilder str = new StringBuilder();
			str.append("Warning: {");
	    	for (String id: symbolTable.keySet()) {
	    	    if (!symbolTable.get(id).isInitialized()) { 
					str.append(symbolTable.get(id).getId() + ", ") ; 
				}
			}
	    	str.append("} have not been initialized.\n");
			return str.toString();
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

	public ProjGramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
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
		public List<TerminalNode> PV() { return getTokens(ProjGramParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(ProjGramParser.PV, i);
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
			setState(30);
			match(T__0);
			setState(31);
			match(ID);

						commandStack.push(new ArrayList<Command>());
						program.setName(_input.LT(-1).getText()); 
					
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				declare_var();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(38);
			match(T__1);
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(43);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(39);
					command();
					}
					break;
				case 2:
					{
					{
					setState(40);
					expression();
					setState(41);
					match(PV);
					}
					}
					break;
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 18119433984L) != 0) );
			setState(47);
			match(T__2);
			 
						program.setSymbolTable(symbolTable);
			            program.setCommandList(commandStack.pop()); 

						System.out.println(declaredNotUsed());
					
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
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public List<VarListContext> varList() {
			return getRuleContexts(VarListContext.class);
		}
		public VarListContext varList(int i) {
			return getRuleContext(VarListContext.class,i);
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
			setState(50);
			match(T__3);
			 currentDecl.clear(); 
			setState(52);
			tipo();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(53);
				varList();
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
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__4);
				currentType = Types.INT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__5);
				currentType = Types.DOUBLE;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(T__6);
				currentType = Types.STRING;
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
	public static class VarListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProjGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjGramParser.ID, i);
		}
		public List<TerminalNode> VIRG() { return getTokens(ProjGramParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(ProjGramParser.VIRG, i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitVarList(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(ID);
			   // Validar se ja foi declarada
						if (isDeclared(_input.LT(-1).getText())) {
							throw new RuntimeException(_input.LT(-1).getText()+" has already been declared.");
						} else {currentDecl.add(new Variable(_input.LT(-1).getText()));}
				    
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(72);
				match(VIRG);
				setState(73);
				match(ID);
				   // Validar se ja foi declarada
								if (isDeclared(_input.LT(-1).getText())) {
									throw new RuntimeException(_input.LT(-1).getText()+" has already been declared.");
								} else {currentDecl.add(new Variable(_input.LT(-1).getText()));}
							
				}
				}
				setState(79);
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
		public CmdWrite_lnContext cmdWrite_ln() {
			return getRuleContext(CmdWrite_lnContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdCommentContext cmdComment() {
			return getRuleContext(CmdCommentContext.class,0);
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
		enterRule(_localctx, 8, RULE_command);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				cmdAttrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				cmdRead();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				cmdWrite();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				cmdWrite_ln();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				cmdIf();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				cmdWhile();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				cmdComment();
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
	public static class CmdCommentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public CmdCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdComment(this);
		}
	}

	public final CmdCommentContext cmdComment() throws RecognitionException {
		CmdCommentContext _localctx = new CmdCommentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__7);
			exprString = "";
			setState(91);
			expression();
			 
									commandStack.peek().add(new CommentaryCmd(exprString.substring(1).replaceAll("\"", "")));
									leftType = rightType = null; 
								
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PV) {
				{
				setState(93);
				match(PV);
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
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjGramParser.ID, 0); }
		public TerminalNode ATTRIBUTION() { return getToken(ProjGramParser.ATTRIBUTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
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
		enterRule(_localctx, 12, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ID);
			 
						// Verificar se a variavel nao foi declarada
						String curr_id = _input.LT(-1).getText();
						if (!isDeclared(curr_id)) {
							throw new RuntimeException(curr_id+" has not been declared.");
						}
						leftType = symbolTable.get(curr_id).getType();
						exprString = "";	 
					
			setState(98);
			match(ATTRIBUTION);
			setState(99);
			expression();
				
						if (leftType.getValue() < rightType.getValue()) {
							throw new RuntimeException(symbolTable.get(curr_id).getId()+" expected "+leftType+". Received "+rightType+".");
						} else {
							symbolTable.get(curr_id).setInitialized(true);
							commandStack.peek().add(new AtribCommand(symbolTable.get(curr_id), rightType, exprString.substring(1)));
						}
						leftType = rightType = null;
				  	
			setState(101);
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
		enterRule(_localctx, 14, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__8);
			setState(104);
			match(OPEN_PAREN);
			setState(105);
			match(ID);
			 
						if (!isDeclared(_input.LT(-1).getText())) {
				          	throw new RuntimeException(_input.LT(-1).getText()+" has not been declared.");
				        } else {
							symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
							commandStack.peek().add(new InputCommand(symbolTable.get(_input.LT(-1).getText())));
						}	      	
				    
			setState(107);
			match(CLOSE_PAREN);
			setState(108);
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
		enterRule(_localctx, 16, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__9);
			exprString = "";
			setState(112);
			match(OPEN_PAREN);
			{
			setState(113);
			expression();

							commandStack.peek().add(new WriteCommand(exprString.substring(1)));
							leftType = rightType = null;
				  		
			}
			setState(116);
			match(CLOSE_PAREN);
			setState(117);
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
	public static class CmdWrite_lnContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(ProjGramParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public TerminalNode PV() { return getToken(ProjGramParser.PV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CmdWrite_lnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite_ln; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).enterCmdWrite_ln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjGramListener ) ((ProjGramListener)listener).exitCmdWrite_ln(this);
		}
	}

	public final CmdWrite_lnContext cmdWrite_ln() throws RecognitionException {
		CmdWrite_lnContext _localctx = new CmdWrite_lnContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdWrite_ln);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__10);
			exprString = "";
			setState(121);
			match(OPEN_PAREN);
			{
			setState(122);
			expression();

							commandStack.peek().add(new WriteLNCommand(exprString.substring(1)));
							leftType = rightType = null;
				  		
			}
			setState(125);
			match(CLOSE_PAREN);
			setState(126);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOGIC_OP() { return getToken(ProjGramParser.LOGIC_OP, 0); }
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
		enterRule(_localctx, 20, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__11);
			 
						commandStack.push(new ArrayList<Command>());
				        exprString = "";
				        IfCommand _cmdIf = new IfCommand();
				    
			setState(130);
			match(OPEN_PAREN);
			setState(131);
			expression();
			 
						// Expressao do If deve ser um inteiro ou double
						if (rightType == Types.STRING) {
							throw new RuntimeException("expected INT or DOUBLE.");
						} 
					
			setState(133);
			match(LOGIC_OP);
			 exprString += " " + _input.LT(-1).getText(); 
			setState(135);
			expression();
			 	
						// Expressao do If deve ser um inteiro ou double
						if (rightType == Types.STRING) {
							throw new RuntimeException("expected INT or DOUBLE, received STRING.");
						} 
					
			setState(137);
			match(CLOSE_PAREN);
			 _cmdIf.setExpression(exprString.substring(1)); 
			setState(139);
			match(OPEN_CB);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				command();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 134258432L) != 0) );
			 _cmdIf.setTrueList(commandStack.pop()); 
			setState(146);
			match(CLOSE_CB);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(147);
				match(T__12);
				setState(148);
				match(OPEN_CB);
				 commandStack.push(new ArrayList<Command>()); 
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150);
					command();
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 134258432L) != 0) );
				 _cmdIf.setFalseList(commandStack.pop()); 
				setState(156);
				match(CLOSE_CB);
				}
			}

			setState(160);
			match(T__13);
			 commandStack.peek().add(_cmdIf); 
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOGIC_OP() { return getToken(ProjGramParser.LOGIC_OP, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(ProjGramParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_CB() { return getToken(ProjGramParser.OPEN_CB, 0); }
		public TerminalNode CLOSE_CB() { return getToken(ProjGramParser.CLOSE_CB, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
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
		enterRule(_localctx, 22, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__14);
			 
						commandStack.push(new ArrayList<Command>());
						exprString = "";
						WhileCommand cmdWhile = new WhileCommand();
					
			setState(165);
			match(OPEN_PAREN);
			setState(166);
			expression();
			 
						if (rightType == Types.STRING) {
							throw new RuntimeException("expected INT or DOUBLE.");
						} 
					
			setState(168);
			match(LOGIC_OP);
			 exprString += " " + _input.LT(-1).getText(); 
			setState(170);
			expression();
			 
						if (rightType == Types.STRING) {
							throw new RuntimeException("expected INT or DOUBLE.");
						}
					
			setState(172);
			match(CLOSE_PAREN);
			 cmdWhile.setExpression(exprString.substring(1)); 
			setState(174);
			match(OPEN_CB);
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				command();
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 134258432L) != 0) );
			 cmdWhile.setCommandList(commandStack.pop()); 
			setState(181);
			match(CLOSE_CB);
			 commandStack.peek().add(cmdWhile); 
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
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			term();
			 exprString += " " + _input.LT(-1).getText();  
			setState(186);
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
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(ID);
				 
							if ( !isDeclared(_input.LT(-1).getText()) ) {
								throw new RuntimeException(_input.LT(-1).getText()+" has not been declared.");
							} else if ( !symbolTable.get(_input.LT(-1).getText()).isInitialized() ) {
								throw new RuntimeException(_input.LT(-1).getText()+" has no value associated with it.");
							}
							
							if ( rightType == null ) {
								rightType = symbolTable.get(_input.LT(-1).getText()).getType();
							} else if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
								rightType = symbolTable.get(_input.LT(-1).getText()).getType();
							}
						
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(INT);
				 	
							UnaryExpression elem = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
							exprStack.push(elem);

				        	if ( rightType == null ) {
					      		rightType = Types.INT;
					    	} else if (rightType.getValue() < Types.INT.getValue()) { 
								rightType = Types.INT;
							}
					    
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(DOUBLE);

							UnaryExpression elem = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
							exprStack.push(elem);

							if ( rightType == null ) {
								rightType = Types.DOUBLE;
							} else if (rightType.getValue() < Types.DOUBLE.getValue()) {
								rightType = Types.DOUBLE;
							}
						
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				match(STRING);

							if ( rightType == null ) {
							rightType = Types.STRING;
							} else if (rightType.getValue() < Types.STRING.getValue()) { 
								rightType = Types.STRING;
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
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> SUM() { return getTokens(ProjGramParser.SUM); }
		public TerminalNode SUM(int i) {
			return getToken(ProjGramParser.SUM, i);
		}
		public List<TerminalNode> MUL() { return getTokens(ProjGramParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(ProjGramParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(ProjGramParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(ProjGramParser.DIV, i);
		}
		public List<TerminalNode> SUB() { return getTokens(ProjGramParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(ProjGramParser.SUB, i);
		}
		public List<TerminalNode> MOD() { return getTokens(ProjGramParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(ProjGramParser.MOD, i);
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
		enterRule(_localctx, 28, RULE_expression_md);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130023424L) != 0)) {
				{
				{
				setState(198);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 130023424L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 
							BinaryExpression binExp = new BinaryExpression(_input.LT(-1).getText().charAt(0));
							binExp.setLeftSide(exprStack.pop());
							exprStack.push(binExp);
							
							exprString += " " + _input.LT(-1).getText();  
						
				setState(200);
				term();
				 
							AbstractExpression head = exprStack.pop();
							BinaryExpression root = (BinaryExpression) exprStack.pop();
							root.setRightSide(head);
							exprStack.push(root);

							exprString += " " + _input.LT(-1).getText();  
						
				}
				}
				setState(207);
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
		"\u0004\u0001\"\u00d1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000\u000b\u0000\f\u0000$\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000,\b"+
		"\u0000\u000b\u0000\f\u0000-\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00017\b\u0001\n\u0001"+
		"\f\u0001:\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002E\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003L\b\u0003\n\u0003\f\u0003O\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004X\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005_\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u008e\b\n\u000b\n\f\n\u008f\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0004\n\u0098\b\n\u000b\n\f\n\u0099\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u009f\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00b1"+
		"\b\u000b\u000b\u000b\f\u000b\u00b2\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c5\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00cc\b\u000e\n"+
		"\u000e\f\u000e\u00cf\t\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000"+
		"\u0001\u0001\u0000\u0016\u001a\u00d7\u0000\u001e\u0001\u0000\u0000\u0000"+
		"\u00022\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006F"+
		"\u0001\u0000\u0000\u0000\bW\u0001\u0000\u0000\u0000\nY\u0001\u0000\u0000"+
		"\u0000\f`\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000\u0000\u0010"+
		"n\u0001\u0000\u0000\u0000\u0012w\u0001\u0000\u0000\u0000\u0014\u0080\u0001"+
		"\u0000\u0000\u0000\u0016\u00a3\u0001\u0000\u0000\u0000\u0018\u00b8\u0001"+
		"\u0000\u0000\u0000\u001a\u00c4\u0001\u0000\u0000\u0000\u001c\u00cd\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f \u0005\u001b"+
		"\u0000\u0000 \"\u0006\u0000\uffff\uffff\u0000!#\u0003\u0002\u0001\u0000"+
		"\"!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&+\u0005\u0002"+
		"\u0000\u0000\',\u0003\b\u0004\u0000()\u0003\u0018\f\u0000)*\u0005\u001f"+
		"\u0000\u0000*,\u0001\u0000\u0000\u0000+\'\u0001\u0000\u0000\u0000+(\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0005\u0003\u0000"+
		"\u000001\u0006\u0000\uffff\uffff\u00001\u0001\u0001\u0000\u0000\u0000"+
		"23\u0005\u0004\u0000\u000034\u0006\u0001\uffff\uffff\u000048\u0003\u0004"+
		"\u0002\u000057\u0003\u0006\u0003\u000065\u0001\u0000\u0000\u00007:\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;<\u0006\u0001\uffff"+
		"\uffff\u0000<=\u0005\u001f\u0000\u0000=\u0003\u0001\u0000\u0000\u0000"+
		">?\u0005\u0005\u0000\u0000?E\u0006\u0002\uffff\uffff\u0000@A\u0005\u0006"+
		"\u0000\u0000AE\u0006\u0002\uffff\uffff\u0000BC\u0005\u0007\u0000\u0000"+
		"CE\u0006\u0002\uffff\uffff\u0000D>\u0001\u0000\u0000\u0000D@\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000E\u0005\u0001\u0000\u0000\u0000"+
		"FG\u0005\u001b\u0000\u0000GM\u0006\u0003\uffff\uffff\u0000HI\u0005\u001e"+
		"\u0000\u0000IJ\u0005\u001b\u0000\u0000JL\u0006\u0003\uffff\uffff\u0000"+
		"KH\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000N\u0007\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000PX\u0003\f\u0006\u0000QX\u0003\u000e\u0007\u0000RX\u0003"+
		"\u0010\b\u0000SX\u0003\u0012\t\u0000TX\u0003\u0014\n\u0000UX\u0003\u0016"+
		"\u000b\u0000VX\u0003\n\u0005\u0000WP\u0001\u0000\u0000\u0000WQ\u0001\u0000"+
		"\u0000\u0000WR\u0001\u0000\u0000\u0000WS\u0001\u0000\u0000\u0000WT\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000"+
		"X\t\u0001\u0000\u0000\u0000YZ\u0005\b\u0000\u0000Z[\u0006\u0005\uffff"+
		"\uffff\u0000[\\\u0003\u0018\f\u0000\\^\u0006\u0005\uffff\uffff\u0000]"+
		"_\u0005\u001f\u0000\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005\u001b\u0000\u0000ab\u0006"+
		"\u0006\uffff\uffff\u0000bc\u0005\u0010\u0000\u0000cd\u0003\u0018\f\u0000"+
		"de\u0006\u0006\uffff\uffff\u0000ef\u0005\u001f\u0000\u0000f\r\u0001\u0000"+
		"\u0000\u0000gh\u0005\t\u0000\u0000hi\u0005\u0012\u0000\u0000ij\u0005\u001b"+
		"\u0000\u0000jk\u0006\u0007\uffff\uffff\u0000kl\u0005\u0013\u0000\u0000"+
		"lm\u0005\u001f\u0000\u0000m\u000f\u0001\u0000\u0000\u0000no\u0005\n\u0000"+
		"\u0000op\u0006\b\uffff\uffff\u0000pq\u0005\u0012\u0000\u0000qr\u0003\u0018"+
		"\f\u0000rs\u0006\b\uffff\uffff\u0000st\u0001\u0000\u0000\u0000tu\u0005"+
		"\u0013\u0000\u0000uv\u0005\u001f\u0000\u0000v\u0011\u0001\u0000\u0000"+
		"\u0000wx\u0005\u000b\u0000\u0000xy\u0006\t\uffff\uffff\u0000yz\u0005\u0012"+
		"\u0000\u0000z{\u0003\u0018\f\u0000{|\u0006\t\uffff\uffff\u0000|}\u0001"+
		"\u0000\u0000\u0000}~\u0005\u0013\u0000\u0000~\u007f\u0005\u001f\u0000"+
		"\u0000\u007f\u0013\u0001\u0000\u0000\u0000\u0080\u0081\u0005\f\u0000\u0000"+
		"\u0081\u0082\u0006\n\uffff\uffff\u0000\u0082\u0083\u0005\u0012\u0000\u0000"+
		"\u0083\u0084\u0003\u0018\f\u0000\u0084\u0085\u0006\n\uffff\uffff\u0000"+
		"\u0085\u0086\u0005\u0011\u0000\u0000\u0086\u0087\u0006\n\uffff\uffff\u0000"+
		"\u0087\u0088\u0003\u0018\f\u0000\u0088\u0089\u0006\n\uffff\uffff\u0000"+
		"\u0089\u008a\u0005\u0013\u0000\u0000\u008a\u008b\u0006\n\uffff\uffff\u0000"+
		"\u008b\u008d\u0005\u0014\u0000\u0000\u008c\u008e\u0003\b\u0004\u0000\u008d"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0006\n\uffff\uffff\u0000\u0092"+
		"\u009e\u0005\u0015\u0000\u0000\u0093\u0094\u0005\r\u0000\u0000\u0094\u0095"+
		"\u0005\u0014\u0000\u0000\u0095\u0097\u0006\n\uffff\uffff\u0000\u0096\u0098"+
		"\u0003\b\u0004\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0006"+
		"\n\uffff\uffff\u0000\u009c\u009d\u0005\u0015\u0000\u0000\u009d\u009f\u0001"+
		"\u0000\u0000\u0000\u009e\u0093\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"\u000e\u0000\u0000\u00a1\u00a2\u0006\n\uffff\uffff\u0000\u00a2\u0015\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0005\u000f\u0000\u0000\u00a4\u00a5\u0006"+
		"\u000b\uffff\uffff\u0000\u00a5\u00a6\u0005\u0012\u0000\u0000\u00a6\u00a7"+
		"\u0003\u0018\f\u0000\u00a7\u00a8\u0006\u000b\uffff\uffff\u0000\u00a8\u00a9"+
		"\u0005\u0011\u0000\u0000\u00a9\u00aa\u0006\u000b\uffff\uffff\u0000\u00aa"+
		"\u00ab\u0003\u0018\f\u0000\u00ab\u00ac\u0006\u000b\uffff\uffff\u0000\u00ac"+
		"\u00ad\u0005\u0013\u0000\u0000\u00ad\u00ae\u0006\u000b\uffff\uffff\u0000"+
		"\u00ae\u00b0\u0005\u0014\u0000\u0000\u00af\u00b1\u0003\b\u0004\u0000\u00b0"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0006\u000b\uffff\uffff\u0000"+
		"\u00b5\u00b6\u0005\u0015\u0000\u0000\u00b6\u00b7\u0006\u000b\uffff\uffff"+
		"\u0000\u00b7\u0017\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003\u001a\r\u0000"+
		"\u00b9\u00ba\u0006\f\uffff\uffff\u0000\u00ba\u00bb\u0003\u001c\u000e\u0000"+
		"\u00bb\u0019\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u001b\u0000\u0000"+
		"\u00bd\u00c5\u0006\r\uffff\uffff\u0000\u00be\u00bf\u0005\u001c\u0000\u0000"+
		"\u00bf\u00c5\u0006\r\uffff\uffff\u0000\u00c0\u00c1\u0005\u001d\u0000\u0000"+
		"\u00c1\u00c5\u0006\r\uffff\uffff\u0000\u00c2\u00c3\u0005\"\u0000\u0000"+
		"\u00c3\u00c5\u0006\r\uffff\uffff\u0000\u00c4\u00bc\u0001\u0000\u0000\u0000"+
		"\u00c4\u00be\u0001\u0000\u0000\u0000\u00c4\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u001b\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0007\u0000\u0000\u0000\u00c7\u00c8\u0006\u000e\uffff\uffff"+
		"\u0000\u00c8\u00c9\u0003\u001a\r\u0000\u00c9\u00ca\u0006\u000e\uffff\uffff"+
		"\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c6\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u001d\u0001\u0000\u0000"+
		"\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u000e$+-8DMW^\u008f\u0099\u009e"+
		"\u00b2\u00c4\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}