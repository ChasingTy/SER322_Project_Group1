package entityLists;

import entities.Standard;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class StandardList {
	private final String filename = "standard.json";
	private LinkedList<Standard> list = new LinkedList<>();
	
	public StandardList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Standard standard = new Standard();
                    standard.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(standard);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Standard> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("tier", list.get(i).getTier());
            oneJson.put("quantity", list.get(i).getQuantity());
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