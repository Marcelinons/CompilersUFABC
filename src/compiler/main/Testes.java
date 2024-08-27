package compiler.main;
import java.util.HashMap;

import compiler.core.*;
import compiler.core.types.Types;
import compiler.core.types.Variable;

public class Testes {
	public HashMap<String, Variable> varMap = new HashMap<String, Variable>();
	
	public void main(String[] args) {
		String value = "9";
		System.out.println(value.matches("[0-9]+"));
	}
	
//    public boolean typeMatch(String id, String value) {
//    	// INT:   [0-9]+
//    	// FLOAT: [0-9]+ ('.' [0-9]+ )?
//    	// TEXT:  RESTO
//    	switch (value) {
//    	case (value.matches("[0-9]+") && (varMap.get(id).getType() == Types.INT)):
//    		return true;
//    	case (value.matches("[0-9]+ ('.' [0-9]+ )?") && (varMap.get(id).getType() == Types.FLOAT)):
//    		return true;
//    	case (value.matches("([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-')*") && (varMap.get(id).getType() == Types.TEXT) ):
//    		return true;
//    	}
//    	return false;	
//    }
}
