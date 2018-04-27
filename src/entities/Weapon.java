package entities;
import org.json.*;

public class Weapon extends Item {
	private String type;
	private int bulletSpeed;
	private int fireRate;
	private int damage;
	private int currentMagCapacity;
	private int maxMagCapacity;
	
	public Weapon() {
	}
	
	public Weapon(String n, String t, int b, int f, int d, int c, int m) {
		super(n);
		this.type = t;
		this.bulletSpeed = b;
		this.fireRate = f;
		this.damage = d;
		this.currentMagCapacity = c;
		this.maxMagCapacity = m;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("name", this.getName());
		json.put("type", this.type);
		json.put("bulletSpeed", this.bulletSpeed);
		json.put("fireRate", this.fireRate);
		json.put("damage", this.damage);
		json.put("currentMagCapacity", this.currentMagCapacity);
		json.put("maxMagCapacity", this.maxMagCapacity);
		return json;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	this.setValues(json.getString("name"), json.getString("type"), json.getInt("bulletSpeed"), json.getInt("fireRate"), json.getInt("damage"), json.getInt("currentMagCapacity"), json.getInt("maxMagCapacity"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(String n, String t, int b, int f, int d, int c, int m) {
		this.setValues(n);
		this.type = t;
		this.bulletSpeed = b;
		this.fireRate = f;
		this.damage = d;
		this.currentMagCapacity = c;
		this.maxMagCapacity = m;
	}
	
	public String getType() {
		return type;
	}
	
	public int getBulletSpeed() {
		return bulletSpeed;
	}
	
	public int getFireRate() {
		return fireRate;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getCurrentMagCapacity() {
		return currentMagCapacity;
	}
	
	public int getMaxMagCapacity() {
		return maxMagCapacity;
	}
}