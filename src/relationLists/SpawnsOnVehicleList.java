package relationLists;

import relations.SpawnsOnVehicle;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class SpawnsOnVehicleList {
	private final String filename = "spawnsOnVehicle.json";
	private LinkedList<SpawnsOnVehicle> list = new LinkedList<>();
	
	public SpawnsOnVehicleList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    SpawnsOnVehicle spawnsOnVehicle = new SpawnsOnVehicle();
                    spawnsOnVehicle.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(spawnsOnVehicle);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<SpawnsOnVehicle> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("vehicle", list.get(i).getVehicle().toJSON());
            oneJson.put("map", list.get(i).getMap().toJSON());
            groupJson.put(list.get(i).getVehicle().getName(), oneJson);
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