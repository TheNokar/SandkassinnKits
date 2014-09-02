package net.Plommer.SandkassinnKits.Utils;

import java.util.List;

import org.bukkit.entity.Player; 
import org.bukkit.inventory.ItemStack;

public class AddKitToInv {

	public AddKitToInv(List<ItemStack> i, Player player) {
		for(ItemStack item : i) {
			player.getInventory().addItem(item);
		}
	}
	
}
