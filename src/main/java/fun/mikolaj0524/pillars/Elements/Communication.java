package fun.mikolaj0524.pillars.Elements;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class Communication {

	public static String prefix = colorText(getPluginInstance().getConfig().getString("prefix"));
	public static void messageToAll(String text){
		for(Player player : Bukkit.getOnlinePlayers()){
			messageToPlayer(player, text);
		}
	}

	public static void messageToInGamePlayers(String text){
		for(Player player : inGamePlayers){
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

	public static void soundToInGamePlayers(Sound sound){
		for(Player player : inGamePlayers){
			soundToPlayer(player, sound);
		}
	}

	public static void soundToPlayer(Player player, Sound sound){
		player.playSound(player, sound, 0.5f, 0.5f);
	}

	public static String prepareText(String text){
		return " \n" + prefix + colorText(text) + " \n ";
	}

	public static String colorText(String text){
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}
