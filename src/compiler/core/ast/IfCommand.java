package compiler.core.ast;

import java.util.List;

public class IfCommand extends Command {
	private List<Command> trueList;
	private List<Command> falseList;
	private String expression;
	
	public IfCommand() {
		super();
	}

	public IfCommand(List<Command> trueList, List<Command> falseList, String expression) {
		super();
		this.trueList = trueList;
		this.falseList = falseList;
		this.expression = expression;
	}

	public List<Command> getTrueList() {
		return trueList;
	}

	public void setTrueList(List<Command> trueList) {
		this.trueList = trueList;
	}

	public List<Command> getFalseList() {
		return falseList;
	}

	public void setFalseList(List<Command> falseList) {
		this.falseList = falseList;
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
		str.append("if ("+this.expression+") {\n");
		
		for (Command cmd: this.trueList) {
			str.append(cmd.generateTarget());
		}
		str.append("}\n");
		
		if (falseList != null) {
			str.append(" else {\n");
			for (Command cmd: this.falseList) {
				str.append(cmd.generateTarget());
			}
			str.append("}\n");
		}
		return str.toString();
	}
	
}
