package entities;
import org.json.*;

public class HealingItem extends Item {

	public HealingItem() {
		super();
	}
	
	public HealingItem(String n) {
		super(n);
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
}