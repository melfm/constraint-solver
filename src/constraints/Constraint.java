package constraints;

/**
 * Simple abstract class, providing an abstract
 * propagate method which will be implemented
 * by the subclass.
 **/

public abstract class Constraint {

	//public abstract void Propagate();
	public abstract boolean isValid();
	
}
