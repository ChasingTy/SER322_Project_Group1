package relationLists;

import relations.Has;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class HasList {
	private final String filename = "has.json";
	private LinkedList<Has> list = new LinkedList<>();
	
	public HasList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Has has = new Has();
                    has.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(has);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Has> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("item", list.get(i).getItem().toJSON());
            oneJson.put("player", list.get(i).getPlayer().toJSON());
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