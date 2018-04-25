package relations;
import entities.Item;
import entities.Map;

public class SpawnsOnItem {
	private Item item;
	private Map map;
	
	SpawnsOnItem() {
	}
	
	SpawnsOnItem(Item i, Map m) {
		this.item = i;
		this.map = m;
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