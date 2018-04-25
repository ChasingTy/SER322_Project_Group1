package entities;
import org.json.*;

public class Backpack extends Item {
	private int capacity;
	
	public Backpack() {
		super();
	}
	
	public Backpack(String n, int c) {
		super(n);
		this.capacity = c;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		json.put("capacity", this.capacity);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getInt("capacity"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, int c) {
		this.setValues(n);
		this.capacity = c;
	}
	
	public int getCapacity() {
		return capacity;
	}
}