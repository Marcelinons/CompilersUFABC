// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;

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
		ATTRIBUTION=10, TYPE=11, LOG_OP=12, OPEN_PAREN=13, CLOSE_PAREN=14, OPEN_CB=15, 
		CLOSE_CB=16, OP=17, ID=18, NUM=19, VIRG=20, PV=21, DP=22, WS=23, TEXTO=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"ATTRIBUTION", "TYPE", "LOG_OP", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_CB", 
			"CLOSE_CB", "OP", "ID", "NUM", "VIRG", "PV", "DP", "WS", "TEXTO"
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
		case 10:
			TYPE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TYPE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			currentType = Types.NUMBER;
			break;
		case 1:
			currentType = Types.TEXT;
			break;
		case 2:
			currentType = Types.BOOLEAN;
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u00bf\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
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
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n~\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008a"+
		"\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0097"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u009b\b\u0011\n\u0011\f\u0011"+
		"\u009e\t\u0011\u0001\u0012\u0004\u0012\u00a1\b\u0012\u000b\u0012\f\u0012"+
		"\u00a2\u0001\u0012\u0001\u0012\u0004\u0012\u00a7\b\u0012\u000b\u0012\f"+
		"\u0012\u00a8\u0003\u0012\u00ab\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0005\u0017\u00b9\b\u0017\n\u0017"+
		"\f\u0017\u00bc\t\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u0018\u0001\u0000\u0006\u0003\u0000*+--//\u0001\u0000az\u0003\u00000"+
		"9AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u0005\u0000  ,.09AZaz\u00cb"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00011\u0001\u0000\u0000\u0000\u00037\u0001\u0000"+
		"\u0000\u0000\u0005;\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000"+
		"\tF\u0001\u0000\u0000\u0000\u000bK\u0001\u0000\u0000\u0000\rS\u0001\u0000"+
		"\u0000\u0000\u000fX\u0001\u0000\u0000\u0000\u0011^\u0001\u0000\u0000\u0000"+
		"\u0013d\u0001\u0000\u0000\u0000\u0015}\u0001\u0000\u0000\u0000\u0017\u0089"+
		"\u0001\u0000\u0000\u0000\u0019\u008b\u0001\u0000\u0000\u0000\u001b\u008d"+
		"\u0001\u0000\u0000\u0000\u001d\u008f\u0001\u0000\u0000\u0000\u001f\u0091"+
		"\u0001\u0000\u0000\u0000!\u0096\u0001\u0000\u0000\u0000#\u0098\u0001\u0000"+
		"\u0000\u0000%\u00a0\u0001\u0000\u0000\u0000\'\u00ac\u0001\u0000\u0000"+
		"\u0000)\u00ae\u0001\u0000\u0000\u0000+\u00b0\u0001\u0000\u0000\u0000-"+
		"\u00b2\u0001\u0000\u0000\u0000/\u00b6\u0001\u0000\u0000\u000012\u0005"+
		"b\u0000\u000023\u0005e\u0000\u000034\u0005g\u0000\u000045\u0005i\u0000"+
		"\u000056\u0005n\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0005e\u0000"+
		"\u000089\u0005n\u0000\u00009:\u0005d\u0000\u0000:\u0004\u0001\u0000\u0000"+
		"\u0000;<\u0005l\u0000\u0000<=\u0005e\u0000\u0000=>\u0005t\u0000\u0000"+
		">\u0006\u0001\u0000\u0000\u0000?@\u0005n\u0000\u0000@A\u0005u\u0000\u0000"+
		"AB\u0005m\u0000\u0000BC\u0005b\u0000\u0000CD\u0005e\u0000\u0000DE\u0005"+
		"r\u0000\u0000E\b\u0001\u0000\u0000\u0000FG\u0005t\u0000\u0000GH\u0005"+
		"e\u0000\u0000HI\u0005x\u0000\u0000IJ\u0005t\u0000\u0000J\n\u0001\u0000"+
		"\u0000\u0000KL\u0005b\u0000\u0000LM\u0005o\u0000\u0000MN\u0005o\u0000"+
		"\u0000NO\u0005l\u0000\u0000OP\u0005e\u0000\u0000PQ\u0005a\u0000\u0000"+
		"QR\u0005n\u0000\u0000R\f\u0001\u0000\u0000\u0000ST\u0005r\u0000\u0000"+
		"TU\u0005e\u0000\u0000UV\u0005a\u0000\u0000VW\u0005d\u0000\u0000W\u000e"+
		"\u0001\u0000\u0000\u0000XY\u0005p\u0000\u0000YZ\u0005r\u0000\u0000Z[\u0005"+
		"i\u0000\u0000[\\\u0005n\u0000\u0000\\]\u0005t\u0000\u0000]\u0010\u0001"+
		"\u0000\u0000\u0000^_\u0005w\u0000\u0000_`\u0005h\u0000\u0000`a\u0005i"+
		"\u0000\u0000ab\u0005l\u0000\u0000bc\u0005e\u0000\u0000c\u0012\u0001\u0000"+
		"\u0000\u0000de\u0005=\u0000\u0000e\u0014\u0001\u0000\u0000\u0000fg\u0005"+
		"n\u0000\u0000gh\u0005u\u0000\u0000hi\u0005m\u0000\u0000ij\u0005b\u0000"+
		"\u0000jk\u0005e\u0000\u0000kl\u0005r\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"m~\u0006\n\u0000\u0000no\u0005t\u0000\u0000op\u0005e\u0000\u0000pq\u0005"+
		"x\u0000\u0000qr\u0005t\u0000\u0000rs\u0001\u0000\u0000\u0000s~\u0006\n"+
		"\u0001\u0000tu\u0005b\u0000\u0000uv\u0005o\u0000\u0000vw\u0005o\u0000"+
		"\u0000wx\u0005l\u0000\u0000xy\u0005e\u0000\u0000yz\u0005a\u0000\u0000"+
		"z{\u0005n\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0006\n\u0002\u0000"+
		"}f\u0001\u0000\u0000\u0000}n\u0001\u0000\u0000\u0000}t\u0001\u0000\u0000"+
		"\u0000~\u0016\u0001\u0000\u0000\u0000\u007f\u008a\u0005<\u0000\u0000\u0080"+
		"\u0081\u0005<\u0000\u0000\u0081\u008a\u0005=\u0000\u0000\u0082\u008a\u0005"+
		">\u0000\u0000\u0083\u0084\u0005>\u0000\u0000\u0084\u008a\u0005=\u0000"+
		"\u0000\u0085\u0086\u0005=\u0000\u0000\u0086\u008a\u0005=\u0000\u0000\u0087"+
		"\u0088\u0005<\u0000\u0000\u0088\u008a\u0005>\u0000\u0000\u0089\u007f\u0001"+
		"\u0000\u0000\u0000\u0089\u0080\u0001\u0000\u0000\u0000\u0089\u0082\u0001"+
		"\u0000\u0000\u0000\u0089\u0083\u0001\u0000\u0000\u0000\u0089\u0085\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u0018\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005(\u0000\u0000\u008c\u001a\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005)\u0000\u0000\u008e\u001c\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005{\u0000\u0000\u0090\u001e\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005}\u0000\u0000\u0092 \u0001\u0000\u0000\u0000\u0093\u0097"+
		"\u0007\u0000\u0000\u0000\u0094\u0095\u0005*\u0000\u0000\u0095\u0097\u0005"+
		"*\u0000\u0000\u0096\u0093\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000"+
		"\u0000\u0000\u0097\"\u0001\u0000\u0000\u0000\u0098\u009c\u0007\u0001\u0000"+
		"\u0000\u0099\u009b\u0007\u0002\u0000\u0000\u009a\u0099\u0001\u0000\u0000"+
		"\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d$\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a1\u0007\u0003\u0000\u0000"+
		"\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00aa\u0001\u0000\u0000\u0000\u00a4\u00a6\u0005.\u0000\u0000\u00a5"+
		"\u00a7\u0007\u0003\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a4\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"&\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005,\u0000\u0000\u00ad(\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005;\u0000\u0000\u00af*\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0005:\u0000\u0000\u00b1,\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0007\u0004\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0006\u0016\u0003\u0000\u00b5.\u0001\u0000\u0000\u0000\u00b6\u00ba"+
		"\u0005\"\u0000\u0000\u00b7\u00b9\u0007\u0005\u0000\u0000\u00b8\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0005"+
		"\"\u0000\u0000\u00be0\u0001\u0000\u0000\u0000\u000b\u0000}\u0089\u0096"+
		"\u009a\u009c\u00a2\u00a8\u00aa\u00b8\u00ba\u0004\u0001\n\u0000\u0001\n"+
		"\u0001\u0001\n\u0002\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}