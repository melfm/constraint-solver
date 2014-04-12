package constraints;

import core.IntVariable;

// This is also an abstract class since it's used as special case
// where we have a constraint applied to two variables
public abstract class ConstraintTwoVariables extends Constraint {


	public ConstraintTwoVariables(IntVariable var1, IntVariable var2) {
		this.variables.add(var1);
		this.variables.add(var2);
		var1.constraints().add(this);
		var2.constraints().add(this);
		
	}

}
