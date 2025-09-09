package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import fun.mikolaj0524.pillars.Objects.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Collection;

import static fun.mikolaj0524.pillars.Elements.Communication.messageToAll;
import static fun.mikolaj0524.pillars.Elements.Communication.messageToPlayer;
import static fun.mikolaj0524.pillars.Elements.MapManager.clearWorld;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerData;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.teleportPlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;

public class Game {
	public static Boolean gameState = false;
	public static Boolean freePlayers = false;
	public static Boolean dropItems = false;

	public static void startGame(){
		killEntities();
		clearWorld();
		inGamePlayers.addAll(Bukkit.getOnlinePlayers());
		gameState = true;
	}

	public static void isEnd(){
		if(inGamePlayers.size() == 1){
			Player lastPlayer = inGamePlayers.getFirst();
			messageToAll("&b&l" + lastPlayer.getDisplayName() + " won!");
			for(Player player : inGamePlayers){
				messageToPlayer(player, "Your kills: &7" + playerData.get(player).getKills());
			}
			restartGame();
		}
		else if (inGamePlayers.isEmpty()){
			restartGame();
		}
	}

	public static void restartGame(){
		gameState = false;
		freePlayers = false;
		dropItems = false;
		clearWorld();
		killEntities();
		inGamePlayers.clear();
		teleportPlayers(Place.LOBBY);

		for (Player player : inGamePlayers) {
			PlayerData data = playerData.get(player);
			if(data != null){
				data.setKills(0);
			}
		}
	}

	public static void killEntities(){
		World world = Bukkit.getWorld("world");
		Location loc = new Location(world, 0, 100, 0);
		Collection<Entity> entities = world.getNearbyEntities(loc, 25, 100, 25);
		for(Entity entity : entities){
			if(!(entity instanceof Player)){
				entity.remove();
			}
		}
	}
}
