/**
 * Abstracao de uma linha de codigo
 * */

package compiler.core.ast;

public abstract class Command {
	/**
	 * Responsavel por fazer a geracao do codigo baseado no input.
	 * */
	public abstract String generateTarget();
}
