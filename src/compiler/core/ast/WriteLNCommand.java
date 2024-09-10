/**
 * Comando de print com quebra de linha
 * */

package compiler.core.ast;

public class WriteLNCommand extends Command {
	private String content;
	
	@Override
	public String generateTarget() {
		return "System.out.println("+content+");\n";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public WriteLNCommand(String content) {
		super();
		this.content = content;
	}

	public WriteLNCommand() {
		super();
	}
	
	
}
