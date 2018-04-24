package entities;
import org.json.*;

public class ThrowAble extends Item {
	private String type;
	private int damage;
	private int quantity;
	
	public ThrowAble() {
		super();
	}
	
	public ThrowAble(String n, String t, int d, int q) {
		super(n);
		this.type = t;
		this.damage = d;
		this.quantity = q;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getString("type"), json.getInt("damage"), json.getInt("quantity"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
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
	
	public int getQuantity() {
		return quantity;
	}
}