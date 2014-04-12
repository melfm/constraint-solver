package core;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Backup variables in the case of backtracking
 *
 */
public class Backup {

	// Fields
	private final Map<String, Set<Integer>> saved = new LinkedHashMap<String, Set<Integer>>();
	private Integer cursor;
	
	// 
	// Constructor
	//
	public Backup(Solver solver) {
		save(solver);
	}
	
	//
	// Save variable value sets in the solver
	//
	public void save(Solver solver) {
		// Make copies of variable values sets along with their names
		this.saved.clear();
		for (IntVariable var : solver.allVariables()) {
			Set<Integer> copy = new LinkedHashSet<Integer>(var.valueSet());
			this.saved.put(var.name(), copy);
		}
		this.cursor = solver.cursor();
	}
	//
	// Restore variable value sets back to the solver
	//
	public void restore(Solver solver){
		// Copy saved value sets back to the variable in the solver
		for (IntVariable var : solver.allVariables()) {
			assert (saved.containsKey(var.name()));
			var.valueSet().clear();
			var.valueSet().addAll(this.saved.get(var.name()));
		}
		solver.setCursor(this.cursor);
	}
	
}
