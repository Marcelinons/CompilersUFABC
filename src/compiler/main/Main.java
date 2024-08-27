package compiler.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import compiler.core.ProjGramParser;
import compiler.core.types.Types;
import compiler.core.types.Variable;
import compiler.core.ProjGramLexer;


public class Main {
	public static void main(String[] args) {
		try {
			ProjGramLexer lexer;
			ProjGramParser parser;
//			Variable var;
//	
//			var = new Variable();
//			
//			var.setId("TESTE");
//			var.setType(Types.FLOAT);
//			var.setValue(23 + 24.2);
//			
//			System.out.println(var.toString());
//			System.out.println(var.getValue());
			
			lexer = new ProjGramLexer(CharStreams.fromFileName("input.in"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new ProjGramParser(tokenStream);
			
			System.out.println("Compiling program...");
			parser.program();
			System.out.println("Done.");
			parser.showVariables();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
