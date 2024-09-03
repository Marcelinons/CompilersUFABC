package compiler.core.ast;

public class WriteCommand extends Command {
	private String content;
	
	@Override
	public String generateTarget() {
		return "System.out.println("+content+");\n";
	}
}
