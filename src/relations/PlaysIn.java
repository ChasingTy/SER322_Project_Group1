package relations;
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