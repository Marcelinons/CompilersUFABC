grammar ProjGram;

@header {
	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;
	import compiler.core.exceptions.*;
}

@members {
    private HashMap<String, Variable> varMap = new HashMap<String, Variable>();
    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
    
    private Types currentType;
    
    public void updateType() {
    	for(Variable v: currentDecl){
    	   v.setType(currentType);
    	   varMap.put(v.getId(), v);
    	}
    }
    
    public void updateValue(String id, String value) {
    	if (isString(value)) {
		  varMap.get(id).setValue((String)value);
    	} else if (isInteger(value)) {
    	  varMap.get(id).setValue(Integer.parseInt(value));
    	} else if (isFloat(value)) {
    	  varMap.get(id).setValue(Double.parseDouble(value));
    	}
    }
    
    public void showVariables(){
        for (String id: varMap.keySet()){
        	System.out.println(varMap.get(id));
        }
    }
    
    // Variavel declarada returns True
    public boolean isDeclared(String id) {
    	return varMap.get(id) != null;
    }
    
    // Checar tipo de variavel
    public boolean typeMatch(String id, String value) {    	
    	if (varMap.get(id) == null) {return false;} 
    	Types tipo_var = varMap.get(id).getType();
    	
    	if (value.matches("[0-9]+") && (tipo_var == Types.INT)) {;
    		return true;
    	}
    	else if (value.matches("[0-9]+ ('.' [0-9]+ )?") && (tipo_var == Types.FLOAT)) {
    		return true;
    	}
    	else if (value.matches("\"([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-')* \"") && (tipo_var == Types.TEXT) ) {
    		return true;
    	}
    	else {return false;}	
    }
    
    // Checa se eh inteiro
    public boolean isInteger(String value) {
    	if (value.matches("[0-9]+")) {;
    		return true;
    	} else return false;
    }
    
    // Checa se eh float
    public boolean isFloat(String value) {
    	if (value.matches("-?\\d*(\\.\\d+)?")) {
    		return true;
    	} else return false;
    }
    
    /**
    * Verifica se um valor eh uma string
    */
    public boolean isString(String value) {
    	if (value.matches("^\".*\"$")) {
    		return true;
    	} else return false;
    }
    
    public boolean isNumber(String value) {
    	if (isFloat(value) || isInteger(value)) return true;
    	else return false;
    }
}

/** 
* Regras sintaticas 
*/

// Bloco principal do programa
program  
    : 'BEGIN' 
      declare_var+ 
      ((command | num_expr) PV)+
      'END'
    ;

// Declaracao de variaveis		
declare_var	
    : 'LET' { currentDecl.clear(); } 
	  ('INT' {currentType = Types.INT;} 
       | 'TEXT' {currentType = Types.TEXT;} 
       | 'FLOAT' {currentType = Types.FLOAT;}
      )
	  ID { if (isDeclared(_input.LT(-1).getText())) {
	           throw new SemanticException(_input.LT(-1).getText()+" is already declared.");
	       }
	     } 
	     { currentDecl.add(new Variable(_input.LT(-1).getText())); }
	  
	  (VIRG ID { currentDecl.add(new Variable(_input.LT(-1).getText()));} )*	 
	  {updateType();}
	  PV 
    ;		

// Linha de codigo
command
	: cmdAttrib
	| cmdRead
	| cmdWrite
	;

// Atribuicao/Inicializacao de variavel
cmdAttrib
	: ID { 
		String curr_id = _input.LT(-1).getText();
	    if (!isDeclared(curr_id)) {
	      throw new SemanticException(curr_id+" has not been declared.");
	    }
	    currentType = varMap.get(curr_id).getType();
	  }
	  ATTRIBUTION
	  ( num_expr | TEXTO ) { 
	    updateValue(curr_id, _input.LT(-1).getText()); }
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
	;

// Print na tela
cmdWrite
	: 'print' OPEN_PAREN (num_expr | TEXTO)+ CLOSE_PAREN
	;

// Expressao aritmetica
num_expr
    : num_term expr_md 
	;

// Termo de expressao
num_term		
    : ID { 
        if ( !isDeclared(_input.LT(-1).getText()) ) {
		  throw new SemanticException(_input.LT(-1).getText()+" has not been declared.");
	    }
	    if ( !isInteger(_input.LT(-1).getText()) || !isFloat(_input.LT(-1).getText()) ) {
	      throw new TypeMismatchException(_input.LT(-1).getText()+" is of type "+ varMap.get(_input.LT(-1).getText()).getType() +". INT or FLOAT expected.");
	    }
	  }
    | number
    ;

// Meio / continuacao da expressao		
expr_md		
    : ( OP  num_term) *
	;	

// Bloco de repeticao 
repetition
    : 'while' OPEN_PAREN (ID | number) LOG_OP (ID | number) CLOSE_PAREN OPEN_CB instruction_block CLOSE_CB
    ;

instruction_block
    : num_expr PV 
    ;

number
	: (INT | FLOAT)
	;

// Regras lexicas

ATTRIBUTION : '='
            ;

TYPE		: 'INT' {currentType = Types.INT;} 
              | 'TEXT' {currentType = Types.TEXT;} 
              | 'FLOAT' {currentType = Types.FLOAT;}
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
	
INT 		: [0-9]+
			;
			
FLOAT       : [0-9]+ ('.' [0-9]+ )?
			;
			
			
VIRG		: ','
			;
						
PV			: ';'
            ;			
						
DP			: ':'
		    ;
		    			
WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;

TEXTO		: '"'.*?'"'
			;            


