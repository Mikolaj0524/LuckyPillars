package fun.mikolaj0524.pillars.Events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static fun.mikolaj0524.pillars.Elements.RandomItem.blockedItems;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		Location loc = event.getBlock().getLocation();

		if(( blockedItems.contains(event.getBlock().getType()) || loc.getBlockY() >= 120 ) && player.getGameMode() != GameMode.CREATIVE){
			event.setCancelled(true);
		}
	}

}
