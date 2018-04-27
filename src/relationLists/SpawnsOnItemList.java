package relationLists;

import relations.SpawnsOnItem;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class SpawnsOnItemList {
	private final String filename = "spawnsOnItem.json";
	private LinkedList<SpawnsOnItem> list = new LinkedList<>();
	
	public SpawnsOnItemList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    SpawnsOnItem spawnsOnItem = new SpawnsOnItem();
                    spawnsOnItem.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(spawnsOnItem);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<SpawnsOnItem> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("item", list.get(i).getItem().toJSON());
            oneJson.put("map", list.get(i).getMap().toJSON());
            groupJson.put("SpawnsOnItem " + i, oneJson);
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