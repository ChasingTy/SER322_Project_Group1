package entities;
import org.json.*;

public class Armor extends Item {
	private String slot;
	private int durability;
	private int rating;
	private int tier;
	
	public Armor() {
		super();
	}
	
	public Armor(String n, String s, int d, int r, int t) {
		super(n);
		this.slot = s;
		this.durability = d;
		this.rating = r;
		this.tier = t;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getString("slot"), json.getInt("durability"), json.getInt("rating"), json.getInt("tier"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, String s, int d, int r, int t) {
		this.setValues(n);
		this.slot = s;
		this.durability = d;
		this.rating = r;
		this.tier = t;
	}
	
	public String getSlot() {
		return slot;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public int getRating() {
		return rating;
	}
	
	public int getTier() {
		return tier;
	}
}