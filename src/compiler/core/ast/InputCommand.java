/**
 * Comando de leitura do usuário.
 * 
 * Lê do usuario um valor que depende do tipo da varivel em questao.
 * */

package compiler.core.ast;

import compiler.core.types.*;

public class InputCommand extends Command {
	private Variable var;
	
	@Override
	public String generateTarget() {
		StringBuilder str = new StringBuilder();
		switch (var.getType()) {
		case INT:
			str.append(var.getId()+" = _scInpt.nextInt();\n");
			break;
		case DOUBLE:
			str.append(var.getId()+" = _scInpt.nextDouble();\n");
			break;
		default:
			str.append(var.getId()+" = _scInpt.nextLine();\n");
			break;
		}
		return str.toString();
	}

	public void setContent(Variable var) {
		this.var = var;
	}

	public InputCommand(Variable var) {
		super();
		this.var = var;
	}

	public InputCommand() {
		super();
	}

}
