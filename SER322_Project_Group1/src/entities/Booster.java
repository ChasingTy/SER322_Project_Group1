package entities;

public class Booster extends HealingItem {
	private int health;
	private int energy;
	
	public Booster(String n, int h, int e) {
		super(n);
		this.health = h;
		this.energy = e;
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