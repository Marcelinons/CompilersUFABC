package compiler.core.ast;

public class CommentaryCmd extends Command {
	/**
	 * Comentario em Java
	 * */
	
	private String expression;
	
	public CommentaryCmd() {
		super();
	}

	public CommentaryCmd(String expression) {
		super();
		this.expression = expression;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public String generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("// " + expression + "\n\n");
		return str.toString();
	}
	
}
