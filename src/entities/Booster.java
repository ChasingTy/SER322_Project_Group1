package entities;
import org.json.*;

public class Booster extends HealingItem {
	private int health;
	private int energy;
	
	public Booster() {
		super();
	}
	
	public Booster(String n, int h, int e) {
		super(n);
		this.health = h;
		this.energy = e;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		json.put("health", this.health);
		json.put("energy", this.energy);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getInt("health"), json.getInt("energy"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, int h, int e) {
		this.setValues(n);
		this.health = h;
		this.energy = e;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getEnergy() {
		return energy;
	}
}