package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		return null;
	}
	
	//
	// Add a constraint
	//
	public void addConstraint(Constraint constraint) throws Exception {
		
	}
	
	//
	// Search for a solution
	// This calls the recursive guy
	//
	public void search() {
		
	}
	
	//
	// Explore search space using Forward Checking
	// This guy is recursive
	//
	private void searchRecursive() {
		
	}
	
	//
	// Return next variable
	//
	private IntVariable getNextVariable() {
		return null;
	}
	
	private boolean isNextVariable() {
		return false;
	}
	
	//
	// Check whether all variables are single
	//
	private boolean checkAllVariablesAreSingle() {
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
