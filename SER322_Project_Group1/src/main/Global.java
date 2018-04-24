package main;

import java.util.LinkedList;

import entityLists.*;

public class Global {
	public static AmmoList ammoList = new AmmoList("ammo.json");
	public static ArmorList armorList = new ArmorList("armor.json");
	public static BackpackList backpackList = new BackPackList("backpack.json");
	public static BoosterList boosterList = new BoosterList("booster.json");
	public static ClothingList clothingList = new ClothingList("clothing.json");
	public static HealingItemList healingItemList = new HealingItemList("healingItem.json");
	public static ItemList itemList = new ItemList("item.json");
	public static MapList mapList = new MapList("map.json");
	public static PlayerList playerList = new PlayerList("playerList.json");
	public static SessionList sessionList = new SessionList("session.json");
	public static StandardList standardList = new StandardList("standard.json");
	public static ThowAbleList throwAbleList = new ThrowAbleList("throwAble.json");
	public static VehicleList vehicleList = new VehicleList("vehicle.json");
	public static WeaponList weaponList = new WeaponList("weapon.json");
	
}