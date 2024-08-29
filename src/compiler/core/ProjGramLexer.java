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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ATTRIBUTION=9, 
		TYPE=10, LOG_OP=11, OPEN_PAREN=12, CLOSE_PAREN=13, OPEN_CB=14, CLOSE_CB=15, 
		OP=16, ID=17, INT=18, DOUBLE=19, VIRG=20, PV=21, DP=22, WS=23, STRING=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "ATTRIBUTION", 
			"TYPE", "LOG_OP", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", "CLOSE_CB", 
			"OP", "ID", "INT", "DOUBLE", "VIRG", "PV", "DP", "WS", "STRING"
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
		case 9:
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
		"\u0004\u0000\u0018\u00b8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tl\b"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\nx\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0085\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0089\b"+
		"\u0010\n\u0010\f\u0010\u008c\t\u0010\u0001\u0011\u0003\u0011\u008f\b\u0011"+
		"\u0001\u0011\u0004\u0011\u0092\b\u0011\u000b\u0011\f\u0011\u0093\u0001"+
		"\u0012\u0003\u0012\u0097\b\u0012\u0001\u0012\u0004\u0012\u009a\b\u0012"+
		"\u000b\u0012\f\u0012\u009b\u0001\u0012\u0001\u0012\u0004\u0012\u00a0\b"+
		"\u0012\u000b\u0012\f\u0012\u00a1\u0003\u0012\u00a4\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u00b2\b\u0017\n\u0017\f\u0017\u00b5\t\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u00b3\u0000\u0018\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u0018\u0001\u0000\u0005\u0003\u0000*+--//\u0001\u0000"+
		"az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u00c6\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00011\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000\u0005"+
		";\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tC\u0001\u0000"+
		"\u0000\u0000\u000bJ\u0001\u0000\u0000\u0000\rQ\u0001\u0000\u0000\u0000"+
		"\u000fV\u0001\u0000\u0000\u0000\u0011\\\u0001\u0000\u0000\u0000\u0013"+
		"k\u0001\u0000\u0000\u0000\u0015w\u0001\u0000\u0000\u0000\u0017y\u0001"+
		"\u0000\u0000\u0000\u0019{\u0001\u0000\u0000\u0000\u001b}\u0001\u0000\u0000"+
		"\u0000\u001d\u007f\u0001\u0000\u0000\u0000\u001f\u0084\u0001\u0000\u0000"+
		"\u0000!\u0086\u0001\u0000\u0000\u0000#\u008e\u0001\u0000\u0000\u0000%"+
		"\u0096\u0001\u0000\u0000\u0000\'\u00a5\u0001\u0000\u0000\u0000)\u00a7"+
		"\u0001\u0000\u0000\u0000+\u00a9\u0001\u0000\u0000\u0000-\u00ab\u0001\u0000"+
		"\u0000\u0000/\u00af\u0001\u0000\u0000\u000012\u0005B\u0000\u000023\u0005"+
		"E\u0000\u000034\u0005G\u0000\u000045\u0005I\u0000\u000056\u0005N\u0000"+
		"\u00006\u0002\u0001\u0000\u0000\u000078\u0005E\u0000\u000089\u0005N\u0000"+
		"\u00009:\u0005D\u0000\u0000:\u0004\u0001\u0000\u0000\u0000;<\u0005L\u0000"+
		"\u0000<=\u0005E\u0000\u0000=>\u0005T\u0000\u0000>\u0006\u0001\u0000\u0000"+
		"\u0000?@\u0005I\u0000\u0000@A\u0005N\u0000\u0000AB\u0005T\u0000\u0000"+
		"B\b\u0001\u0000\u0000\u0000CD\u0005S\u0000\u0000DE\u0005T\u0000\u0000"+
		"EF\u0005R\u0000\u0000FG\u0005I\u0000\u0000GH\u0005N\u0000\u0000HI\u0005"+
		"G\u0000\u0000I\n\u0001\u0000\u0000\u0000JK\u0005D\u0000\u0000KL\u0005"+
		"O\u0000\u0000LM\u0005U\u0000\u0000MN\u0005B\u0000\u0000NO\u0005L\u0000"+
		"\u0000OP\u0005E\u0000\u0000P\f\u0001\u0000\u0000\u0000QR\u0005r\u0000"+
		"\u0000RS\u0005e\u0000\u0000ST\u0005a\u0000\u0000TU\u0005d\u0000\u0000"+
		"U\u000e\u0001\u0000\u0000\u0000VW\u0005p\u0000\u0000WX\u0005r\u0000\u0000"+
		"XY\u0005i\u0000\u0000YZ\u0005n\u0000\u0000Z[\u0005t\u0000\u0000[\u0010"+
		"\u0001\u0000\u0000\u0000\\]\u0005=\u0000\u0000]\u0012\u0001\u0000\u0000"+
		"\u0000^_\u0005I\u0000\u0000_`\u0005N\u0000\u0000`a\u0005T\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bl\u0006\t\u0000\u0000cd\u0005S\u0000\u0000"+
		"de\u0005T\u0000\u0000ef\u0005R\u0000\u0000fg\u0005I\u0000\u0000gh\u0005"+
		"N\u0000\u0000hi\u0005G\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0006\t"+
		"\u0001\u0000k^\u0001\u0000\u0000\u0000kc\u0001\u0000\u0000\u0000l\u0014"+
		"\u0001\u0000\u0000\u0000mx\u0005<\u0000\u0000no\u0005<\u0000\u0000ox\u0005"+
		"=\u0000\u0000px\u0005>\u0000\u0000qr\u0005>\u0000\u0000rx\u0005=\u0000"+
		"\u0000st\u0005=\u0000\u0000tx\u0005=\u0000\u0000uv\u0005<\u0000\u0000"+
		"vx\u0005>\u0000\u0000wm\u0001\u0000\u0000\u0000wn\u0001\u0000\u0000\u0000"+
		"wp\u0001\u0000\u0000\u0000wq\u0001\u0000\u0000\u0000ws\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000x\u0016\u0001\u0000\u0000\u0000yz\u0005"+
		"(\u0000\u0000z\u0018\u0001\u0000\u0000\u0000{|\u0005)\u0000\u0000|\u001a"+
		"\u0001\u0000\u0000\u0000}~\u0005{\u0000\u0000~\u001c\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0005}\u0000\u0000\u0080\u001e\u0001\u0000\u0000\u0000"+
		"\u0081\u0085\u0007\u0000\u0000\u0000\u0082\u0083\u0005*\u0000\u0000\u0083"+
		"\u0085\u0005*\u0000\u0000\u0084\u0081\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0085 \u0001\u0000\u0000\u0000\u0086\u008a\u0007"+
		"\u0001\u0000\u0000\u0087\u0089\u0007\u0002\u0000\u0000\u0088\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\"\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008f\u0005-\u0000"+
		"\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u0092\u0007\u0003\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094$\u0001\u0000\u0000\u0000\u0095\u0097\u0005-\u0000\u0000\u0096"+
		"\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u0099\u0001\u0000\u0000\u0000\u0098\u009a\u0007\u0003\u0000\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u00a3\u0001\u0000\u0000\u0000\u009d\u009f\u0005.\u0000\u0000\u009e\u00a0"+
		"\u0007\u0003\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u009d"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4&\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005,\u0000\u0000\u00a6(\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0005;\u0000\u0000\u00a8*\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005:\u0000\u0000\u00aa,\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007"+
		"\u0004\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0006"+
		"\u0016\u0002\u0000\u00ae.\u0001\u0000\u0000\u0000\u00af\u00b3\u0005\""+
		"\u0000\u0000\u00b0\u00b2\t\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\"\u0000\u0000"+
		"\u00b70\u0001\u0000\u0000\u0000\r\u0000kw\u0084\u0088\u008a\u008e\u0093"+
		"\u0096\u009b\u00a1\u00a3\u00b3\u0003\u0001\t\u0000\u0001\t\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}