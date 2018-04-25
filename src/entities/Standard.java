package entities;
import org.json.*;

public class Standard extends HealingItem {
	private int tier;
	private int quantity;
	
	public Standard() {
		super();
	}
	
	public Standard(String n, int t, int q) {
		super(n);
		this.tier = t;
		this.quantity = q;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		json.put("tier", this.tier);
		json.put("quantity", this.quantity);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getInt("tier"), json.getInt("quantity"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
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