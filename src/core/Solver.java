package core;

import java.util.ArrayList;
import java.util.List;

import constraints.Constraint;

/**
 * 
 * Constraint Solver
 *
 */
public class Solver {
	// Fields
	private final List<Variable<?>> variables = new ArrayList<Variable<?>>();
	private final List<Constraint> constraints = new ArrayList<Constraint>();
	
	// Constructor
	public Solver() {
		
	}
	
	// Operations
	public void addVariable(Variable<?> var) {
		this.variables.add(var);
	}
	
	public void addConstraint(Constraint cons) {
		this.constraints.add(cons);
	}
	
	// Search for a result
	public void search() {
		// Reset all variables
		for (Variable<?> var : this.variables) {
			var.reset();
		}
		
		boolean searchCompleted = false;
		while (!searchCompleted) {
			
			// Assign a variable
			
			
			
			
			
			// check if all constraints are satisfied
			if (checkAllConstraints()) {
				printSolution();
				return;
			}
			else{
				// change variable
			}
			
			// Update variables
			searchCompleted = updateVariable();
					
		}
		
		// Solution not found
		System.out.println("No solution");
		return;
		
	}
	
	// Check if all constraints are satisfied
	private boolean checkAllConstraints() {
		for (Constraint cons : this.constraints){
			if (!cons.isValid()) {
				return false;
			}
		}
		return true;
	}
	
	// Update variables
	private boolean updateVariable() {
		// TODO: Algorithm for updating variables for all possible combinations
		return true;
	}
	
	// Print solution
	private void printSolution() {
		System.out.println("Found solution!");
		System.out.println("---------------");
		for (Variable<?> var : this.variables){
			System.out.println(var.name() + " = " + var.value);
		}
		System.out.println("---------------");
	}
	
}
