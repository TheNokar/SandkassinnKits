package net.Plommer.SandkassinnKits.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import net.Plommer.SandkassinnKits.SandkassinnKits;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Books {
	
	protected static SandkassinnKits plugin;
	
	public Books(SandkassinnKits plugin) {
		Books.plugin = plugin;
	}
	
	public static ItemStack BookReader(String name) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta bm = (BookMeta)book.getItemMeta();
		try {
			Scanner s = new Scanner(new FileReader(plugin.getDataFolder().getAbsolutePath() + "/"+ name +".txt"));
		    HashMap<Integer, String> lines = new HashMap<Integer, String>();
		    StringBuilder builder = new StringBuilder();
		    int page = 0;
			String line = null;
			while(s.hasNextLine()) {
				line = s.nextLine();
				//Checking if everything exist!
				if(line.contains(":") && !line.startsWith("#")) {
					String[] a = line.split(":");
					switch(a[0]) {
						case "name": case "title": 
							bm.setDisplayName(Utils.buildString(a[1]));
							break;
						case "author":
							bm.setAuthor(Utils.buildString(a[1]));
							break;
						case "page":
							if(page != 0) {
								lines.put(page, builder.toString());
								builder.delete(0, builder.length());
							}
							page++;
							break;
						default:
							bm.setTitle(name);
							break;
					}
				}
				if(page != 0 && !line.contains("page:") && !line.startsWith("#") && !line.isEmpty()) {
					builder.append(line + "&0&r \n");
				}
			}
			s.close();
			int pages = 1;
			while(pages != page) {
				String string = lines.get(pages);
				bm.addPage(Utils.buildString(string));
				pages++;
			}
			book.setItemMeta(bm);
		} catch(IOException e) {
			e.printStackTrace();
			plugin.getLogger().info("SandkassinnKits - cannot read the book file!");
		}
		//if(bm.hasPages()) {
			return book;
		//}
		//return null;
	}
	
}
