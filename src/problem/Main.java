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
//		test_CrystalMaze();
		test_Sudoku();
	}
		
	private static void test_Sudoku() {
		//
		// Models a Sudoku puzzle as a CSP to test the solver
		// The following Sukoku instance is modelled
		//
		// 8, 0, 0, 0, 0, 0, 0, 0 ,0
        // 0, 0, 3, 6, 0, 0, 0, 0, 0
        // 0, 7, 0, 0, 9, 0, 2, 0, 0
        // 0, 5, 0, 0, 0, 7, 0, 0, 0
        // 0, 0, 0, 0, 4, 5, 7, 0, 0
        // 0, 0, 0, 1, 0, 0, 0, 3, 0
        // 0, 0, 1, 0, 0, 0, 0, 6, 8
        // 0, 0, 8, 5, 0, 0, 0, 1, 0
        // 0, 9, 0, 0, 0, 0, 4, 0, 0
		
		try {
			// Create solver
			Solver solver = new Solver();
			
			// Define variables
			// Row 1
			IntVariable s01 = solver.createIntVariable("S01", 8, 8);	// 8
			IntVariable s02 = solver.createIntVariable("S02", 1, 9);
			IntVariable s03 = solver.createIntVariable("S03", 1, 9);
			IntVariable s04 = solver.createIntVariable("S04", 1, 9);
			IntVariable s05 = solver.createIntVariable("S05", 1, 9);
			IntVariable s06 = solver.createIntVariable("S06", 1, 9);
			IntVariable s07 = solver.createIntVariable("S07", 1, 9);
			IntVariable s08 = solver.createIntVariable("S08", 1, 9);
			IntVariable s09 = solver.createIntVariable("S09", 1, 9);
			// Row 2			
			IntVariable s10 = solver.createIntVariable("S10", 1, 9);
			IntVariable s11 = solver.createIntVariable("S11", 1, 9);
			IntVariable s12 = solver.createIntVariable("S12", 3, 3);	// 3
			IntVariable s13 = solver.createIntVariable("S13", 6, 6);	// 6
			IntVariable s14 = solver.createIntVariable("S14", 1, 9);
			IntVariable s15 = solver.createIntVariable("S15", 1, 9);
			IntVariable s16 = solver.createIntVariable("S16", 1, 9);
			IntVariable s17 = solver.createIntVariable("S17", 1, 9);
			IntVariable s18 = solver.createIntVariable("S18", 1, 9);
			// Row 3		
			IntVariable s19 = solver.createIntVariable("S19", 1, 9);
			IntVariable s20 = solver.createIntVariable("S20", 7, 7);	// 7
			IntVariable s21 = solver.createIntVariable("S21", 1, 9);
			IntVariable s22 = solver.createIntVariable("S22", 1, 9);
			IntVariable s23 = solver.createIntVariable("S23", 9, 9);	// 9
			IntVariable s24 = solver.createIntVariable("S24", 1, 9);
			IntVariable s25 = solver.createIntVariable("S25", 2, 2);	// 2
			IntVariable s26 = solver.createIntVariable("S26", 1, 9);
			IntVariable s27 = solver.createIntVariable("S27", 1, 9);
			// Row 4
			IntVariable s28 = solver.createIntVariable("S28", 1, 9);
			IntVariable s29 = solver.createIntVariable("S29", 5, 5);	// 5
			IntVariable s30 = solver.createIntVariable("S30", 1, 9);
			IntVariable s31 = solver.createIntVariable("S31", 1, 9);
			IntVariable s32 = solver.createIntVariable("S32", 1, 9);
			IntVariable s33 = solver.createIntVariable("S33", 7, 7);	// 7
			IntVariable s34 = solver.createIntVariable("S34", 1, 9);
			IntVariable s35 = solver.createIntVariable("S35", 1, 9);
			IntVariable s36 = solver.createIntVariable("S36", 1, 9);
			// Row 5
			IntVariable s37 = solver.createIntVariable("S37", 1, 9);
			IntVariable s38 = solver.createIntVariable("S38", 1, 9);
			IntVariable s39 = solver.createIntVariable("S39", 1, 9);
			IntVariable s40 = solver.createIntVariable("S40", 1, 9);
			IntVariable s41 = solver.createIntVariable("S41", 4, 4);	// 4
			IntVariable s42 = solver.createIntVariable("S42", 5, 5);	// 5
			IntVariable s43 = solver.createIntVariable("S43", 7, 7);	// 7
			IntVariable s44 = solver.createIntVariable("S44", 1, 9);
			IntVariable s45 = solver.createIntVariable("S45", 1, 9);
			// Row 6
			IntVariable s46 = solver.createIntVariable("S46", 1, 9);
			IntVariable s47 = solver.createIntVariable("S47", 1, 9);
			IntVariable s48 = solver.createIntVariable("S48", 1, 9);
			IntVariable s49 = solver.createIntVariable("S49", 1, 1);	// 1
			IntVariable s50 = solver.createIntVariable("S50", 1, 9);
			IntVariable s51 = solver.createIntVariable("S51", 1, 9);
			IntVariable s52 = solver.createIntVariable("S52", 3, 3);	// 3
			IntVariable s53 = solver.createIntVariable("S53", 1, 9);
			IntVariable s54 = solver.createIntVariable("S54", 1, 9);
			// Row 7
			IntVariable s55 = solver.createIntVariable("S55", 1, 9);
			IntVariable s56 = solver.createIntVariable("S56", 1, 9);
			IntVariable s57 = solver.createIntVariable("S57", 1, 1);	// 1
			IntVariable s58 = solver.createIntVariable("S58", 1, 9);
			IntVariable s59 = solver.createIntVariable("S59", 1, 9);
			IntVariable s60 = solver.createIntVariable("S60", 1, 9);
			IntVariable s61 = solver.createIntVariable("S61", 1, 9);
			IntVariable s62 = solver.createIntVariable("S62", 6, 6);	// 6
			IntVariable s63 = solver.createIntVariable("S63", 8, 8);	// 8
			// Row 8
			IntVariable s64 = solver.createIntVariable("S64", 1, 9);
			IntVariable s65 = solver.createIntVariable("S65", 1, 9);
			IntVariable s66 = solver.createIntVariable("S66", 8, 8);	// 8
			IntVariable s67 = solver.createIntVariable("S67", 5, 5);	// 5
			IntVariable s68 = solver.createIntVariable("S68", 1, 9);
			IntVariable s69 = solver.createIntVariable("S69", 1, 9);
			IntVariable s70 = solver.createIntVariable("S70", 1, 9);
			IntVariable s71 = solver.createIntVariable("S71", 1, 1);	// 1
			IntVariable s72 = solver.createIntVariable("S72", 1, 9);
			// Row 9
			IntVariable s73 = solver.createIntVariable("S73", 1, 9);
			IntVariable s74 = solver.createIntVariable("S74", 9, 9);	// 9
			IntVariable s75 = solver.createIntVariable("S75", 1, 9);
			IntVariable s76 = solver.createIntVariable("S76", 1, 9);
			IntVariable s77 = solver.createIntVariable("S77", 1, 9);
			IntVariable s78 = solver.createIntVariable("S78", 1, 9);
			IntVariable s79 = solver.createIntVariable("S79", 4, 4);	// 4
			IntVariable s80 = solver.createIntVariable("S80", 1, 9);
			IntVariable s81 = solver.createIntVariable("S81", 1, 9);

			// Constraints for rows
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s01, s02, s03, s04, s05, s06, s07, s08, s09}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s10, s11, s12, s13, s14, s15, s16, s17, s18}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s19, s20, s21, s22, s23, s24, s25, s26, s27}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s28, s29, s30, s31, s32, s33, s34, s35, s36}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s37, s38, s39, s40, s41, s42, s43, s44, s45}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s46, s47, s48, s49, s50, s51, s52, s53, s54}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s55, s56, s57, s58, s59, s60, s61, s62, s63}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s64, s65, s66, s67, s68, s69, s70, s71, s72}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s73, s74, s75, s76, s77, s78, s79, s80, s81}));			
			// Constraints for rows
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s01, s10, s19, s28, s37, s46, s55, s64, s73}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s02, s11, s20, s29, s38, s47, s56, s65, s74}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s03, s12, s21, s30, s39, s48, s57, s66, s75}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s04, s13, s22, s31, s40, s49, s58, s67, s76}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s05, s14, s23, s32, s41, s50, s59, s68, s77}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s06, s15, s24, s33, s42, s51, s60, s69, s78}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s07, s16, s25, s34, s43, s52, s61, s70, s79}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s08, s17, s26, s35, s44, s53, s62, s71, s80}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s09, s18, s27, s36, s45, s54, s63, s72, s81}));			
			// Constraints for 3x3 squares
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s01, s02, s03, s10, s11, s12, s19, s20, s21}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s04, s05, s06, s13, s14, s15, s22, s23, s24}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s07, s08, s09, s16, s17, s18, s25, s26, s27}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s28, s29, s30, s37, s38, s39, s46, s47, s48}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s31, s32, s33, s40, s41, s42, s49, s50, s51}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s34, s35, s36, s43, s44, s45, s52, s53, s54}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s55, s56, s57, s64, s65, s66, s73, s74, s75}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s58, s59, s60, s67, s68, s69, s76, s77, s78}));			
			solver.addConstraint(new AllDiffConstraint(new IntVariable[] {s61, s62, s63, s70, s71, s72, s79, s80, s81}));			
	
			// Search for a solution
			solver.search();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private static void test_CrystalMaze() {
		//
		// Models the Crystal Maze as a CSP to test the solver
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
