package entityLists;

import entities.Clothing;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class ClothingList {
	private final String filename = "clothing.json";
	private LinkedList<Clothing> list = new LinkedList<>();
	
	public ClothingList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Clothing clothing = new Clothing();
                    clothing.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(clothing);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Clothing> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("slot", list.get(i).getSlot());
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