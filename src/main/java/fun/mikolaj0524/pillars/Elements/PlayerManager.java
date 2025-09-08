package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import fun.mikolaj0524.pillars.Objects.PlayerData;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static fun.mikolaj0524.pillars.Elements.Communication.messageToAll;
import static fun.mikolaj0524.pillars.Elements.Game.isEnd;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.teleportToSpawn;

public class PlayerManager {

	public static List<Player> inGamePlayers = new ArrayList<>();
	public static HashMap<Player, PlayerData> playerData = new HashMap<>();

	public static void preparePlayer(Player player, Place place){
		player.setHealth(20.0f);
		player.setFoodLevel(20);
		player.setLevel(0);
		player.setExp(0);
		player.setTotalExperience(0);
		player.setSaturation(20);
		player.getInventory().clear();
		if(place == Place.LOBBY){
			player.setInvulnerable(true);
			player.setGameMode(GameMode.ADVENTURE);
		}
		else{
			player.setGameMode(GameMode.SURVIVAL);
			player.setInvulnerable(false);
		}
	}

	public static void playerDeath(Player player1, Player player2){

		teleportToSpawn(player1);
		if(player2 == null){
			messageToAll(player1.getDisplayName() + " died!");
		}
		else{
			playerData.get(player2).addKill();
			messageToAll(player2.getDisplayName() + " has killed " + player1.getDisplayName());
		}
		isEnd();
	}

}
