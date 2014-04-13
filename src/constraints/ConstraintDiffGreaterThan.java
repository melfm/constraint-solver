package constraints;

import java.util.Iterator;

import core.IntVariable;

public class ConstraintDiffGreaterThan extends ConstraintTwoVariables {

	// Fields
	private final Integer constant;
	
	// Constructor
		public ConstraintDiffGreaterThan(IntVariable arg0, IntVariable arg1, Integer constant) {
			super(arg0, arg1);
			this.constant = constant;
		}
		
		//
		// Apply constraint
		//
		@Override
		public void applyConstraint(IntVariable target, Integer value) {
			// Remove everything in the target having difference with the given value
			// that is less than or equal to the specified constant
			for (Iterator<Integer> it = target.valueSet().iterator(); it.hasNext();) {
				if (Math.abs(it.next() - value) <= this.constant) {
					it.remove();
				}
			}
		}
	

}
