// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import compiler.core.types.*;
	import compiler.core.ast.*;
	import compiler.core.exceptions.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ProjGramLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ATTRIBUTION=15, TYPE=16, 
		LOGIC_OP=17, OPEN_PAREN=18, CLOSE_PAREN=19, OPEN_CB=20, CLOSE_CB=21, OP=22, 
		ID=23, INT=24, DOUBLE=25, VIRG=26, PV=27, DP=28, WS=29, STRING=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "ATTRIBUTION", "TYPE", "LOGIC_OP", 
			"OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", "CLOSE_CB", "OP", "ID", "INT", 
			"DOUBLE", "VIRG", "PV", "DP", "WS", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROGRAM'", "'BEGIN'", "'END'", "'LET'", "'INT'", "'STRING'", 
			"'DOUBLE'", "'read'", "'print'", "'println'", "'if'", "'else'", "'endif'", 
			"'while'", "'='", null, null, "'('", "')'", "'{'", "'}'", null, null, 
			null, null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ATTRIBUTION", "TYPE", "LOGIC_OP", "OPEN_PAREN", "CLOSE_PAREN", 
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


	    private HashMap<String, Variable> symbolTable = new HashMap<String, Variable>();
	    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
	    private Types currentType, leftType=null, rightType=null;
	    private Program program = new Program();
	    private Stack<ArrayList<Command>> commandStack = new Stack<ArrayList<Command>>();
	    private String exprString;
	    
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


	public ProjGramLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ProjGram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 15:
			TYPE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TYPE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			currentType = Types.INT;
			break;
		case 1:
			currentType = Types.STRING;
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u001e\u00e5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u009c\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00a8\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u00b6\b\u0016\n\u0016\f\u0016\u00b9"+
		"\t\u0016\u0001\u0017\u0003\u0017\u00bc\b\u0017\u0001\u0017\u0004\u0017"+
		"\u00bf\b\u0017\u000b\u0017\f\u0017\u00c0\u0001\u0018\u0003\u0018\u00c4"+
		"\b\u0018\u0001\u0018\u0004\u0018\u00c7\b\u0018\u000b\u0018\f\u0018\u00c8"+
		"\u0001\u0018\u0001\u0018\u0004\u0018\u00cd\b\u0018\u000b\u0018\f\u0018"+
		"\u00ce\u0003\u0018\u00d1\b\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0005\u001d\u00df\b\u001d\n\u001d\f\u001d"+
		"\u00e2\t\u001d\u0001\u001d\u0001\u001d\u0001\u00e0\u0000\u001e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u001c9\u001d;\u001e\u0001\u0000\u0005\u0004\u0000"+
		"%%*+--//\u0001\u0000az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n"+
		"\r\r  \u00f2\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0001=\u0001\u0000\u0000\u0000\u0003E\u0001\u0000\u0000\u0000\u0005"+
		"K\u0001\u0000\u0000\u0000\u0007O\u0001\u0000\u0000\u0000\tS\u0001\u0000"+
		"\u0000\u0000\u000bW\u0001\u0000\u0000\u0000\r^\u0001\u0000\u0000\u0000"+
		"\u000fe\u0001\u0000\u0000\u0000\u0011j\u0001\u0000\u0000\u0000\u0013p"+
		"\u0001\u0000\u0000\u0000\u0015x\u0001\u0000\u0000\u0000\u0017{\u0001\u0000"+
		"\u0000\u0000\u0019\u0080\u0001\u0000\u0000\u0000\u001b\u0086\u0001\u0000"+
		"\u0000\u0000\u001d\u008c\u0001\u0000\u0000\u0000\u001f\u009b\u0001\u0000"+
		"\u0000\u0000!\u00a7\u0001\u0000\u0000\u0000#\u00a9\u0001\u0000\u0000\u0000"+
		"%\u00ab\u0001\u0000\u0000\u0000\'\u00ad\u0001\u0000\u0000\u0000)\u00af"+
		"\u0001\u0000\u0000\u0000+\u00b1\u0001\u0000\u0000\u0000-\u00b3\u0001\u0000"+
		"\u0000\u0000/\u00bb\u0001\u0000\u0000\u00001\u00c3\u0001\u0000\u0000\u0000"+
		"3\u00d2\u0001\u0000\u0000\u00005\u00d4\u0001\u0000\u0000\u00007\u00d6"+
		"\u0001\u0000\u0000\u00009\u00d8\u0001\u0000\u0000\u0000;\u00dc\u0001\u0000"+
		"\u0000\u0000=>\u0005P\u0000\u0000>?\u0005R\u0000\u0000?@\u0005O\u0000"+
		"\u0000@A\u0005G\u0000\u0000AB\u0005R\u0000\u0000BC\u0005A\u0000\u0000"+
		"CD\u0005M\u0000\u0000D\u0002\u0001\u0000\u0000\u0000EF\u0005B\u0000\u0000"+
		"FG\u0005E\u0000\u0000GH\u0005G\u0000\u0000HI\u0005I\u0000\u0000IJ\u0005"+
		"N\u0000\u0000J\u0004\u0001\u0000\u0000\u0000KL\u0005E\u0000\u0000LM\u0005"+
		"N\u0000\u0000MN\u0005D\u0000\u0000N\u0006\u0001\u0000\u0000\u0000OP\u0005"+
		"L\u0000\u0000PQ\u0005E\u0000\u0000QR\u0005T\u0000\u0000R\b\u0001\u0000"+
		"\u0000\u0000ST\u0005I\u0000\u0000TU\u0005N\u0000\u0000UV\u0005T\u0000"+
		"\u0000V\n\u0001\u0000\u0000\u0000WX\u0005S\u0000\u0000XY\u0005T\u0000"+
		"\u0000YZ\u0005R\u0000\u0000Z[\u0005I\u0000\u0000[\\\u0005N\u0000\u0000"+
		"\\]\u0005G\u0000\u0000]\f\u0001\u0000\u0000\u0000^_\u0005D\u0000\u0000"+
		"_`\u0005O\u0000\u0000`a\u0005U\u0000\u0000ab\u0005B\u0000\u0000bc\u0005"+
		"L\u0000\u0000cd\u0005E\u0000\u0000d\u000e\u0001\u0000\u0000\u0000ef\u0005"+
		"r\u0000\u0000fg\u0005e\u0000\u0000gh\u0005a\u0000\u0000hi\u0005d\u0000"+
		"\u0000i\u0010\u0001\u0000\u0000\u0000jk\u0005p\u0000\u0000kl\u0005r\u0000"+
		"\u0000lm\u0005i\u0000\u0000mn\u0005n\u0000\u0000no\u0005t\u0000\u0000"+
		"o\u0012\u0001\u0000\u0000\u0000pq\u0005p\u0000\u0000qr\u0005r\u0000\u0000"+
		"rs\u0005i\u0000\u0000st\u0005n\u0000\u0000tu\u0005t\u0000\u0000uv\u0005"+
		"l\u0000\u0000vw\u0005n\u0000\u0000w\u0014\u0001\u0000\u0000\u0000xy\u0005"+
		"i\u0000\u0000yz\u0005f\u0000\u0000z\u0016\u0001\u0000\u0000\u0000{|\u0005"+
		"e\u0000\u0000|}\u0005l\u0000\u0000}~\u0005s\u0000\u0000~\u007f\u0005e"+
		"\u0000\u0000\u007f\u0018\u0001\u0000\u0000\u0000\u0080\u0081\u0005e\u0000"+
		"\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u0083\u0005d\u0000\u0000\u0083"+
		"\u0084\u0005i\u0000\u0000\u0084\u0085\u0005f\u0000\u0000\u0085\u001a\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005w\u0000\u0000\u0087\u0088\u0005h\u0000"+
		"\u0000\u0088\u0089\u0005i\u0000\u0000\u0089\u008a\u0005l\u0000\u0000\u008a"+
		"\u008b\u0005e\u0000\u0000\u008b\u001c\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005=\u0000\u0000\u008d\u001e\u0001\u0000\u0000\u0000\u008e\u008f\u0005"+
		"I\u0000\u0000\u008f\u0090\u0005N\u0000\u0000\u0090\u0091\u0005T\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u009c\u0006\u000f\u0000"+
		"\u0000\u0093\u0094\u0005S\u0000\u0000\u0094\u0095\u0005T\u0000\u0000\u0095"+
		"\u0096\u0005R\u0000\u0000\u0096\u0097\u0005I\u0000\u0000\u0097\u0098\u0005"+
		"N\u0000\u0000\u0098\u0099\u0005G\u0000\u0000\u0099\u009a\u0001\u0000\u0000"+
		"\u0000\u009a\u009c\u0006\u000f\u0001\u0000\u009b\u008e\u0001\u0000\u0000"+
		"\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009c \u0001\u0000\u0000\u0000"+
		"\u009d\u00a8\u0005<\u0000\u0000\u009e\u009f\u0005<\u0000\u0000\u009f\u00a8"+
		"\u0005=\u0000\u0000\u00a0\u00a8\u0005>\u0000\u0000\u00a1\u00a2\u0005>"+
		"\u0000\u0000\u00a2\u00a8\u0005=\u0000\u0000\u00a3\u00a4\u0005=\u0000\u0000"+
		"\u00a4\u00a8\u0005=\u0000\u0000\u00a5\u00a6\u0005!\u0000\u0000\u00a6\u00a8"+
		"\u0005=\u0000\u0000\u00a7\u009d\u0001\u0000\u0000\u0000\u00a7\u009e\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a0\u0001\u0000\u0000\u0000\u00a7\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a8\"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005("+
		"\u0000\u0000\u00aa$\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005)\u0000\u0000"+
		"\u00ac&\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005{\u0000\u0000\u00ae("+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0005}\u0000\u0000\u00b0*\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0007\u0000\u0000\u0000\u00b2,\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b7\u0007\u0001\u0000\u0000\u00b4\u00b6\u0007\u0002\u0000"+
		"\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b8.\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bc\u0005-\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bf\u0007\u0003\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c10\u0001\u0000\u0000\u0000\u00c2\u00c4"+
		"\u0005-\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c7\u0007"+
		"\u0003\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u00d0\u0001\u0000\u0000\u0000\u00ca\u00cc\u0005"+
		".\u0000\u0000\u00cb\u00cd\u0007\u0003\u0000\u0000\u00cc\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d0\u00ca\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d12\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005,\u0000\u0000"+
		"\u00d34\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005;\u0000\u0000\u00d56"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005:\u0000\u0000\u00d78\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0007\u0004\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0006\u001c\u0002\u0000\u00db:\u0001\u0000\u0000"+
		"\u0000\u00dc\u00e0\u0005\"\u0000\u0000\u00dd\u00df\t\u0000\u0000\u0000"+
		"\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0005\"\u0000\u0000\u00e4<\u0001\u0000\u0000\u0000\f\u0000"+
		"\u009b\u00a7\u00b5\u00b7\u00bb\u00c0\u00c3\u00c8\u00ce\u00d0\u00e0\u0003"+
		"\u0001\u000f\u0000\u0001\u000f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}