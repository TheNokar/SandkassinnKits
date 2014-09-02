package net.Plommer.SandkassinnKits.Listenners;

import net.Plommer.SandkassinnKits.Kits;
import net.Plommer.SandkassinnKits.SandkassinnKits;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinEvent implements Listener {
	protected SandkassinnKits plugin;
	public JoinEvent(SandkassinnKits kits) {
		this.plugin = kits;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if(!event.getPlayer().hasPlayedBefore()) {
			String kit = plugin.config.getString("kits.starter");
			if(plugin.kitsList.containsKey(kit)) {
				Kits kits = plugin.kitsList.get(kit);
				for(ItemStack item : kits.getItems()) {
					event.getPlayer().getInventory().addItem(item);
				}
			}
		}
	}
	 
}
