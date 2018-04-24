package entityLists;

import entities.Vehicle;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class VehicleList {
	private final String filename = "vehicle.json";
	private LinkedList<Vehicle> list = new LinkedList<>();
	
	public VehicleList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(vehicle);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Vehicle> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("health", list.get(i).getHealth());
            oneJson.put("numSeats", list.get(i).getNumSeats());
            oneJson.put("topSpeed", list.get(i).getTopSpeed());
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