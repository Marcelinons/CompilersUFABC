package compiler.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

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
			ProjGramLexer lexer;	// Analisador lexico
			ProjGramParser parser;  // Analisador semantico
			
			lexer = new ProjGramLexer(CharStreams.fromFileName("program.in"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new ProjGramParser(tokenStream);
			
			System.out.println("Compiling program...");
			
			parser.program();
			
			System.out.println("Program compiled with no errors.\n");
			
			
			/* ---- Code Generator ---- */
			
			Program program = parser.getProgram();
			
			try {
				File f = new File("src/compiler/main/"+program.getName()+".java");
				FileWriter fr = new FileWriter(f);
				PrintWriter pr = new PrintWriter(fr);
				pr.println(program.generateTarget());
				pr.close();
				System.out.println(program.getName()+".java sucessfully written.");
			} 
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public static void gerarArquivo(Program program) throws IOException {
		/**
		 * Salva o arquivo dentro do package compiler.main
		 * */
		
		try {
			File f = new File("src/compiler/main/"+program.getName()+".java");
			FileWriter fr = new FileWriter(f);
			PrintWriter pr = new PrintWriter(fr);
			pr.println(program.generateTarget());
			pr.close();
			System.out.println(program.getName()+".java sucessfully written.");
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Iniciando compilação...");
	}
	
	
	public static void executarArquivo(String programName) throws InterruptedException, IOException {
        /**
         * Realiza a compilacao e execucao do arquivo.java que acabou de ser escrito.
         * */
		
		Process compile = new ProcessBuilder("javac", new StringBuilder().append("src/compiler/main/" + programName + ".java").toString()).start();
		int result_comp = compile.waitFor();
        
        if (result_comp == 0) {
            System.out.println(programName + ".java compilado com sucesso.");
            
            // Executar o arquivo .class gerado
            Process exec = new ProcessBuilder(new StringBuilder().append("compiler.main." + programName).toString()).start();
            exec.waitFor();
            
            try (InputStream input = exec.getInputStream()) {
                input.transferTo(System.out);
                System.out.println(programName + ".java executou corretamente.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Erro ao compilar " + programName + ".java");
            try (InputStream errorStream = compile.getErrorStream()) {
                errorStream.transferTo(System.err);
            }
        }
	}

}
