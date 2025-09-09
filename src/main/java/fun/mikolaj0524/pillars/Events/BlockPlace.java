package fun.mikolaj0524.pillars.Events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player player = event.getPlayer();
		Location loc = event.getBlock().getLocation();

		if(loc.getBlockY() >= 120 && player.getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}

	}

}
