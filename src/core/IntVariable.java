package core;

import java.util.LinkedHashSet;
import java.util.Set;

import constraints.Constraint;

/**
 * 
 * This models an integer variables
 *
 */

public class IntVariable {
	
	private final String name;
	private final Integer low;
	private final Integer high;
	
	// Store these as set, to enable iteration ordering for heuristics
	private final Set<Integer> valueSet = new LinkedHashSet<Integer>();
	private final Set<Constraint> constraints = new LinkedHashSet<Constraint>();
	
	// Constructor
	public IntVariable(String name, Integer low, Integer high) {
		this.name= name;
		this.low = low;
		this.high = high;
	}
	
	// Getters
	public Integer high() {
		return this.high;
	}
	
	public Integer low() {
		return this.low;
	}
	public String name() {
		return this.name;
	}
	public Set<Integer> valueSet() {
		return this.valueSet;
	}
	public Set<Constraint> constraints() {
		return this.constraints;
	}
	
	// 
	// Initialize the value set with all the values in the domain
	//
	public void initialise() {
		// Generate all possible assignments
		this.valueSet.clear();
		for (int i= this.low; i <= this.high; i++) {
			this.valueSet.add(i);
		}
		
	}
	//
	// For each value, go through the list of *attached* constraints
	// i.e. propagate it to every constraint  associated with this variable
	//
	public boolean assignAndPropagate(Integer value) {
		// First clear the set
		this.valueSet.clear();
		// Now assign values
		this.valueSet.add(value);
		// Propagate assigned values to all attached constraints
		for(Constraint c : this.constraints) {
			if (!c.propagate(this)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void dump() {
		System.out.println(this.name + " : " + this.valueSet);
	}
	
}
