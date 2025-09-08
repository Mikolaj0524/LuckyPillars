package fun.mikolaj0524.pillars.Elements;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Communication {

	public static String prefix = colorText("&8 [&bLP&8] &b» &7");
	public static void messageToAll(String text){
		for(Player player : Bukkit.getOnlinePlayers()){
			messageToPlayer(player, text);
		}
	}

	public static void messageToList(List<Player> players, String text){
		for(Player player : players){
			messageToPlayer(player, text);
		}
	}

	public static void messageToPlayer(Player player, String text){
		player.sendMessage(prepareText(text));
	}

	public static void titleToAll(String text){
		for(Player player : Bukkit.getOnlinePlayers()){
			titleToPlayer(player, text);
		}
	}

	public static void titleToPlayer(Player player, String text){
		player.sendTitle(colorText(text), "", 5, 10, 5);
	}

	public static String prepareText(String text){
		return " \n" + prefix + colorText(text) + " \n ";
	}

	public static String colorText(String text){
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}
