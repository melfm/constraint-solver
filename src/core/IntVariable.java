package core;

/**
 * 
 * This models integer variables
 *
 */

public class IntVariable extends Variable<Integer> {
	
	private final Integer low;
	private final Integer high;
	
	public IntVariable(String name, Integer low, Integer high) {
		super(name);
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
	

	// Setters
	@Override
	public void setValue(Integer value) throws Exception {
		if (value < this.low || value > this.high) {
			throw new IndexOutOfBoundsException("Value outside the domain");
		}
		this.value = value;
	}

	// Operations
	@Override
	public void reset() {
		this.value = this.low;
		
	}
	
}
