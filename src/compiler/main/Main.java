package compiler.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import compiler.core.ProjGramParser;
import compiler.core.ProjGramLexer;


public class Main {
	public static void main(String[] args) {
		try {
			ProjGramLexer lexer;
			ProjGramParser parser;
			
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
