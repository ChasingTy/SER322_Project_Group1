package entities;

public class Ammo extends Item {
	private String type;
	private int quantity;
	
	public Ammo(String n, String t, int q) {
		super(n);
		this.type = t;
		this.quantity = q;
	}
	
	public void setValues(String n, String t, int q) {
		this.setValues(n);
		this.type = t;
		this.quantity = q;
	}
	
	public String getType() {
		return type;
	}
	
	public int getQuatity() {
		return quantity;
	}
}