package relations;
import org.json.*;
import entities.Session;
import entities.Player;

public class PlaysIn {
	private Player player;
	private Session session;
	
	PlaysIn() {
	}
	
	PlaysIn(Player p, Session s) {
		this.player = p;
		this.session = s;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("player", this.player.toJSON());
		json.put("session", this.session.toJSON());
		return json;
	}
	
	public void fromJson(JSONObject json) {
		try {
			JSONObject playerJ = (JSONObject)json.getJSONObject("player");
			this.player.fromJson(playerJ);
			JSONObject sessionJ = (JSONObject)json.getJSONObject("session");
			this.session.fromJson(sessionJ);
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(Player p, Session s) {
		this.player = p;
		this.session = s;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Session getSession() {
		return session;
	}
}