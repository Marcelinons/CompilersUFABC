// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;
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
		LOG_OP=17, OPEN_PAREN=18, CLOSE_PAREN=19, OPEN_CB=20, CLOSE_CB=21, OP=22, 
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
			"T__9", "T__10", "T__11", "T__12", "T__13", "ATTRIBUTION", "TYPE", "LOG_OP", 
			"OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", "CLOSE_CB", "OP", "ID", "INT", 
			"DOUBLE", "VIRG", "PV", "DP", "WS", "STRING"
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
		"\u0004\u0000\u001e\u00e0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
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
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0094\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00a0\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u00ad\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u00b1\b\u0016\n\u0016\f\u0016\u00b4\t\u0016\u0001\u0017\u0003"+
		"\u0017\u00b7\b\u0017\u0001\u0017\u0004\u0017\u00ba\b\u0017\u000b\u0017"+
		"\f\u0017\u00bb\u0001\u0018\u0003\u0018\u00bf\b\u0018\u0001\u0018\u0004"+
		"\u0018\u00c2\b\u0018\u000b\u0018\f\u0018\u00c3\u0001\u0018\u0001\u0018"+
		"\u0004\u0018\u00c8\b\u0018\u000b\u0018\f\u0018\u00c9\u0003\u0018\u00cc"+
		"\b\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0005\u001d\u00da\b\u001d\n\u001d\f\u001d\u00dd\t\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u00db\u0000\u001e\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c"+
		"9\u001d;\u001e\u0001\u0000\u0005\u0003\u0000*+--//\u0001\u0000az\u0003"+
		"\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u00ee\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0001=\u0001\u0000\u0000\u0000"+
		"\u0003E\u0001\u0000\u0000\u0000\u0005K\u0001\u0000\u0000\u0000\u0007O"+
		"\u0001\u0000\u0000\u0000\tS\u0001\u0000\u0000\u0000\u000bW\u0001\u0000"+
		"\u0000\u0000\r^\u0001\u0000\u0000\u0000\u000fe\u0001\u0000\u0000\u0000"+
		"\u0011j\u0001\u0000\u0000\u0000\u0013p\u0001\u0000\u0000\u0000\u0015s"+
		"\u0001\u0000\u0000\u0000\u0017x\u0001\u0000\u0000\u0000\u0019~\u0001\u0000"+
		"\u0000\u0000\u001b\u0081\u0001\u0000\u0000\u0000\u001d\u0084\u0001\u0000"+
		"\u0000\u0000\u001f\u0093\u0001\u0000\u0000\u0000!\u009f\u0001\u0000\u0000"+
		"\u0000#\u00a1\u0001\u0000\u0000\u0000%\u00a3\u0001\u0000\u0000\u0000\'"+
		"\u00a5\u0001\u0000\u0000\u0000)\u00a7\u0001\u0000\u0000\u0000+\u00ac\u0001"+
		"\u0000\u0000\u0000-\u00ae\u0001\u0000\u0000\u0000/\u00b6\u0001\u0000\u0000"+
		"\u00001\u00be\u0001\u0000\u0000\u00003\u00cd\u0001\u0000\u0000\u00005"+
		"\u00cf\u0001\u0000\u0000\u00007\u00d1\u0001\u0000\u0000\u00009\u00d3\u0001"+
		"\u0000\u0000\u0000;\u00d7\u0001\u0000\u0000\u0000=>\u0005P\u0000\u0000"+
		">?\u0005R\u0000\u0000?@\u0005O\u0000\u0000@A\u0005G\u0000\u0000AB\u0005"+
		"R\u0000\u0000BC\u0005A\u0000\u0000CD\u0005M\u0000\u0000D\u0002\u0001\u0000"+
		"\u0000\u0000EF\u0005B\u0000\u0000FG\u0005E\u0000\u0000GH\u0005G\u0000"+
		"\u0000HI\u0005I\u0000\u0000IJ\u0005N\u0000\u0000J\u0004\u0001\u0000\u0000"+
		"\u0000KL\u0005E\u0000\u0000LM\u0005N\u0000\u0000MN\u0005D\u0000\u0000"+
		"N\u0006\u0001\u0000\u0000\u0000OP\u0005L\u0000\u0000PQ\u0005E\u0000\u0000"+
		"QR\u0005T\u0000\u0000R\b\u0001\u0000\u0000\u0000ST\u0005I\u0000\u0000"+
		"TU\u0005N\u0000\u0000UV\u0005T\u0000\u0000V\n\u0001\u0000\u0000\u0000"+
		"WX\u0005S\u0000\u0000XY\u0005T\u0000\u0000YZ\u0005R\u0000\u0000Z[\u0005"+
		"I\u0000\u0000[\\\u0005N\u0000\u0000\\]\u0005G\u0000\u0000]\f\u0001\u0000"+
		"\u0000\u0000^_\u0005D\u0000\u0000_`\u0005O\u0000\u0000`a\u0005U\u0000"+
		"\u0000ab\u0005B\u0000\u0000bc\u0005L\u0000\u0000cd\u0005E\u0000\u0000"+
		"d\u000e\u0001\u0000\u0000\u0000ef\u0005r\u0000\u0000fg\u0005e\u0000\u0000"+
		"gh\u0005a\u0000\u0000hi\u0005d\u0000\u0000i\u0010\u0001\u0000\u0000\u0000"+
		"jk\u0005p\u0000\u0000kl\u0005r\u0000\u0000lm\u0005i\u0000\u0000mn\u0005"+
		"n\u0000\u0000no\u0005t\u0000\u0000o\u0012\u0001\u0000\u0000\u0000pq\u0005"+
		"i\u0000\u0000qr\u0005f\u0000\u0000r\u0014\u0001\u0000\u0000\u0000st\u0005"+
		"e\u0000\u0000tu\u0005l\u0000\u0000uv\u0005s\u0000\u0000vw\u0005e\u0000"+
		"\u0000w\u0016\u0001\u0000\u0000\u0000xy\u0005w\u0000\u0000yz\u0005h\u0000"+
		"\u0000z{\u0005i\u0000\u0000{|\u0005l\u0000\u0000|}\u0005e\u0000\u0000"+
		"}\u0018\u0001\u0000\u0000\u0000~\u007f\u0005&\u0000\u0000\u007f\u0080"+
		"\u0005&\u0000\u0000\u0080\u001a\u0001\u0000\u0000\u0000\u0081\u0082\u0005"+
		"|\u0000\u0000\u0082\u0083\u0005|\u0000\u0000\u0083\u001c\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005=\u0000\u0000\u0085\u001e\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005I\u0000\u0000\u0087\u0088\u0005N\u0000\u0000\u0088\u0089"+
		"\u0005T\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0094\u0006"+
		"\u000f\u0000\u0000\u008b\u008c\u0005S\u0000\u0000\u008c\u008d\u0005T\u0000"+
		"\u0000\u008d\u008e\u0005R\u0000\u0000\u008e\u008f\u0005I\u0000\u0000\u008f"+
		"\u0090\u0005N\u0000\u0000\u0090\u0091\u0005G\u0000\u0000\u0091\u0092\u0001"+
		"\u0000\u0000\u0000\u0092\u0094\u0006\u000f\u0001\u0000\u0093\u0086\u0001"+
		"\u0000\u0000\u0000\u0093\u008b\u0001\u0000\u0000\u0000\u0094 \u0001\u0000"+
		"\u0000\u0000\u0095\u00a0\u0005<\u0000\u0000\u0096\u0097\u0005<\u0000\u0000"+
		"\u0097\u00a0\u0005=\u0000\u0000\u0098\u00a0\u0005>\u0000\u0000\u0099\u009a"+
		"\u0005>\u0000\u0000\u009a\u00a0\u0005=\u0000\u0000\u009b\u009c\u0005="+
		"\u0000\u0000\u009c\u00a0\u0005=\u0000\u0000\u009d\u009e\u0005<\u0000\u0000"+
		"\u009e\u00a0\u0005>\u0000\u0000\u009f\u0095\u0001\u0000\u0000\u0000\u009f"+
		"\u0096\u0001\u0000\u0000\u0000\u009f\u0098\u0001\u0000\u0000\u0000\u009f"+
		"\u0099\u0001\u0000\u0000\u0000\u009f\u009b\u0001\u0000\u0000\u0000\u009f"+
		"\u009d\u0001\u0000\u0000\u0000\u00a0\"\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0005(\u0000\u0000\u00a2$\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005)"+
		"\u0000\u0000\u00a4&\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005{\u0000\u0000"+
		"\u00a6(\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005}\u0000\u0000\u00a8*"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ad\u0007\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0005*\u0000\u0000\u00ab\u00ad\u0005*\u0000\u0000\u00ac\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad,\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b2\u0007\u0001\u0000\u0000\u00af\u00b1\u0007\u0002\u0000"+
		"\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3.\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0005-\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8"+
		"\u00ba\u0007\u0003\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc0\u0001\u0000\u0000\u0000\u00bd\u00bf"+
		"\u0005-\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00c2\u0007"+
		"\u0003\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c4\u00cb\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005"+
		".\u0000\u0000\u00c6\u00c8\u0007\u0003\u0000\u0000\u00c7\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cb\u00c5\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cc2\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005,\u0000\u0000"+
		"\u00ce4\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005;\u0000\u0000\u00d06"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005:\u0000\u0000\u00d28\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0007\u0004\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0006\u001c\u0002\u0000\u00d6:\u0001\u0000\u0000"+
		"\u0000\u00d7\u00db\u0005\"\u0000\u0000\u00d8\u00da\t\u0000\u0000\u0000"+
		"\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000"+
		"\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00de\u00df\u0005\"\u0000\u0000\u00df<\u0001\u0000\u0000\u0000\r\u0000"+
		"\u0093\u009f\u00ac\u00b0\u00b2\u00b6\u00bb\u00be\u00c3\u00c9\u00cb\u00db"+
		"\u0003\u0001\u000f\u0000\u0001\u000f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}