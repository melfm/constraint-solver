package constraints;

import core.IntVariable;


public class AllDiffConstraint extends Constraint {

	
	// Constructor
	public AllDiffConstraint(IntVariable[] vars) {
		// Add to list of variables
		for(int i = 0; i < vars.length; ++i){
			// Add the variable to the variables set
			this.variables.add(vars[i]);
			// Attach this constraint to that variable
			vars[i].constraints().add(this);
		}
	}
	
	
	@Override
	public void applyConstraint(IntVariable target, Integer value) {
		target.valueSet().remove(value);
		
	}

		
}
