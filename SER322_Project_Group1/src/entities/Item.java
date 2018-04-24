package entities;

public class Item {
	private String name;
	
	public Item(String n) {
		this.name= n;
	}
	
	public void setValues(String n) {
		this.name= n;
	}
	
	public String getName() {
		return name;
	}
}