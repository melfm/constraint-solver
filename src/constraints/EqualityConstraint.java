package constraints;

import core.IntVariable;

/**
 * 
 * Constraint: Equal
 *
 */
public class EqualityConstraint extends ConstraintTwoVariables{

	// Constructor
	public EqualityConstraint (IntVariable var1, IntVariable var2) {
		super(var1, var2);
	}
	
	// Operation
	@Override
	public void applyConstraint(IntVariable target, Integer value) {
		// Remove everything and add the one back in
		boolean exists = target.valueSet().contains(value);
		target.valueSet().clear();
		if(exists) {
			// It did exist so only add that value now
			target.valueSet().add(value);
		}
		
	}

	

}
