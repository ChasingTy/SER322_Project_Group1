package entities;

public class Map {
	private String name;
	private int size;
	
	public Map(String n, int s) {
		this.name = n;
		this.size = s;
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