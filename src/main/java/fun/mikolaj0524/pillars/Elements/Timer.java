package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import static fun.mikolaj0524.pillars.Elements.Communication.soundToInGamePlayers;
import static fun.mikolaj0524.pillars.Elements.Communication.titleToAll;
import static fun.mikolaj0524.pillars.Elements.Game.*;
import static fun.mikolaj0524.pillars.Elements.RandomItem.giveItems;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.teleportPlayers;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class Timer {

	public static Integer time = 0;
	public static Integer itemTimespan = getPluginInstance().getConfig().getInt("timeBetweenDrop"); // In seconds

	public static void loop(){
		new BukkitRunnable(){
			@Override
			public void run(){
				if(gameState){
					time++;
					task();
				}
				else{
					time = 0;
				}
			}
		}.runTaskTimer(getPluginInstance(), 0L, 20L);
	}

	public static void itemsLoop(){
		new BukkitRunnable(){
			@Override
			public void run(){
				if(dropItems){
					giveItems();
				}
			}
		}.runTaskTimer(getPluginInstance(), 20L, 20L * itemTimespan);
	}

	public static void task(){

		switch(time){
			case 1: titleToAll("&410"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK);  break;
			case 2: titleToAll("&c9"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 3: titleToAll("&68"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 4: titleToAll("&a7"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 5: titleToAll("&96"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 6:
				teleportPlayers(Place.AREA);
				titleToAll("&35");
				soundToInGamePlayers(Sound.UI_BUTTON_CLICK);
			break;
			case 7: titleToAll("&b4"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 8: titleToAll("&23"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 9: titleToAll("&a2"); soundToInGamePlayers(Sound.UI_BUTTON_CLICK); break;
			case 10:
				freePlayers = true;
				titleToAll("&aSTART!");
				soundToInGamePlayers(Sound.BLOCK_ENCHANTMENT_TABLE_USE);
			break;
			case 15:
				dropItems = true;
				break;
		}

	}

}
