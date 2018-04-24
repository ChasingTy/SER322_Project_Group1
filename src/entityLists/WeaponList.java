package entityLists;

import entities.Weapon;
import java.util.LinkedList;
import java.io.*;
import org.json.*;

public class WeaponList {
	private final String filename = "weapon.json";
	private LinkedList<Weapon> list = new LinkedList<>();
	
	public WeaponList() {
		try {
            FileInputStream in = new FileInputStream(filename);
            JSONObject obj = new JSONObject(new JSONTokener(in));
            String [] names = JSONObject.getNames(obj);
            for (int i = 0; i < names.length; ++i) {
                if (!names[i].equals("")) {
                    Weapon weapon = new Weapon();
                    weapon.fromJson((JSONObject)obj.getJSONObject(names[i]));
                    list.add(weapon);
                }
            }
            in.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public LinkedList<Weapon> getList() {
		return list;
	}
	
	public void exportJSON() {
		JSONObject groupJson = new JSONObject();
        for (int i = 0; i < list.size(); ++i) {
            JSONObject oneJson = new JSONObject();
            oneJson.put("name", list.get(i).getName());
            oneJson.put("type", list.get(i).getType());
            oneJson.put("bulletSpeed", list.get(i).getBulletSpeed());
            oneJson.put("fireRate", list.get(i).getFireRate());
            oneJson.put("damage", list.get(i).getDamage());
            oneJson.put("currentMagCapacity", list.get(i).getCurrentMagCapacity());
            oneJson.put("maxMagCapacity", list.get(i).getMaxMagCapacity());
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