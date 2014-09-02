package net.Plommer.SandkassinnKits;

import java.util.ArrayList;
import java.util.HashMap;

import net.Plommer.SandkassinnKits.Commands.BaseCommand;
import net.Plommer.SandkassinnKits.Commands.CommandHandler;
import net.Plommer.SandkassinnKits.Commands.KitsCommand;
import net.Plommer.SandkassinnKits.Commands.ListCommand;
import net.Plommer.SandkassinnKits.Configs.GenerateConfigs;
import net.Plommer.SandkassinnKits.Listenners.JoinEvent;
import net.Plommer.SandkassinnKits.Utils.Books;
import net.Plommer.SandkassinnKits.Utils.LoadKits;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SandkassinnKits extends JavaPlugin {
	
	public ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
	public GenerateConfigs gc = new GenerateConfigs(this);
	public FileConfiguration config;
    public HashMap<String, Kits> kitsList = new HashMap<String, Kits>();
    
	public void onEnable() {
		//Some stuff
		getCommand("kits").setExecutor(new CommandHandler(this));
		new Books(this);
		registerCommands();
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		//Custom configs
		config = gc.getCustomConfig();
		//Load kits to class
		new LoadKits(this);
	}
	
	public void onDisable() {
		//
	}
	
	private void registerCommands() {
		commands.add(new ListCommand());
		commands.add(new KitsCommand());
	}
	
}
