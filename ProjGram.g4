grammar ProjGram;

@header {
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import compiler.core.types.*;
	import compiler.core.ast.*;
	import compiler.core.exceptions.*;
	import compiler.core.expressions.*;
}

@members {
    private HashMap<String, Variable> symbolTable = new HashMap<String, Variable>();
	private AbstractExpression head = null;
    
	private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
    private Types currentType, leftType=null, rightType=null;
    
    private Stack<ArrayList<Command>> commandStack = new Stack<ArrayList<Command>>();
    
	private String exprString;
    private Stack<AbstractExpression> exprStack = new Stack<AbstractExpression>();

	private Program program = new Program();
	

	public double generateValue() {
		if (head == null) {
			head = exprStack.pop();
		}
		return head.evaluate();
	}

	public String generateJson() {
		if (head == null) {
			head = exprStack.pop();
		}
		return head.toJson();
	}

	public String generateExpression() {
		if (head == null) {
			head = exprStack.pop();
		}
		return head.toString();
	}

    public Program getProgram() {
    	return this.program;
    }
    
    public void updateType() {
    	for(Variable v: currentDecl){
    	   v.setType(currentType);
    	   symbolTable.put(v.getId(), v);
    	}
    }
    
    /**
    * Returns all declared IDs that have not been used on the program
    */
    public String declaredNotUsed() {
    	StringBuilder str = new StringBuilder();
		str.append("Warning: {");
    	for (String id: symbolTable.keySet()) {
    	    if (!symbolTable.get(id).isInitialized()) { 
				str.append(symbolTable.get(id).getId() + ", ") ; 
			}
		}
    	str.append("} have not been initialized.\n");
		return str.toString();
    }
    
    /**
    * Prints all of declared variables
    */
    public void showVariables(){
        for (String id: symbolTable.keySet()){
        	System.out.println(symbolTable.get(id));
        }
    }
    
    /**
    * Checks if given Id is declared
    */
    public boolean isDeclared(String id) {
    	return symbolTable.get(id) != null;
    }
}

/** 
* Regras sintaticas 
*/

// Bloco principal do programa
program  
    :	'PROGRAM' ID 
		{
			commandStack.push(new ArrayList<Command>());
			program.setName(_input.LT(-1).getText()); 
		}
      	declare_var+ 
      	'BEGIN' 
      	(command | (expression PV) ) +
      	'END' 
		{ 
			program.setSymbolTable(symbolTable);
            program.setCommandList(commandStack.pop()); 

			System.out.println(declaredNotUsed());
		}
    ;

// Declaracao de variaveis
declare_var
	: 	'LET' { currentDecl.clear(); } tipo varList* {updateType();} PV
	;

// Tipos
tipo
	: 	'INT' {currentType = Types.INT;} 
        | 'DOUBLE' {currentType = Types.DOUBLE;}
       	| 'STRING' {currentType = Types.STRING;} 
	;

// Lista de variaveis para declaracao
varList
	:	ID 	
		{   // Validar se ja foi declarada
			if (isDeclared(_input.LT(-1).getText())) {
				throw new RuntimeException(_input.LT(-1).getText()+" has already been declared.");
			} else { currentDecl.add(new Variable(_input.LT(-1).getText())); }
	    } 
	  	(VIRG ID 	
			{   // Validar se ja foi declarada
				if (isDeclared(_input.LT(-1).getText())) {
					throw new RuntimeException(_input.LT(-1).getText()+" has already been declared.");
				} else {currentDecl.add(new Variable(_input.LT(-1).getText()));}
			} 
		)*
	;


// Command line
command
	:  	cmdAttrib
		| cmdRead
		| cmdWrite
		| cmdWrite_ln
		| cmdIf
		| cmdWhile
		| cmdComment
	;

// Comentario
cmdComment
	:	'--' {exprString = "";} 
		expression { 
						commandStack.peek().add(new CommentaryCmd(exprString.substring(1).replaceAll("\"", "")));
						leftType = rightType = null; 
					} (PV)?
	;

// Inicializacao/atribuicao de variaveis
cmdAttrib
	: 	ID 	
		{ 
			// Verificar se a variavel nao foi declarada
			String curr_id = _input.LT(-1).getText();
			if (!isDeclared(curr_id)) {
				throw new RuntimeException(curr_id+" has not been declared.");
			}
			leftType = symbolTable.get(curr_id).getType();
			exprString = "";	 
		}
	  	ATTRIBUTION
	  	expression 	
		{	
			if (leftType.getValue() < rightType.getValue()) {
				throw new RuntimeException(symbolTable.get(curr_id).getId()+" expected "+leftType+". Received "+rightType+".");
			} else {
				symbolTable.get(curr_id).setInitialized(true);
				commandStack.peek().add(new AtribCommand(symbolTable.get(curr_id), rightType, exprString.substring(1)));
			}
			leftType = rightType = null;
	  	}
	  	PV
	;

// Input do teclado
cmdRead
	: 	'read' 
	   	OPEN_PAREN 
	   	ID 
		{ 
			if (!isDeclared(_input.LT(-1).getText())) {
	          	throw new RuntimeException(_input.LT(-1).getText()+" has not been declared.");
	        } else {
				symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
				commandStack.peek().add(new InputCommand(symbolTable.get(_input.LT(-1).getText())));
			}	      	
	    } 
	   	CLOSE_PAREN
	   	PV
	;

// Print
cmdWrite 
	: 	'print' {exprString = "";} 
	  	OPEN_PAREN 
	  	(expression 
			{
				commandStack.peek().add(new WriteCommand(exprString.substring(1)));
				leftType = rightType = null;
	  		} 
		) 
	  	CLOSE_PAREN
	  	PV
	;

