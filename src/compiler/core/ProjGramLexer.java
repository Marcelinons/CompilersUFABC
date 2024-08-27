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
		ATTRIBUTION=10, TYPE=11, LOG_OP=12, OPEN_PAREN=13, CLOSE_PAREN=14, OPEN_CB=15, 
		CLOSE_CB=16, OP=17, ID=18, INT=19, FLOAT=20, VIRG=21, PV=22, DP=23, WS=24, 
		TEXTO=25;
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
			"CLOSE_CB", "OP", "ID", "INT", "FLOAT", "VIRG", "PV", "DP", "WS", "TEXTO"
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
			currentType = Types.INT;
			break;
		case 1:
			currentType = Types.TEXT;
			break;
		case 2:
			currentType = Types.FLOAT;
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u00bc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\nv\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0082"+
		"\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u008f"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u0093\b\u0011\n\u0011\f\u0011"+
		"\u0096\t\u0011\u0001\u0012\u0004\u0012\u0099\b\u0012\u000b\u0012\f\u0012"+
		"\u009a\u0001\u0013\u0004\u0013\u009e\b\u0013\u000b\u0013\f\u0013\u009f"+
		"\u0001\u0013\u0001\u0013\u0004\u0013\u00a4\b\u0013\u000b\u0013\f\u0013"+
		"\u00a5\u0003\u0013\u00a8\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u00b6\b\u0018\n\u0018\f\u0018"+
		"\u00b9\t\u0018\u0001\u0018\u0001\u0018\u0001\u00b7\u0000\u0019\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u0019\u0001\u0000\u0005\u0003\u0000*+--//\u0001\u0000az\u0003\u0000"+
		"09AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u00c9\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00039\u0001"+
		"\u0000\u0000\u0000\u0005=\u0001\u0000\u0000\u0000\u0007A\u0001\u0000\u0000"+
		"\u0000\tE\u0001\u0000\u0000\u0000\u000bJ\u0001\u0000\u0000\u0000\rP\u0001"+
		"\u0000\u0000\u0000\u000fU\u0001\u0000\u0000\u0000\u0011[\u0001\u0000\u0000"+
		"\u0000\u0013a\u0001\u0000\u0000\u0000\u0015u\u0001\u0000\u0000\u0000\u0017"+
		"\u0081\u0001\u0000\u0000\u0000\u0019\u0083\u0001\u0000\u0000\u0000\u001b"+
		"\u0085\u0001\u0000\u0000\u0000\u001d\u0087\u0001\u0000\u0000\u0000\u001f"+
		"\u0089\u0001\u0000\u0000\u0000!\u008e\u0001\u0000\u0000\u0000#\u0090\u0001"+
		"\u0000\u0000\u0000%\u0098\u0001\u0000\u0000\u0000\'\u009d\u0001\u0000"+
		"\u0000\u0000)\u00a9\u0001\u0000\u0000\u0000+\u00ab\u0001\u0000\u0000\u0000"+
		"-\u00ad\u0001\u0000\u0000\u0000/\u00af\u0001\u0000\u0000\u00001\u00b3"+
		"\u0001\u0000\u0000\u000034\u0005B\u0000\u000045\u0005E\u0000\u000056\u0005"+
		"G\u0000\u000067\u0005I\u0000\u000078\u0005N\u0000\u00008\u0002\u0001\u0000"+
		"\u0000\u00009:\u0005E\u0000\u0000:;\u0005N\u0000\u0000;<\u0005D\u0000"+
		"\u0000<\u0004\u0001\u0000\u0000\u0000=>\u0005L\u0000\u0000>?\u0005E\u0000"+
		"\u0000?@\u0005T\u0000\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005I\u0000"+
		"\u0000BC\u0005N\u0000\u0000CD\u0005T\u0000\u0000D\b\u0001\u0000\u0000"+
		"\u0000EF\u0005T\u0000\u0000FG\u0005E\u0000\u0000GH\u0005X\u0000\u0000"+
		"HI\u0005T\u0000\u0000I\n\u0001\u0000\u0000\u0000JK\u0005F\u0000\u0000"+
		"KL\u0005L\u0000\u0000LM\u0005O\u0000\u0000MN\u0005A\u0000\u0000NO\u0005"+
		"T\u0000\u0000O\f\u0001\u0000\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005"+
		"e\u0000\u0000RS\u0005a\u0000\u0000ST\u0005d\u0000\u0000T\u000e\u0001\u0000"+
		"\u0000\u0000UV\u0005p\u0000\u0000VW\u0005r\u0000\u0000WX\u0005i\u0000"+
		"\u0000XY\u0005n\u0000\u0000YZ\u0005t\u0000\u0000Z\u0010\u0001\u0000\u0000"+
		"\u0000[\\\u0005w\u0000\u0000\\]\u0005h\u0000\u0000]^\u0005i\u0000\u0000"+
		"^_\u0005l\u0000\u0000_`\u0005e\u0000\u0000`\u0012\u0001\u0000\u0000\u0000"+
		"ab\u0005=\u0000\u0000b\u0014\u0001\u0000\u0000\u0000cd\u0005I\u0000\u0000"+
		"de\u0005N\u0000\u0000ef\u0005T\u0000\u0000fg\u0001\u0000\u0000\u0000g"+
		"v\u0006\n\u0000\u0000hi\u0005T\u0000\u0000ij\u0005E\u0000\u0000jk\u0005"+
		"X\u0000\u0000kl\u0005T\u0000\u0000lm\u0001\u0000\u0000\u0000mv\u0006\n"+
		"\u0001\u0000no\u0005F\u0000\u0000op\u0005L\u0000\u0000pq\u0005O\u0000"+
		"\u0000qr\u0005A\u0000\u0000rs\u0005T\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tv\u0006\n\u0002\u0000uc\u0001\u0000\u0000\u0000uh\u0001\u0000\u0000\u0000"+
		"un\u0001\u0000\u0000\u0000v\u0016\u0001\u0000\u0000\u0000w\u0082\u0005"+
		"<\u0000\u0000xy\u0005<\u0000\u0000y\u0082\u0005=\u0000\u0000z\u0082\u0005"+
		">\u0000\u0000{|\u0005>\u0000\u0000|\u0082\u0005=\u0000\u0000}~\u0005="+
		"\u0000\u0000~\u0082\u0005=\u0000\u0000\u007f\u0080\u0005<\u0000\u0000"+
		"\u0080\u0082\u0005>\u0000\u0000\u0081w\u0001\u0000\u0000\u0000\u0081x"+
		"\u0001\u0000\u0000\u0000\u0081z\u0001\u0000\u0000\u0000\u0081{\u0001\u0000"+
		"\u0000\u0000\u0081}\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u0018\u0001\u0000\u0000\u0000\u0083\u0084\u0005(\u0000\u0000"+
		"\u0084\u001a\u0001\u0000\u0000\u0000\u0085\u0086\u0005)\u0000\u0000\u0086"+
		"\u001c\u0001\u0000\u0000\u0000\u0087\u0088\u0005{\u0000\u0000\u0088\u001e"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005}\u0000\u0000\u008a \u0001\u0000"+
		"\u0000\u0000\u008b\u008f\u0007\u0000\u0000\u0000\u008c\u008d\u0005*\u0000"+
		"\u0000\u008d\u008f\u0005*\u0000\u0000\u008e\u008b\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008f\"\u0001\u0000\u0000\u0000\u0090"+
		"\u0094\u0007\u0001\u0000\u0000\u0091\u0093\u0007\u0002\u0000\u0000\u0092"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"$\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0099"+
		"\u0007\u0003\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b&\u0001\u0000\u0000\u0000\u009c\u009e\u0007"+
		"\u0003\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a7\u0001\u0000\u0000\u0000\u00a1\u00a3\u0005"+
		".\u0000\u0000\u00a2\u00a4\u0007\u0003\u0000\u0000\u00a3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8(\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005,\u0000\u0000"+
		"\u00aa*\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005;\u0000\u0000\u00ac,"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005:\u0000\u0000\u00ae.\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0007\u0004\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0006\u0017\u0003\u0000\u00b20\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b7\u0005\"\u0000\u0000\u00b4\u00b6\t\u0000\u0000\u0000"+
		"\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0005\"\u0000\u0000\u00bb2\u0001\u0000\u0000\u0000\u000b"+
		"\u0000u\u0081\u008e\u0092\u0094\u009a\u009f\u00a5\u00a7\u00b7\u0004\u0001"+
		"\n\u0000\u0001\n\u0001\u0001\n\u0002\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}