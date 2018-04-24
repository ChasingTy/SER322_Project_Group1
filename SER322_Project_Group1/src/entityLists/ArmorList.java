package entityLists;

import entities.Armor;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class ArmorList {
	private final String filename = "armor.json";
	private LinkedList<Armor> list = new LinkedList<>();
	
	public ArmorList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Armor armor = new Armor();
                    armor.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(armor);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Armor> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("slot", list.get(i).getSlot());
            oneJson.put("durability", list.get(i).getDurability());
            oneJson.put("rating", list.get(i).getRating());
            oneJson.put("tier", list.get(i).getTier());
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