package compiler.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStreams;

import org.antlr.v4.runtime.CommonTokenStream;
import compiler.core.ProjGramParser;
import compiler.core.types.Types;
import compiler.core.types.Variable;
import compiler.core.ProjGramLexer;
import compiler.core.ast.*;

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
			
			lexer = new ProjGramLexer(CharStreams.fromFileName("program.in"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new ProjGramParser(tokenStream);
			
			System.out.println("Compiling program...");
			parser.program();
			System.out.println("Program compiled with no errors.\n");
			
			// System.out.println("Variables: \n");
			// parser.showVariables();
			
			// parser.declaredNotUsed();
			
			/* ---- Code Generator ---- */
			
			Program program = parser.getProgram();
			System.out.println(program.generateTarget());
			try {
				File f = new File(program.getName()+".java");
				FileWriter fr = new FileWriter(f);
				PrintWriter pr = new PrintWriter(fr);
				pr.println(program.generateTarget());
				pr.close();
				
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
