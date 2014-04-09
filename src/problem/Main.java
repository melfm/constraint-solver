package problem;

import constraints.DisequalityConstraint;
import constraints.InequalityConstraint;
import core.IntVariable;
import core.Solver;

public class Main {

	public static void main(String[] args) {
		
		//
		// A simple CSP model for testing our solver
		//
		
		// Create solver
		Solver solver = new Solver();
		
		// Define variables and add them to solver
		IntVariable varX = new IntVariable("X", 0, 10);
		IntVariable varY = new IntVariable("Y", 0, 10);
		
		solver.addVariable(varX);
		solver.addVariable(varY);
		
		// Define constraints and add them to solver
		//AllDiffConstraint consAllDiff = new AllDiffConstraint(new IntVariable[] {varX, varY});
		DisequalityConstraint consNotEq = new DisequalityConstraint(varX, varY);
		solver.addConstraint(consNotEq);
		
		// Search for a solution
		solver.search();

		

	}

}
