package relations;
import org.json.*;
import entities.Vehicle;
import entities.Map;

public class SpawnsOnVehicle {
	private Vehicle vehicle;
	private Map map;
	
	public SpawnsOnVehicle() {
	}
	
	public SpawnsOnVehicle(Vehicle v, Map m) {
		this.vehicle = v;
		this.map = m;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("vehicle", this.vehicle.toJSON());
		json.put("map", this.map.toJSON());
		return json;
	}
	
	public void fromJson(JSONObject json) {
		try {
			JSONObject vehicleJ = (JSONObject)json.getJSONObject("vehicle");
			this.vehicle.fromJson(vehicleJ);
			JSONObject mapJ = (JSONObject)json.getJSONObject("map");
			this.map.fromJson(mapJ);
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(Vehicle v, Map m) {
		this.vehicle = v;
		this.map = m;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public Map getMap() {
		return map;
	}
}