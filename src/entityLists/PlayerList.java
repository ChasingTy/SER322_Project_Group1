package entityLists;

import entities.Player;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class PlayerList {
	private final String filename = "player.json";
	private LinkedList<Player> list = new LinkedList<>();
	
	public PlayerList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Player player = new Player();
                    player.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(player);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Player> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("gender", list.get(i).getGender());
            oneJson.put("health", list.get(i).getHealth());
            oneJson.put("energy", list.get(i).getEnergy());
            groupJson.put(list.get(i).getName(), oneJson);
        }
        
        PrintWriter out;
        try {
            out = new PrintWriter(filename);
            out.println(groupJson.toString(1));
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}