package relations;
import entities.Session;
import org.json.*;

import entities.Map;

public class HappensOn {
	private Map map;
	private Session session;
	
	HappensOn() {
	}
	
	HappensOn(Map m, Session s) {
		this.map = m;
		this.session = s;
	}
	
	public void fromJson(JSONObject json) {
	    try {
	    	//this.setValues(json.getJSONObject("map"), json.getJSONObject("session"));
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(Map m, Session s) {
		this.map = m;
		this.session = s;
	}
	
	public Map getPlayer() {
		return map;
	}
	
	public Session getSession() {
		return session;
	}
}