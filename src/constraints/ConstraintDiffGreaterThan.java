package constraints;

import java.util.Iterator;

import core.IntVariable;

public class ConstraintDiffGreaterThan extends ConstraintTwoVariables {

	// Fields
	private final Integer constant;
	
	// Constructor
	public ConstraintDiffGreaterThan(IntVariable var1, IntVariable var2, Integer constant) {
		super(var1, var2);
		this.constant = constant;
	}
	@Override
	public void applyConstraint(IntVariable target, Integer value) {
		// Remove everything in the target having difference with the given value
		// that is less than or equal to the specified constant
		for (Iterator<Integer> it = target.valueSet().iterator(); it.hasNext();) {
			if (Math.abs(it.next() - value ) <= this.constant) {
				it.remove();
			}
		}
		
	}
	

}
