package core;

import java.util.ArrayList;
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
	private final Map<String, IntVariable> intvariables = new LinkedHashMap<String, IntVariable>();
	private final List<Constraint> allconstraints = new ArrayList<Constraint>();
	private Iterator<IntVariable> variableIterator;

	// Constructor
	public Solver() {

	}

	public Map<String, IntVariable> allVariables() {
		return this.intvariables;
	}

	

}
