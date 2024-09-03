package compiler.core.ast;

import compiler.core.types.Variable;
import java.util.HashMap;

public class Program {
	private String name;
	private HashMap<String, Variable> symbolTable;
	private Command commandList;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
