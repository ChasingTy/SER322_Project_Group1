package relationLists;

import relations.PlaysIn;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class PlaysInList {
	private final String filename = "playsIn.json";
	private LinkedList<PlaysIn> list = new LinkedList<>();
	
	public PlaysInList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    PlaysIn playsIn = new PlaysIn();
                    playsIn.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(playsIn);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<PlaysIn> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("player", list.get(i).getPlayer().toJSON());
            oneJson.put("session", list.get(i).getSession().toJSON());
            groupJson.put(list.get(i).getPlayer().getName(), oneJson);
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