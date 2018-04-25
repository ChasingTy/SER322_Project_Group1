package entities;
import org.json.*;

public class Vehicle {
	private String name;
	private int health;
	private int numSeats;
	private int topSpeed;
	
	public Vehicle() {
	}
	
	public Vehicle(String n, int h, int s, int t) {
		this.name = n;
		this.health = h;
		this.numSeats = s;
		this.topSpeed = t;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.name);
		json.put("health", this.health);
		json.put("numSeats", this.numSeats);
		json.put("topSpeeds", this.topSpeed);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getInt("health"), json.getInt("numSeats"), json.getInt("topSpeed"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, int h, int s, int t) {
		this.name = n;
		this.health = h;
		this.numSeats = s;
		this.topSpeed = t;
	}

	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getNumSeats() {
		return numSeats;
	}
	public int getTopSpeed() {
		return topSpeed;
	}
}