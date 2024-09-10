/**
 * Comando de print sem quebra de linha.
 * */

package compiler.core.ast;

public class WriteCommand extends Command {
	private String content;
	
	@Override
	public String generateTarget() {
		return "System.out.print("+content+");\n";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public WriteCommand(String content) {
		super();
		this.content = content;
	}

	public WriteCommand() {
		super();
	}
	
	
}
