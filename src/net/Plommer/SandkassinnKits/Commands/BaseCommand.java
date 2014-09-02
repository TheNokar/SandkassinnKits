package net.Plommer.SandkassinnKits.Commands;

import java.util.ArrayList;
import java.util.List;

import net.Plommer.SandkassinnKits.SandkassinnKits;
import net.Plommer.SandkassinnKits.Utils.Utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BaseCommand {
	public SandkassinnKits plugin;
	public CommandSender sender;
	public String cmd;
	public String name;
	
	public List<String> args = new ArrayList<String>();
	public String[] pargs;
	public Player player;
	public int argLength = 0;
	public String usage;
	public boolean bePlayer = true;
	public String usedCmd;
	public String permission;
	
	public boolean run(SandkassinnKits k, CommandSender sender, String cmd, String[] preArgs) {
		
		this.plugin = k;
		this.sender = sender;
		this.usedCmd = cmd;
		this.permission = preArgs[0];
		
		args.clear();
		for(String arg : preArgs) {
			args.add(arg);
		}
		
        for (int i = 0; i < name.split(" ").length && i < args.size(); i++) {
            args.remove(0);	
        }
		
		if(argLength > args.size()) {
			sendUsage();
			return false;
		}
		
		if(!sender.hasPermission(this.permission())) {
			Utils.sendMessage(sender, "&cYou don't have permission to do that!");
			return false;
		}
		
		if(!(sender instanceof Player) && bePlayer) {
			return false;
		}
		if(sender instanceof Player) {
			this.player = (Player)sender;
		}
		
		return execute();		
	}
	
	public abstract boolean execute();
	
	public void sendUsage() {
		Utils.sendMessage(sender, "&c/" + this.usedCmd + " " +this.usage);
	}
	
	public String permission() {
		return "sandkassinnkits." + this.permission;
	}
	
}
