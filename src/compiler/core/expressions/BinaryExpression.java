package compiler.core.expressions;

public class BinaryExpression extends AbstractExpression {
	/**
	 * Expressao binaria: dois elementos, LEFT, operador e RIGHT.
	 * */
	
	private char operator;						// Operador utilizado na expressao
	private AbstractExpression leftSide;		// Lado esquerdo da expressao
	private AbstractExpression rightSide;		// Lado direito da expressao
	
	
	public char getOperator() {
		return operator;
	}


	public void setOperation(char operator) {
		this.operator = operator;
	}


	public AbstractExpression getLeftSide() {
		return leftSide;
	}


	public void setLeftSide(AbstractExpression leftSide) {
		this.leftSide = leftSide;
	}


	public AbstractExpression getRightSide() {
		return rightSide;
	}


	public void setRightSide(AbstractExpression rightSide) {
		this.rightSide = rightSide;
	}


	public BinaryExpression() {
		super();
	}


	public BinaryExpression(char operation) {
		super();
		this.operator = operation;
	}


	public BinaryExpression(char operation, AbstractExpression leftSide, AbstractExpression rightSide) {
		super();
		this.operator = operation;
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	@Override
	public Double evaluate() {
		/**
		 * Avalia o valor da expressao binaria
		 * */
		
		switch (this.operator) {
		case '+':
			return leftSide.evaluate() + rightSide.evaluate();
		case '-':
			return leftSide.evaluate() - rightSide.evaluate();
		case '*':
			return leftSide.evaluate() * rightSide.evaluate();
		case '/':
			return leftSide.evaluate() / rightSide.evaluate();
		default:
			return null;
		}
	}

	@Override
	public String toJson() {
		StringBuilder str = new StringBuilder();
		str.append("{ \"operator\": \"" + this.operator + "\", ");
		str.append("  \"left\": " + leftSide.toJson() + ",");
		str.append("  \"right\": " + rightSide.toJson() + "}");
		return str.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(leftSide.toString() + " " + this.operator + " " + rightSide.toString());
		return str.toString();
	}
}
