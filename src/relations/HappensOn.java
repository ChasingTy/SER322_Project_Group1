package relations;
import org.json.*;
import entities.Session;
import entities.Map;

public class HappensOn {
	private Map map;
	private Session session;
	
	public HappensOn() {
	}
	
	public HappensOn(Map m, Session s) {
		this.map = m;
		this.session = s;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("map", this.map.toJSON());
		json.put("session", this.session.toJSON());
		return json;
	}
	
	public void fromJson(JSONObject json) {
		try {
			JSONObject mapJ = (JSONObject)json.getJSONObject("map");
			this.map.fromJson(mapJ);
			JSONObject sessionJ = (JSONObject)json.getJSONObject("session");
			this.session.fromJson(sessionJ);
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(Map m, Session s) {
		this.map = m;
		this.session = s;
	}
	
	public Map getMap() {
		return map;
	}
	
	public Session getSession() {
		return session;
	}
}