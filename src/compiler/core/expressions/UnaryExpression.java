package compiler.core.expressions;

public class UnaryExpression extends AbstractExpression {
	/**
	 * Expressao unaria: um elemento.
	 * */
	
	private Double value;

	public UnaryExpression() {
		super();
	}

	public UnaryExpression(Double value) {
		super();
		this.value = value;
	}
	
	@Override
	public Double evaluate() {
		return value;
	}

	@Override
	public String toJson() {
		return "{ \"value\": " + this.value + "}";
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.value);
		return str.toString();
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
