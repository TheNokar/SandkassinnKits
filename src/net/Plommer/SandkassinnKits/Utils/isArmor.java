package net.Plommer.SandkassinnKits.Utils;

import org.bukkit.Material;

public class isArmor {

	public static enum type {
		HELMET,
		CHEST,
		LEGGINGS,
		BOOTS,
		NONE;
	}
	
	static int[] HELMET = {298, 302, 306, 310};
	static int[] CHEST = {303, 307, 311, 315};
	static int[] LEGGINGS = {304, 308, 312, 316};
	static int[] BOOTS = {301, 305, 309, 313, 317};
	
	@SuppressWarnings("deprecation")
	public static type Armor(Material mat) {
		int id = mat.getId();
		if(contains(HELMET, id)) {
			return type.HELMET;
		}
		if(contains(CHEST, id)) {
			return type.CHEST;
		}
		if(contains(LEGGINGS, id)) {
			return type.LEGGINGS;
		}
		if(contains(BOOTS, id)) {
			System.out.append("HAH");
			return type.BOOTS;
		}
		return type.NONE;
	}
	
	public static boolean contains(int[] array, int id) {
		for(int i : array) {
			return i == id;
		}
		return false;
	}
	
}
