package net.Plommer.SandkassinnKits.Utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

/**
 * Common methods shared between modules
 *
 * @author Gussi
 */
public class Utils {
	protected static final Charset UTF8 = Charset.forName("UTF-8");

	public static void sendMessage(CommandSender sender, String message) {
		Utils.sendMessage(sender, message, new HashMap<String,String>());
	}

	public static void sendMessage(CommandSender sender, String message, HashMap<String, String> tokens) {
		sender.sendMessage(buildString(message, tokens));
	}

	public static void broadcastMessage(String message) {
		Utils.broadcastMessage(message, new HashMap<String, String>());
	}

	public static void broadcastMessage(String message, HashMap<String, String> tokens) {
		Bukkit.getServer().broadcastMessage(buildString(message, tokens));
	}
	
	public static String buildString(String message) {
		return buildString(message, new HashMap<String, String>());
	}

	public static String buildString(String message, HashMap<String, String> tokens) {
		Pattern pattern = Pattern.compile("\\{(.+?)\\}");
		Matcher matcher = pattern.matcher(message);
		StringBuilder builder = new StringBuilder();
		int i = 0;
		CharsetDecoder decoder = UTF8.newDecoder();
		while (matcher.find()) {
			String replacement = null;
			try {
				replacement = tokens.get(matcher.group(1));
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		    builder.append(message.substring(i, matcher.start()));
		    if (replacement == null)
		        builder.append(matcher.group(0));
		    else
		        builder.append(replacement);
		    i = matcher.end();
		}
		builder.append(message.substring(i, message.length()));
		ByteBuffer bb = ByteBuffer.wrap(builder.toString().getBytes());
		String a = null;
		try {
			CharBuffer test = decoder.decode(bb);
			a = test.toString();
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a.replaceAll("&", new Character((char) 167).toString());
	}
}