package compiler.core.types;

public class Variable {
	private String id;
	private Types type;

	public Variable() {
		super();
	}
	
	public Variable(String id) {
		super();
		this.id = id;
	}

	public Variable(String id, Types type) {
		super();
		this.id = id;
		this.type = type;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Types getType() {
		return type;
	}
	
	public void setType(Types type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "Variable [id=" + id + ", type=" + type + "]";
	}
	
	
}
