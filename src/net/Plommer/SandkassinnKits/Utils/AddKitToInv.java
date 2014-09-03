package net.Plommer.SandkassinnKits.Utils;

import java.util.List;

import net.Plommer.SandkassinnKits.Utils.isArmor.type;

import org.bukkit.entity.Player; 
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class AddKitToInv {

	public AddKitToInv(List<ItemStack> i, Player player) {
		for(ItemStack item : i) {
			type type = isArmor.Armor(item.getType());
			PlayerInventory pi = player.getInventory();
			if(pi.firstEmpty() != -1) {
				if(type != isArmor.type.NONE) {
					if(type == isArmor.type.HELMET) {
						if(pi.getHelmet() != null) {
							pi.addItem(item);
						}
						pi.setHelmet(item);
					} else if(type == isArmor.type.CHEST) {
						if(pi.getChestplate() != null) {
							pi.addItem(item);
						}
						pi.setChestplate(item);
					} else if(type == isArmor.type.LEGGINGS) {
						if(pi.getLeggings() != null) {
							pi.addItem(item);
						}
						pi.setLeggings(item);
					} else if(type == isArmor.type.BOOTS) {
						if(pi.getBoots() != null) {
							pi.addItem(item);
						}
						pi.setBoots(item);
					}
				} else {
					player.getInventory().addItem(item);
				}
			} else {
				player.getWorld().dropItemNaturally(player.getLocation(), item);
			}
		}
	}
	
}
