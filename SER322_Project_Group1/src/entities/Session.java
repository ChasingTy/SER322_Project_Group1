package entities;

public class Session {
	private String gameID;
	private String server;
	private String gameType;
	private int circlePos;
	private int numPlayers;
	private int time;
	
	public Session(String id, String s, String g, int c, int n, int t) {
		this.gameID = id;
		this.server = s;
		this.gameType = g;
		this.circlePos = c;
		this.numPlayers = n;
		this.time = t;
	}
	
	public void setValues(String id, String s, String g, int c, int n, int t) {
		this.gameID = id;
		this.server = s;
		this.gameType = g;
		this.circlePos = c;
		this.numPlayers = n;
		this.time = t;
	}

	public String getGameID() {
		return gameID;
	}
	
	public String getServer() {
		return server;
	}
	
	public String getGameType() {
		return gameType;
	}
	
	public int getCirclePos() {
		return circlePos;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	public int getTime() {
		return time;
	}
}