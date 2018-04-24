package entityLists;

import entities.Booster;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class BoosterList {
	private final String filename = "booster.json";
	private LinkedList<Booster> list = new LinkedList<>();
	
	public BoosterList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Booster booster = new Booster();
                    booster.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(booster);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Booster> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("health", list.get(i).getHealth());
            oneJson.put("energy", list.get(i).getEnergy());
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