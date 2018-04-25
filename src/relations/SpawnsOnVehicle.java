package relations;
import entities.Vehicle;
import entities.Map;

public class SpawnsOnVehicle {
	private Vehicle vehicle;
	private Map map;
	
	SpawnsOnVehicle() {
	}
	
	SpawnsOnVehicle(Vehicle v, Map m) {
		this.vehicle = v;
		this.map = m;
	}
	
	public void setValues(Vehicle v, Map m) {
		this.vehicle = v;
		this.map = m;
	}
	
	public Vehicle getItem() {
		return vehicle;
	}
	
	public Map getMap() {
		return map;
	}
}