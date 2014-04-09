package constraints;

import core.Variable;

public class InequalityConstraint  extends Constraint {

		// Fields
		private final Variable<Integer> one;
		private final Variable<Integer> two;
		
		// Constructor
		public InequalityConstraint(Variable<Integer> one, Variable<Integer> two){
			this.one = one;
			this.two = two;
		}
		
		public boolean isValid() {
			if ((this.one.value()) < (this.two.value())) {
				return true;
			}
			return false;
		}
	
	
}
