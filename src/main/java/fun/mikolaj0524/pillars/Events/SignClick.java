package fun.mikolaj0524.pillars.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static fun.mikolaj0524.pillars.Elements.SignManager.signClick;
import static fun.mikolaj0524.pillars.Elements.SignManager.signLoc;

public class SignClick implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent event){
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(block.getType().equals(Material.PALE_OAK_WALL_SIGN) && block.getLocation().getBlockY() == signLoc.getBlockY() && block.getLocation().getBlockX() == signLoc.getBlockX() && block.getLocation().getBlockY() == signLoc.getBlockY()){
				event.setCancelled(true);
				signClick(player);
			}
		}
	}
}
