package relationLists;

import relations.HappensOn;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class HappensOnList {
	private final String filename = "happensOn.json";
	private LinkedList<HappensOn> list = new LinkedList<>();
	
	public HappensOnList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    HappensOn happensOn = new HappensOn();
                    happensOn.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(happensOn);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<HappensOn> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("map", list.get(i).getMap().toJSON());
            oneJson.put("session", list.get(i).getSession().toJSON());
            groupJson.put("HappensOn " + i, oneJson);
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