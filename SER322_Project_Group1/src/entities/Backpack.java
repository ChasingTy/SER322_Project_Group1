package entities;

public class Backpack extends Item {
	private int capacity;
	
	public Backpack(String n, int c) {
		super(n);
		this.capacity = c;
	}
	
	public void setValues(String n, int c) {
		this.setValues(n);
		this.capacity = c;
	}
	
	public int getCapacity() {
		return capacity;
	}
}