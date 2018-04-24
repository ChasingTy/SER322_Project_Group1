package entityLists;

import entities.Backpack;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class BackpackList {
	private final String filename = "backpack.json";
	private LinkedList<Backpack> list = new LinkedList<>();
	
	public BackpackList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Backpack backpack = new Backpack();
                    backpack.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(backpack);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Backpack> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("capacity", list.get(i).getCapacity());
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