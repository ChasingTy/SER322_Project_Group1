package entities;

public class Standard extends HealingItem {
	private int tier;
	private int quantity;
	
	public Standard(String n, int t, int q) {
		super(n);
		this.tier = t;
		this.quantity = q;
	}
	
	public void setValues(String n, int t, int q) {
		this.setValues(n);
		this.tier = t;
		this.quantity = q;
	}
	
	public int getTier() {
		return tier;
	}
	
	public int getQuantity() {
		return quantity;
	}
}