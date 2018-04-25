package entities;
import org.json.*;

public class Map {
	private String name;
	private int size;
	
	public Map() {
	}
	
	public Map(String n, int s) {
		this.name = n;
		this.size = s;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		json.put("size", this.size);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getInt("size"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, int s) {
		this.name = n;
		this.size = s;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
}