// Print ln 
cmdWrite_ln
	: 	'println' {exprString = "";}
	  	OPEN_PAREN 
	  	(expression 
			{
				commandStack.peek().add(new WriteLNCommand(exprString.substring(1)));
				leftType = rightType = null;
	  		} 
		) 
	  	CLOSE_PAREN
	  	PV
	;

// Comando IF
cmdIf
	: 	'if'	
		{ 
			commandStack.push(new ArrayList<Command>());
	        exprString = "";
	        IfCommand _cmdIf = new IfCommand();
	    }
	   	OPEN_PAREN
	  	expression 
		{ 
			// Expressao do If deve ser um inteiro ou double
			if (rightType == Types.STRING) {
				throw new RuntimeException("expected INT or DOUBLE.");
			} 
		}
	  	LOGIC_OP { exprString += " " + _input.LT(-1).getText(); }
	  	expression 
		{ 	
			// Expressao do If deve ser um inteiro ou double
			if (rightType == Types.STRING) {
				throw new RuntimeException("expected INT or DOUBLE, received STRING.");
			} 
		}
	  	CLOSE_PAREN { _cmdIf.setExpression(exprString.substring(1)); }
	  	OPEN_CB
  	  	command+ { _cmdIf.setTrueList(commandStack.pop()); }
	  	CLOSE_CB
	  	(	'else' 
			OPEN_CB { commandStack.push(new ArrayList<Command>()); }
	    	command+ { _cmdIf.setFalseList(commandStack.pop()); } CLOSE_CB
	  	)?
	  	'endif' { commandStack.peek().add(_cmdIf); }
	;

// Comando while
cmdWhile
	: 	'while' 
		{ 
			commandStack.push(new ArrayList<Command>());
			exprString = "";
			WhileCommand cmdWhile = new WhileCommand();
		}
		OPEN_PAREN
		expression 
		{ 
			if (rightType == Types.STRING) {
				throw new RuntimeException("expected INT or DOUBLE.");
			} 
		}
		LOGIC_OP { exprString += " " + _input.LT(-1).getText(); }
		expression 
		{ 
			if (rightType == Types.STRING) {
				throw new RuntimeException("expected INT or DOUBLE.");
			}
		}
		CLOSE_PAREN { cmdWhile.setExpression(exprString.substring(1)); } 
		OPEN_CB
		command+ { cmdWhile.setCommandList(commandStack.pop()); }
		CLOSE_CB { commandStack.peek().add(cmdWhile); } 
	;

// Numeric arithmetic expression
expression
    : term { exprString += " " + _input.LT(-1).getText();  } expression_md 
	;

term		
    : 	ID 
		{ 
			if ( !isDeclared(_input.LT(-1).getText()) ) {
				throw new RuntimeException(_input.LT(-1).getText()+" has not been declared.");
			} else if ( !symbolTable.get(_input.LT(-1).getText()).isInitialized() ) {
				throw new RuntimeException(_input.LT(-1).getText()+" has no value associated with it.");
			}
			
			if ( rightType == null ) {
				rightType = symbolTable.get(_input.LT(-1).getText()).getType();
			} else if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
				rightType = symbolTable.get(_input.LT(-1).getText()).getType();
			}
		}
    	| 
		INT 
		{ 	
			UnaryExpression elem = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
			exprStack.push(elem);

        	if ( rightType == null ) {
	      		rightType = Types.INT;
	    	} else if (rightType.getValue() < Types.INT.getValue()) { 
				rightType = Types.INT;
			}
	    } 
		| 
		DOUBLE 
		{
			UnaryExpression elem = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
			exprStack.push(elem);

			if ( rightType == null ) {
				rightType = Types.DOUBLE;
			} else if (rightType.getValue() < Types.DOUBLE.getValue()) {
				rightType = Types.DOUBLE;
			}
		}
		| 
		STRING 
		{
			if ( rightType == null ) {
				rightType = Types.STRING;
			} else if (rightType.getValue() < Types.STRING.getValue()) { 
				rightType = Types.STRING;
			}
		} 
    ;
    	
expression_md	
    : 	(
		(SUM | MUL | DIV | SUB | RESTO) 
		{ 
			BinaryExpression binExp = new BinaryExpression(_input.LT(-1).getText().charAt(0));
			binExp.setLeftSide(exprStack.pop());
			exprStack.push(binExp);
			
			exprString += " " + _input.LT(-1).getText();  
		}  
	    term 
		{ 
			AbstractExpression head = exprStack.pop();
			BinaryExpression root = (BinaryExpression) exprStack.pop();
			root.setRightSide(head);
			exprStack.push(root);

			exprString += " " + _input.LT(-1).getText();  
		} 
	  	) *
	;	



// Regras lexicas

ATTRIBUTION : '='
            ;
			
LOGIC_OP    : '<' | '<=' | '>' | '>=' | '==' | '!='
            ;

OPEN_PAREN  : '('
            ;

CLOSE_PAREN : ')'
            ;

OPEN_CB     : '{'
            ;

CLOSE_CB    : '}'
            ;

SUM			: '+'
			;

SUB			: '-'
			;

DIV			: '/'
			;

MUL			: '*'
			;

RESTO		: '%'
			;

ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
	
INT 		: '-'? [0-9]+
			;
			
DOUBLE     : '-'? [0-9]+ ('.' [0-9]+ )?
			;
			
			
VIRG		: ','
			;
						
PV			: ';'
            ;			
						
DP			: ':'
		    ;
		    			
WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;

STRING		: '"'.*?'"'
			;            


