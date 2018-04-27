package relations;
import org.json.*;
import entities.Item;
import entities.Player;

public class Has {
	private Item item = new Item();
	private Player player = new Player();
	
	public Has() {
	}
	
	public Has(Item i, Player p) {
		this.item = i;
		this.player = p;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("item", this.item.toJSON());
		json.put("player", this.player.toJSON());
		return json;
	}
	
	public void fromJson(JSONObject json) {
		try {
			JSONObject itemJ = (JSONObject)json.getJSONObject("item");
			this.item.fromJson(itemJ);
			JSONObject playerJ = (JSONObject)json.getJSONObject("player");
			this.player.fromJson(playerJ);
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(Item i, Player p) {
		this.item = i;
		this.player = p;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Player getPlayer() {
		return player;
	}
}