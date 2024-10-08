/**
 * Principal classe do programa.
 * 
 * 
 * */

package compiler.core.ast;

import compiler.core.types.Types;
import compiler.core.types.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program {
	private String name;							// Nome do programa (ou nome da Classe em java)
	private HashMap<String, Variable> symbolTable;  // Mapa de simbolos (lista de variaveis)
	private List<Command> commandList;				// Lista de comandos

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public HashMap<String, Variable> getSymbolTable() {
		return symbolTable;
	}
	public void setSymbolTable(HashMap<String, Variable> symbolTable) {
		this.symbolTable = symbolTable;
	}
	public List<Command> getCommandList() {
		return commandList;
	}
	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}
	
	public String generateTarget() {
		/* Gera o corpo do codigo: imports, packages, nome de classe.
		 * */
		
		StringBuilder str = new StringBuilder();
		str.append("package compiler.main;\n\n");
		
		str.append("import java.util.Scanner;\n");
				
		str.append("public class "+this.name+" { \n");
		str.append("  public static void main(String[] args) { \n");
		str.append("  Scanner _scInpt = new Scanner(System.in);\n");
		
		// Declaracao de variaveis
		for (String id: symbolTable.keySet()) {
			Variable var = symbolTable.get(id);
			if (var.getType() == Types.INT) {
				str.append("    int ");
			} else if (var.getType() == Types.DOUBLE) {
				str.append("    double ");
			} else {
				str.append("    String ");
			}
			str.append(var.getId()+";\n");
		}
		// Comandos da lista
		for (Command cmd: commandList) {
			str.append("    "+cmd.generateTarget());
		}
		
		str.append("  }\n");
		str.append("}\n");
		return str.toString();
	}
	
}
