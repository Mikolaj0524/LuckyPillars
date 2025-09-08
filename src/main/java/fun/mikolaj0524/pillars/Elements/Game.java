package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static fun.mikolaj0524.pillars.Elements.Communication.messageToAll;
import static fun.mikolaj0524.pillars.Elements.Communication.messageToPlayer;
import static fun.mikolaj0524.pillars.Elements.MapManager.clearWorld;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerData;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.teleportPlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.teleportToSpawn;

public class Game {
	public static Boolean gameState = false;
	public static Boolean freePlayers = false;
	public static Boolean dropItems = false;

	public static void startGame(){
		clearWorld();
		inGamePlayers.addAll(Bukkit.getOnlinePlayers());
		gameState = true;

	}

	public static void isEnd(){
		if(inGamePlayers.size() == 1){
			teleportToSpawn(inGamePlayers.getFirst());
			messageToAll(inGamePlayers.getFirst().getDisplayName() + " won!");
			for(Player player : inGamePlayers){
				messageToPlayer(player, " &b&lYour kills: &f" + playerData.get(player).getKills());
			}
		}
		else{
			teleportPlayers(Place.LOBBY);
		}
	}


}
