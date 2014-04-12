package problem;

import constraints.AllDiffConstraint;
import constraints.ConstraintDiffGreaterThan;
import constraints.DisequalityConstraint;
import constraints.EqualityConstraint;
import core.IntVariable;
import core.Solver;


public class Main {
	public static void main(String[] args) throws Exception {
		//
		// Run unit tests
		//
//		test_AllDiff();
//		test_Equal();
//		test_NotEqual();
//		test_DiffGreaterThan();
		
		//
		// Model the Crystal Maze CSP for testing the solver
		//
		try {
			// Create solver
			Solver solver = new Solver();
			
			// Define variables
			IntVariable x1 = solver.createIntVariable("X1", 1, 8);
			IntVariable x2 = solver.createIntVariable("X2", 1, 8);
			IntVariable x3 = solver.createIntVariable("X3", 1, 8);
			IntVariable x4 = solver.createIntVariable("X4", 1, 8);
			IntVariable x5 = solver.createIntVariable("X5", 1, 8);
			IntVariable x6 = solver.createIntVariable("X6", 1, 8);
			IntVariable x7 = solver.createIntVariable("X7", 1, 8);
			IntVariable x8 = solver.createIntVariable("X8", 1, 8);
			
			// Define constraints and add to solver
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {x1, x2, x3, x4, x5, x6, x7, x8}));			
			solver.addConstraint(new ConstraintDiffGreaterThan(x1, x2, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x1, x3, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x1, x4, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x1, x5, 1));
			
			solver.addConstraint(new ConstraintDiffGreaterThan(x2, x4, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x2, x5, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x2, x6, 1));
						
			solver.addConstraint(new ConstraintDiffGreaterThan(x3, x4, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x3, x7, 1));
			
			solver.addConstraint(new ConstraintDiffGreaterThan(x4, x5, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x4, x7, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x4, x8, 1));

			solver.addConstraint(new ConstraintDiffGreaterThan(x5, x6, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x5, x7, 1));
			solver.addConstraint(new ConstraintDiffGreaterThan(x5, x8, 1));
			
			solver.addConstraint(new ConstraintDiffGreaterThan(x6, x8, 1));
			
			solver.addConstraint(new ConstraintDiffGreaterThan(x7, x8, 1));

			// Search for a solution
			solver.search();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//
	// Test: AllDiff
	//
	private static void test_AllDiff() {
		try {
			System.out.println("Testing AllDiff...");
			Solver solver = new Solver();
			IntVariable varX = solver.createIntVariable("X", 1, 4);
			IntVariable varY = solver.createIntVariable("Y", 1, 3);
			IntVariable varZ = solver.createIntVariable("Z", 1, 2);
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {varX, varY, varZ}));			
			solver.search();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//
	// Test: Equal
	//
	private static void test_Equal() {
		try {
			System.out.println("Testing Equal...");
			Solver solver = new Solver();
			IntVariable varX = solver.createIntVariable("X", 1, 4);
			IntVariable varY = solver.createIntVariable("Y", 4, 5);
			solver.addConstraint(new EqualityConstraint(varX, varY));			
			solver.search();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	//
	// Test: NotEqual
	//
	private static void test_NotEqual() {
		try {
			System.out.println("Testing NotEqual...");
			Solver solver = new Solver();
			IntVariable varX = solver.createIntVariable("X", 1, 4);
			IntVariable varY = solver.createIntVariable("Y", 1, 2);
			solver.addConstraint(new DisequalityConstraint(varX, varY));			
			solver.search();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	//
	// Test: DiffGreaterThan
	//
	private static void test_DiffGreaterThan() {
		try {
			System.out.println("Testing DiffGreaterThan...");
			Solver solver = new Solver();
			IntVariable varX = solver.createIntVariable("X", 1, 4);
			IntVariable varY = solver.createIntVariable("Y", 1, 2);
			solver.addConstraint(new ConstraintDiffGreaterThan(varX, varY, 1));			
			solver.search();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
