package fun.mikolaj0524.pillars.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerDeath;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class PlayerDeath implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		Player player = event.getEntity();

		Bukkit.getScheduler().runTask(getPluginInstance(), () -> {
			if (!player.isOnline())
				return;

			player.spigot().respawn();
			playerDeath(player, null);
		});

	}

}
