package constraints;

import core.IntVariable;

/**
 * 
 * Constraint: Not equal
 *
 */
public class DisequalityConstraint extends ConstraintTwoVariables {

	// Constructor
	public DisequalityConstraint(IntVariable var1, IntVariable var2) {
		super(var1, var2);
	}

	@Override
	// Not equal constraint means target cannot possibly take this value
	// Hence remove it from the domain of possible values
	public void applyConstraint(IntVariable target, Integer value) {
		// Remove the given value from target
		target.valueSet().remove(value);
		
	}
	
	

}
