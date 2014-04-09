package constraints;

import core.Variable;

/**
 * 
 * Constraint: Equal
 *
 */
public class EqualityConstraint extends Constraint{

	// Fields
	private final Variable<?> one;
	private final Variable<?> two;
	
	// Constructor
	public EqualityConstraint(Variable<?> one, Variable<?> two){
		this.one = one;
		this.two = two;
	}
	
	@Override
	public boolean isValid() {
		if (this.one.value().equals(this.two.value())) {
			return true;
		}
		return false;
	}

}
