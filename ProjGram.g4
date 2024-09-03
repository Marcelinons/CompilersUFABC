grammar ProjGram;

@header {
	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;
	import compiler.core.exceptions.*;
}

@members {
    private HashMap<String, Variable> symbolTable = new HashMap<String, Variable>();
    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
    private Types currentType, leftType=null, rightType=null;
    
    public void updateType() {
    	for(Variable v: currentDecl){
    	   v.setType(currentType);
    	   symbolTable.put(v.getId(), v);
    	}
    }
    
    /**
    * Returns all declared IDs that have not been used on the program
    */
    public void declaredNotUsed() {
    	boolean first = true;
    	for (String id: symbolTable.keySet()) {
    	    if (!symbolTable.get(id).isInitialized()) {
    	      if (first) { 
    	        System.out.print("\nWarning: the following variables have not been used: \n[");
    	        first = false;
    	      }
    	      System.out.print(symbolTable.get(id).getId()+", ");
    	    }
    	}
    	if (!first) System.out.println("]");
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
    
    /**
    * Checks if given value is of type INT
    */
    public boolean isNumeric(String value) {
    	if (value.matches("-?\\d*(\\.\\d+)?")) {
    		return true;
    	} else return false;
    }
    
    /**
    * Checks if a given value is of type STRING
    */
    public boolean isString(String value) {
    	if (value.matches("^\".*\"$")) {
    		return true;
    	} else return false;
    }
}

/** 
* Regras sintaticas 
*/

// Bloco principal do programa
program  
    : 'PROGRAM'
      declare_var+ 
      'BEGIN' 
      command+
      'END'
    ;

// Declaracao de variaveis		
declare_var	
    : 'LET' { currentDecl.clear(); } 
	  (  'INT' {currentType = Types.INT;} 
       | 'STRING' {currentType = Types.STRING;} 
       | 'DOUBLE' {currentType = Types.DOUBLE;}
      )
	  ID { if (isDeclared(_input.LT(-1).getText())) {
	           throw new SemanticException(_input.LT(-1).getText()+" has already been declared.");
	       }
	     } 
	     { currentDecl.add(new Variable(_input.LT(-1).getText())); }
	  
	  (VIRG ID { currentDecl.add(new Variable(_input.LT(-1).getText()));} )*	 
	  {updateType();}
	  PV
    ;		

// Linha de codigo
command
	:  cmdAttrib
	   | cmdRead
	   | cmdWrite
	   | cmdIf
	   | cmdWhile
	  
	;

// Atribuicao/Inicializacao de variavel
cmdAttrib
	: ID { 
	    String curr_id = _input.LT(-1).getText();
	    if ( !isDeclared(curr_id) ) {
	      throw new SemanticException(curr_id+" has not been declared.");
	    }
	    leftType = symbolTable.get(curr_id).getType();
	  }
	  ATTRIBUTION
	  ( expression | STRING ) {
	  	if (leftType.getValue() < rightType.getValue()) {
	  	  throw new TypeMismatchException(symbolTable.get(curr_id).getId()+" expected "+leftType+". Received "+rightType+".");
	  	}
	  	symbolTable.get(curr_id).setInitialized(true);
		leftType = rightType = null;
	  }
	  PV
	;

// Ler do teclado
cmdRead
	: 'read' 
	   OPEN_PAREN 
	   ID { if (!isDeclared(_input.LT(-1).getText())) {
	          throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
	        }
	      } 
	   CLOSE_PAREN
	   PV
	;

// Print
cmdWrite
	: 'print' 
	  OPEN_PAREN 
	  (ID { 
	     if ( !isDeclared(_input.LT(-1).getText()) ) {
	       throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
	     } 
	     if ( !symbolTable.get(_input.LT(-1).getText()).isInitialized() ) {
	       throw new SemanticException(_input.LT(-1).getText()+" has no value associated with it.");
	     }
	   } 
	   | expression {leftType = rightType = null;}
	  ) 
	  CLOSE_PAREN
	  PV
	;

// Comando IF
cmdIf
	: 'if'
	  OPEN_PAREN
	  logical_expression
	  CLOSE_PAREN
	  OPEN_CB
  	  ( command | expression ) +
	  CLOSE_CB
	  ('else' cmdIf)?
	  ('else' OPEN_CB ( command | expression ) * CLOSE_CB)?
	;

// Comando while
cmdWhile
	: 'while'
	  OPEN_PAREN
	  logical_expression
	  CLOSE_PAREN
	  OPEN_CB
  	  ( command | expression ) +
	  CLOSE_CB
	;

logical_expression
	: ( (expression | ID) LOG_OP (expression | ID) ( ('&&' | '||') (expression | ID) LOG_OP (expression | ID) )*? )
	;

// Numeric arithmetic expression
expression
    : term expression_md 
	;

term		
    : ID { 
        if ( !isDeclared(_input.LT(-1).getText()) ) {
		  throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
	    } 
	    if ( !symbolTable.get(_input.LT(-1).getText()).isInitialized() ) {
	      throw new SemanticException(_input.LT(-1).getText()+" has no value associated with it.");
	    }
	    if ( rightType == null ) {
	      rightType = symbolTable.get(_input.LT(-1).getText()).getType();
	    } else {
	      if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
	        rightType = symbolTable.get(_input.LT(-1).getText()).getType();
	      }
	    }
	  }
	  
    | INT { 
        if ( rightType == null ) {
	      rightType = Types.INT;
	    } else { 
	      if (rightType.getValue() < Types.INT.getValue()) {
	        rightType = Types.INT;
	      }
	    } 
	  }
	  
	| DOUBLE {
		if ( rightType == null ) {
		  rightType = Types.DOUBLE;
		} else {
		  if (rightType.getValue() < Types.DOUBLE.getValue()) {
		    rightType = Types.DOUBLE;
		  }
		}
	}
	  
	| STRING {
	    if ( rightType == null ) {
	      rightType = Types.STRING;
	    } else { 
	      if (rightType.getValue() < Types.STRING.getValue()) {
	        rightType = Types.STRING;
	      }
	    }
	  } 
    ;
    	
expression_md	
    : (OP  term) *
	;	



// Regras lexicas

ATTRIBUTION : '='
            ;

TYPE		: 'INT' {currentType = Types.INT;} 
              | 'STRING' {currentType = Types.STRING;} 
			;
			
LOG_OP      : '<' | '<=' | '>' | '>=' | '==' | '<>'
            ;

OPEN_PAREN  : '('
            ;

CLOSE_PAREN : ')'
            ;

OPEN_CB     : '{'
            ;

CLOSE_CB    : '}'
            ;

OP          : '+' | '*' | '/' | '-' | '**'
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


