package compiler.core.types;

import compiler.core.exceptions.SemanticException;

/**
 * DEFINES A VARIABLE CLASS
 */
public class Variable {
	private String id;
	private Types type;	
	private Object value;
	
	/**
	 * Initializes the variable with no ID nor type. */
	public Variable() {
		super();
	}
	
	/**
	 * Initializes the variable with an ID and no type. */
	public Variable(String id) {
		super();
		this.id = id;
	}

	/**
	 * Initializes the variable with an ID a type. */
	public Variable(String id, Types type) {
		super();
		this.id = id;
		this.type = type;
	}

	/**
	 * Returns variable's Id */
	public String getId() {
		return id;
	}
	
	/**
	 * Set the variable id*/
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Returns variable's type */
	public Types getType() {
		return type;
	}
	
	/**
	 * Set variable's type */
	public void setType(Types type) {
		this.type = type;
	}
	
	/**
	 * Set variable's value */
	public void setValue(Object value) {
		switch (this.type) {
		case INT:
			if (value instanceof Integer) {
				this.value = value;
				break;
			} else { 
				throw new IllegalArgumentException("Type mismatch 1.");
			}
		case FLOAT:
			if (value instanceof Float || value instanceof Double) {
				this.value = value;
				break;
			} else {
				throw new IllegalArgumentException("Type mismatch 2 .");
			}
		case TEXT:
			if (value instanceof String) {
				this.value = value;
				break;
			} else {
				throw new IllegalArgumentException("Type mismatch 3 .");
			}
		default:
			break;
		}
	}
	
	/**
	 * Returns variable's value */
 	public Object getValue() {
 		if (this.value != null) {
	 		switch (this.type) {
	 		case INT:
	 			return (Integer) this.value;
	 		case FLOAT:
	 			return (Double) this.value;
	 		case TEXT:
	 			return (String) this.value;
	 		default:
	 			return null;
	 		}
 		} else throw new SemanticException(this.id+" has not been initialized.");
 	}
	
	
	@Override
	public String toString() {
		return "Variable [id=" + id + ", type=" + type + ", value = " + value + "]";
	}
	
	
}
