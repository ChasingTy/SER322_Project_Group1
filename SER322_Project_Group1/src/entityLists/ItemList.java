package entityLists;

import entities.Item;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class ItemList {
	private final String filename = "item.json";
	private LinkedList<Item> list = new LinkedList<>();
	
	public ItemList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Item item = new Item();
                    item.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(item);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Item> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
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