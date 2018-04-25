package entities;
import org.json.*;

public class Ammo extends Item {
	private String type;
	private int quantity;
	
	public Ammo() {
		super();
	}
	
	public Ammo(String n, String t, int q) {
		super(n);
		this.type = t;
		this.quantity = q;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		json.put("type", this.type);
		json.put("quantity", this.quantity);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getString("type"), json.getInt("quantity"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, String t, int q) {
		this.setValues(n);
		this.type = t;
		this.quantity = q;
	}
	
	public String getType() {
		return type;
	}
	
	public int getQuantity() {
		return quantity;
	}
}