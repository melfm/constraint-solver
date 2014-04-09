package problem;

import static org.junit.Assert.*;

import org.junit.Test;

import constraints.DisequalityConstraint;
import constraints.EqualityConstraint;
import constraints.InequalityConstraint;
import core.IntVariable;
import core.Solver;

public class ConstraintTest {

	@Test(expected=IndexOutOfBoundsException.class)
	public void testDomain() throws Exception {
		// Define variable domain
		IntVariable varX = new IntVariable("X", 1, 8);
		varX.setValue(10);
	}
	
	@Test
	public void testDomainSum() throws Exception {
		// Define variable domain
		IntVariable varX = new IntVariable("X", 1, 5);
		IntVariable varY = new IntVariable("Y", 1, 5);
		varX.setValue(2);
		varY.setValue(4);
		int sum = varX.value() + varY.value();
		assertTrue(sum < 8);
	}
	
	@Test
	public void testEqualityConstraint() throws Exception {
		// Define variable domain
		// Create solver
		Solver solver = new Solver();
		IntVariable varX = new IntVariable("X", 1, 5);
		IntVariable varY = new IntVariable("Y", 1, 5);
		varX.setValue(2);
		varY.setValue(2);
		EqualityConstraint consEq = new EqualityConstraint(varX, varY);
		solver.addConstraint(consEq);
		assertTrue(consEq.isValid());
	}
	
	@Test
	public void testDisqualityConstraint() throws Exception {
		// Define variable domain
		// Create solver
		Solver solver = new Solver();
		IntVariable varX = new IntVariable("X", 1, 5);
		IntVariable varY = new IntVariable("Y", 1, 5);
		varX.setValue(2);
		varY.setValue(4);
		DisequalityConstraint consNotEq = new DisequalityConstraint(varX, varY);
		solver.addConstraint(consNotEq);
		assertTrue(consNotEq.isValid());
	}
	
	@Test
	public void testInequalityConstraint() throws Exception {
		// Define variable domain
		// Create solver
		Solver solver = new Solver();
		IntVariable varX = new IntVariable("X", 1, 5);
		IntVariable varY = new IntVariable("Y", 1, 5);
		varX.setValue(2);
		varY.setValue(4);
		InequalityConstraint consLessThan = new InequalityConstraint(varX, varY);
		solver.addConstraint(consLessThan);
		assertTrue(consLessThan.isValid());
	}

}
