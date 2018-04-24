package entityLists;

import entities.Session;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class SessionList {
	private final String filename = "session.json";
	private LinkedList<Session> list = new LinkedList<>();
	
	public SessionList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Session session = new Session();
                    session.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(session);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Session> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("gameID", list.get(i).getGameID());
            oneJson.put("server", list.get(i).getServer());
            oneJson.put("gameType", list.get(i).getGameType());
            oneJson.put("circlePos", list.get(i).getCirclePos());
            oneJson.put("numPlayers", list.get(i).getNumPlayers());
            oneJson.put("time", list.get(i).getTime());
            groupJson.put(list.get(i).getGameID(), oneJson);
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