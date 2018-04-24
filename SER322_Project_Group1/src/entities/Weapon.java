package entities;

public class Weapon extends Item {
	private String type;
	private double bulletSpeed;
	private int fireRate;
	private int damage;
	private int currentMagCapacity;
	private int maxMagCapacity;
	
	public Weapon(String n, String t, double b, int f, int d, int c, int m) {
		super(n);
		this.type = t;
		this.bulletSpeed = b;
		this.fireRate = f;
		this.damage = d;
		this.currentMagCapacity = c;
		this.maxMagCapacity = m;
	}
	
	public void setValues(String n, String t, double b, int f, int d, int c, int m) {
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
	
	public double getBulletSpeed() {
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