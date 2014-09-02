package net.Plommer.SandkassinnKits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class Kits {

	private List<ItemStack> items = new ArrayList<ItemStack>();
	private String name;
	
	public Kits(List<ItemStack> item, String name) {
		setItems(item);
		setName(name);
	}
	
	public void setItems(List<ItemStack> items) {
		this.items = items;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ItemStack> getItems() {
		return this.items;
	}
	
	public String getName() {
		return this.name;
	}
	
}
