package core;

import java.util.LinkedHashSet;
import java.util.Set;

import constraints.Constraint;

/**
 * 
 * This models integer variables
 *
 */

public class IntVariable {
	
	private final String name;
	private final Integer low;
	private final Integer high;
	
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
	
	// Operations
	public void initialise() {
		// Generate all possible assignments
		this.valueSet.clear();
		for (int i= this.low; i <= this.high; i++) {
			this.valueSet.add(i);
		}
		
	}
	// For each value, go through the list of *attached* constraints
	// and check the feasibility
	public boolean assignAndPropagate(Integer value) {
		// First clear the set
		this.valueSet.clear();
		this.valueSet.add(value);
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
