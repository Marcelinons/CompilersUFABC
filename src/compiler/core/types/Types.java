package compiler.core.types;

public enum Types {
	INT(1),
	DOUBLE(2),
	STRING(3);
	
	private int value;
	
	private Types(int valueNumber) {
		this.value = valueNumber;
	}
	public Integer getValue() {
		return this.value;
	}
}
