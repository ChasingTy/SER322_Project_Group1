package relations;
import entities.Item;
import entities.Player;

public class Has {
	private Item item;
	private Player player;
	
	Has() {
	}
	
	Has(Item i, Player p) {
		this.item = i;
		this.player = p;
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