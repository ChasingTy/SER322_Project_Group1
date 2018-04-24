package entities;
import org.json.*;

public class Clothing extends Item {
	private String slot;
	
	public Clothing() {
		super();
	}
	
	public Clothing(String n, String s) {
		super(n);
		this.slot = s;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getString("slot"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, String s) {
		this.setValues(n);
		this.slot = s;
	}
	
	public String getSlot() {
		return slot;
	}
}