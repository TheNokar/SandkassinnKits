package net.Plommer.SandkassinnKits.Commands;

import net.Plommer.SandkassinnKits.Kits;
import net.Plommer.SandkassinnKits.Utils.*;

public class KitsCommand extends BaseCommand {
	
	public KitsCommand() {
		bePlayer = true;
		name = " ";
		argLength = 0;
		usage = "<kit nafn>";
	}	
	@Override
	public boolean execute() {
		if(plugin.kitsList.containsKey(args.get(0).toLowerCase())) {
			Kits kits = plugin.kitsList.get(args.get(0).toLowerCase());
			new AddKitToInv(kits.getItems(), player);
			Utils.sendMessage(sender, plugin.config.getString("msg.kitsuccsess").replace("{kit}", kits.getName()));
		} else {
			Utils.sendMessage(sender, plugin.config.getString("msg.kiterror"));
		}
		return false;
	}
}
