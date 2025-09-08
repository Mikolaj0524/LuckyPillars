package fun.mikolaj0524.pillars.Events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static fun.mikolaj0524.pillars.Elements.Game.freePlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerDeath;

public class PlayerMove implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		Location loc = event.getTo();

		if(loc.getBlockY() <= 50){
			playerDeath(player, null);
		}
		else if (!freePlayers && loc.getBlockY() <= 120 && loc.getBlockY() >= 60 && player.getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}

}
