grammar ProjGram;

@header {
	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;
}

@members {
    private HashMap<String, Variable> varMap = new HashMap<String, Variable>();
    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
    private Types currentType;
    
    public void updateType(){
    	for(Variable v: currentDecl){
    	   v.setType(currentType);
    	   varMap.put(v.getId(), v);
    	}
    }
    public void showVariables(){
        for (String id: varMap.keySet()){
        	System.out.println(varMap.get(id));
        }
    }
    public boolean isDeclared(Variable var) {
    	for (String id: varMap.keySet()) {
    		if (var.getId() == id) return true;
    	}
    	return false;
    }
}

// Regras sintaticas

program  
    : 'begin' 
      declare_var+ 
      ((command | expr) PV)+
      'end'
    ;
			
declare_var	
    : 'let' { currentDecl.clear(); } 
	  ('number' {currentType = Types.NUMBER;} 
       | 'text' {currentType = Types.TEXT;} 
       | 'boolean' {currentType = Types.BOOLEAN;})
	  ID        { currentDecl.add(new Variable(_input.LT(-1).getText()));}
	  (VIRG ID { currentDecl.add(new Variable(_input.LT(-1).getText()));})*	 
	  {updateType();}
	  PV 
    ;		

command
	: cmdAttrib
	| cmdRead
	| cmdWrite
	;

cmdAttrib
	: ID ATTRIBUTION expr
	;

cmdRead
	: 'read' OPEN_PAREN ID CLOSE_PAREN
	;

cmdWrite
	: 'print' OPEN_PAREN (termo)+ CLOSE_PAREN
	;

expr
    : termo expr_md 
	;
			
termo		
    : ID   
    | NUM 
    | TEXTO
    ;
			
expr_md		
    : (OP termo) *
	;	

repetition
    : 'while' OPEN_PAREN (ID | NUM) LOG_OP (ID | NUM) CLOSE_PAREN OPEN_CB instruction_block CLOSE_CB
    ;

instruction_block
    : expr PV 
    ;

// Regras lexicas

ATTRIBUTION : '='
            ;

TYPE		: 'number' {currentType = Types.NUMBER;} 
              | 'text' {currentType = Types.TEXT;} 
              | 'boolean' {currentType = Types.BOOLEAN;}
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

OP          : '+' | '-' | '*' | '/' | '**'
			;	
			
ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
			
NUM			: [0-9]+ ('.' [0-9]+ )?
			;			
			
VIRG		: ','
			;
						
PV			: ';'
            ;			
						
DP			: ':'
		    ;
		    			
WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;

TEXTO		: '"' ([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-')* '"'
			;            


