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