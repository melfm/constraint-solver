package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import constraints.Constraint;

/**
 * 
 * Constraint Solver
 * 
 */
public class Solver {
	// Fields
	private final List<Constraint> allConstraints = new ArrayList<Constraint>();
	private final List<IntVariable> allVariables = new ArrayList<IntVariable>();
	private final Set<String> varibaleNames = new HashSet<String>();
	
	private int cursor;
	private int numberOfNodes = 1;

	// Constructor
	public Solver() {

	}

	// Getters
	public List<IntVariable> allVariables() {
		return this.allVariables;
	}
	
	public List<Constraint> allconstraints() {
		return this.allConstraints;
	}
	
	public Set<String> variableNames() {
		return this.varibaleNames;
	}

	public int cursor() {
		return this.cursor;
	}
	
	// Setters
	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	//
	// Reset solver state
	//
	public void reset() {
		this.allConstraints.clear();
		this.allVariables.clear();
		this.varibaleNames.clear();
		this.cursor = 0;
	}
	
	//
	// Create variables in this solver context
	//
	public IntVariable createIntVariable(String name, int low, int high) throws Exception {
		// Make sure variable is not already defined!
		if (this.varibaleNames.contains(name)) {
			throw new Exception("Variable already exists.");
		}
		IntVariable variable = new IntVariable(name, low, high);
		this.varibaleNames.add(variable.name());
		this.allVariables.add(variable);
		return variable;
	}
	
	//
	// Add a constraint
	//
	public void addConstraint(Constraint constraint) throws Exception {
		// Make sure variables in the constraint are defined
		for (IntVariable v : constraint.variables()) {
			if (!this.varibaleNames.contains(v.name())) {
				throw new Exception("Variable not defined in the solver.");
			}
		}
		this.allConstraints.add(constraint);
	}
	
	//
	// Search for a solution
	// This calls the recursive guy
	//
	public void search() {
		// Init variables and start search
		for (IntVariable var : this.allVariables) {
			var.initialise();
			//var.dump();
		}
		// Start exploring search space
		searchRecursive();
		// If recursive search completes in full, then solution not found
		System.out.println("Solution not found :(");
	}
	
	//
	// Explore search space using Forward Checking
	// This is recursive
	//
	private void searchRecursive() {
		long startTime = System.nanoTime();
		
		// Get the next variable possibly with some heuristic
		IntVariable currentVar = getNextVariable();
		if (currentVar != null) {
			// Try assigning each value from the current value set
			// Make a copy of the value set as it gets overwritten
			Set<Integer> valueSet = new LinkedHashSet<Integer>(currentVar.valueSet());
			for (int value : valueSet) {
				// Backup variables
				Backup backup = new Backup(this);
				//Assign value to the variable
				if (currentVar.assignAndPropagate(value)) {
					// If successful, check if all variables have been reduced
					// to a single value. If that is the case and every variable
					// has been processed, then we have found a solution!
					// Keep track of number if nodes we are assigning
					numberOfNodes++;
					if (!isNextVariable() && checkAllVariablesAreSingle()) {
						printSolution();
						System.out.println("Number of nodes : " + numberOfNodes);
						long stopTime = System.nanoTime();
						long elapsedTime = (stopTime - startTime);
						double seconds = (double)(elapsedTime) / 1000000.0;
					    System.out.println("Time taken " + seconds);
						System.exit(0);
					}
					// Otherwise recurse to continue search
					searchRecursive();
				}
				// Restore variables
				backup.restore(this);
			}
			
		}
	}
	
	//
	// Return next variable
	//
	private IntVariable getNextVariable() {
		if (isNextVariable()) {
			return this.allVariables.get(this.cursor++);
		}
		return null;
	}
	
	private boolean isNextVariable() {
		return this.cursor < this.allVariables.size();
	}
	
	//
	// Check whether all variables are single
	//
	private boolean checkAllVariablesAreSingle() {
		for (IntVariable v : this.allVariables) {
			if (v.valueSet().size() != 1) {
				return false;
			}
		}
		return true;
	}
	
	//
	// Print solution
	//
	private void printSolution() {
		System.out.println("Found a solution!");
		System.out.println("----------------");
		for (IntVariable v : this.allVariables) {
			System.out.println(v.name() + ":" + v.valueSet());
		}
		System.out.println("----------------");
	}
}
