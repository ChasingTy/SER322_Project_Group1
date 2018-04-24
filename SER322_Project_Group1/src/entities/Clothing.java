package entities;

public class Clothing extends Item {
	private String slot;
	
	public Clothing(String n, String s) {
		super(n);
		this.slot = s;
	}
	
	public void setValues(String n, String s) {
		this.setValues(n);
		this.slot = s;
	}
	
	public String getSlot() {
		return slot;
	}
}