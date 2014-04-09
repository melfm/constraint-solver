package constraints;

import core.Variable;

/**
 * 
 * Constraint: Not equal
 *
 */
public class DisequalityConstraint extends EqualityConstraint {
	
	// Constructor
		public DisequalityConstraint(Variable<?> one, Variable<?> two) {
			super(one, two);
		}

		// Validate constraint
		// Hard work done by equal, just negate it
		@Override
		public boolean isValid() {
			return !super.isValid();
		}

}
