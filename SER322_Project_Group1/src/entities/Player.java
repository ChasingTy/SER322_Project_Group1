package entities;

public class Player {
	private String name;
	private String gender;
	private int health;
	private int energy;
	
	public Player(String n, String g, int h, int e) {
		this.name = n;
		this.gender = g;
		this.health = h;
		this.energy = e;
	}
	
	public void setValues(String n, String g, int h, int e) {
		this.name = n;
		this.gender = g;
		this.health = h;
		this.energy = e;
	}

	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getHealth() {
		return health;
	}
	public int getEnergy() {
		return energy;
	}
}