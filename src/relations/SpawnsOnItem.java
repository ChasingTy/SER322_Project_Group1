package relations;
import org.json.*;
import entities.Item;
import entities.Map;

public class SpawnsOnItem {
	private Item item;
	private Map map;
	
	public SpawnsOnItem() {
	}
	
	public SpawnsOnItem(Item i, Map m) {
		this.item = i;
		this.map = m;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("item", this.item.toJSON());
		json.put("map", this.map.toJSON());
		return json;
	}
	
	public void fromJson(JSONObject json) {
		try {
			JSONObject itemJ = (JSONObject)json.getJSONObject("item");
			this.item.fromJson(itemJ);
			JSONObject mapJ = (JSONObject)json.getJSONObject("map");
			this.map.fromJson(mapJ);
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public void setValues(Item i, Map m) {
		this.item = i;
		this.map = m;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Map getMap() {
		return map;
	}
}