package constraints;

import java.util.ArrayList;
import java.util.List;

import core.IntVariable;

//
// Abstract class
// Models constraints as a CSP model
//

public abstract class Constraint {

	// Fields
	protected final List<IntVariable> variables = new ArrayList<IntVariable>();
	
	// Getter
	public List<IntVariable> variables() {
		return this.variables;
	}
	
	// 
	// Abstract method
	// Apply the constraint on the target variable using the given value
	//
	public abstract void applyConstraint(IntVariable target, Integer value);
	
	//
	// Propagate the value in the change variable to tell all
	// the variables bound this constraint
	//
	public boolean propagate(IntVariable changed) {
		
		return true;
	}
	
	
}
