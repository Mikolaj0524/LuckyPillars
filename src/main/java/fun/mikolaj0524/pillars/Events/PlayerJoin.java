package fun.mikolaj0524.pillars.Events;

import fun.mikolaj0524.pillars.Objects.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static fun.mikolaj0524.pillars.Elements.Communication.prepareText;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerData;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.teleportToSpawn;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		event.setJoinMessage(prepareText(player.getDisplayName() + " has joined!"));
		teleportToSpawn(player);
		playerData.put(player, new PlayerData(0));
	}

}
