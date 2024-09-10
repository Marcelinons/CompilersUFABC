package compiler.core.expressions;

public abstract class AbstractExpression {
	/**
	 * Avalia uma expressao, retornando seu valor.
	 * */
	public abstract Double evaluate();
	
	/**
	 * Cria uma string JSon a partir da expressao lida.
	 * */
	public abstract String toJson();
}
