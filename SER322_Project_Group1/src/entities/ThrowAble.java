package entities;

public class ThrowAble extends Item {
	private String type;
	private int damage;
	private int quantity;
	
	public ThrowAble(String n, String t, int d, int q) {
		super(n);
		this.type = t;
		this.damage = d;
		this.quantity = q;
	}
	
	public void setValues(String n, String t, int d, int q) {
		this.setValues(n);
		this.type = t;
		this.damage = d;
		this.quantity = q;
	}
	
	public String getType() {
		return type;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getQuatity() {
		return quantity;
	}
}