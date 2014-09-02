package net.Plommer.SandkassinnKits.Commands;

import java.util.ArrayList;

import net.Plommer.SandkassinnKits.Utils.Utils;

public class ListCommand extends BaseCommand {

	public ListCommand() {
		bePlayer = true;
		name = "list";
		argLength = 0;
		usage = "list sjá lista af leyfğum kittum";
	}	
	@Override
	public boolean execute() {
		ArrayList<String> kit = new ArrayList<String>();
		for(String kits : plugin.kitsList.keySet()) {
			if(player.hasPermission("sandkassinnkits."+kits)) {
				kit.add(kits);
			}
		}
		StringBuilder list = new StringBuilder();
		list.append("&aKits: &e");
		for(String kits : kit) {
			list.append(kits + ", ");
		}
        list.setLength(list.length() - 2);
		if(list != null) {
			Utils.sendMessage(sender, list.toString());
		}
		return false;
	}
	
}
