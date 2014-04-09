package core;


/**
 * Abstract class
 * Models variable in a CSP model
 **/
public abstract class Variable<T> {

	// Fields
	private final String name;
	protected T value;
	
	// Constructor
	public Variable(String name) {
		this.name = name;
	}
	// Getters
	public String name() {
		return this.name;
	}
	public T value() {
		return this.value;
	}
	// Setters
	public abstract void setValue(T value) throws Exception;
	// Operations
	public abstract void reset();
}
