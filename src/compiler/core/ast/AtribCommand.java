/**
 * 	Comando de atribuicao de valores
 * */

package compiler.core.ast;

import compiler.core.types.*;

public class AtribCommand extends Command {
	private Variable var; 		// Variavel
	private Types atrbType;		// Tipo da variavel
	private String expression;  // Expressao a ser atribuida
	
	public AtribCommand() {
		super();
	}
	
	public AtribCommand(Variable var) {
		super();
		this.var = var;
	}

	public AtribCommand(Variable var, Types atrbType) {
		super();
		this.var = var;
		this.atrbType = atrbType;
	}
	
	public AtribCommand(Variable var, Types atrbType, String expression) {
		super();
		this.var = var;
		this.atrbType = atrbType;
		this.expression = expression;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	
	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	public Types getAtrbType() {
		return atrbType;
	}

	public void setAtrbType(Types atrbType) {
		this.atrbType = atrbType;
	}
	
	@Override
	public String generateTarget() {
		StringBuilder str = new StringBuilder();
		switch (var.getType()) {
		case STRING:
			// Realiza a concatenacao dos elementos da String, sem muitos tratamentos.
			str.append(var.getId() + " = \"" + expression.replaceAll("\"", "") + "\";\n");
			break;
		default:
			str.append(var.getId() + " = " + expression + ";\n");
			break;
		}
		return str.toString();
	}
}
