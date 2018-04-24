package entityLists;

import entities.HealingItem;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class HealingItemList {
	private final String filename = "healingItem.json";
	private LinkedList<HealingItem> list = new LinkedList<>();
	
	public HealingItemList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    HealingItem healingItem = new HealingItem();
                    healingItem.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(healingItem);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<HealingItem> getList() {
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