package net.Plommer.SandkassinnKits.Utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.Plommer.SandkassinnKits.Kits;
import net.Plommer.SandkassinnKits.SandkassinnKits;

public class LoadKits {

	@SuppressWarnings("deprecation")
	public LoadKits(SandkassinnKits plugin) {
		for(String id : plugin.config.getConfigurationSection("kits").getKeys(false)) {
			FileConfiguration config = plugin.config;
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			for(String item : config.getStringList("kits." +id + ".items")) {
				HashMap<Enchantment, Integer> effects = new HashMap<Enchantment, Integer>();
				String[] iteml = item.split(" ");
				if(iteml[0].equalsIgnoreCase("book")) {
					items.add(Books.BookReader(iteml[1]));
				} else {
					ItemStack iteme = new ItemStack(Material.getMaterial(Integer.parseInt(iteml[0])), Integer.parseInt(iteml[1]));
					ItemMeta meta = iteme.getItemMeta();
					for(String itemn : iteml) {
						if(itemn.contains(":")) {
							String[] name = itemn.split(":");
							if(name[0].equalsIgnoreCase("name")) {
								meta.setDisplayName(Utils.buildString(name[1].replace("_", " "), new HashMap<String, String>()));
							} else {
								Enchantment test = Enchantment.getByName(name[0].toUpperCase());
								effects.put(test, Integer.parseInt(name[1]));
							}
							iteme.setItemMeta(meta);
						}
					}
					if(effects.size() != 0) {
						iteme.addUnsafeEnchantments(effects);
						items.add(iteme);
					}
				}
				plugin.kitsList.put(id.toLowerCase(), new Kits(items, id));
			}
		}
	}
	
}
