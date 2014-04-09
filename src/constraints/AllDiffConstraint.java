package constraints;

import core.Variable;

public class AllDiffConstraint extends Constraint {

	// Fields
		private final Variable[] vars;

		// Constructor
		public AllDiffConstraint(Variable[] vars) {
			this.vars = vars;
		}
		
		// Validate constraint
		@Override
		public boolean isValid() {
			// TODO: implement AllDiff
			return true;
		}
}
