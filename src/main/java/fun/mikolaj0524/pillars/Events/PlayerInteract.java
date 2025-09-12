package fun.mikolaj0524.pillars.Events;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();

		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			ItemStack itemStack = player.getInventory().getItemInMainHand();

			if(itemStack.getType().equals(Material.FIRE_CHARGE)){
				Fireball fireball = player.launchProjectile(Fireball.class);
				fireball.setIsIncendiary(true);
				fireball.setYield(1.0f);
				fireball.setVelocity(player.getLocation().getDirection().multiply(2));
				fireball.setShooter(player);
				if (player.getInventory().contains(Material.FIRE_CHARGE)) {
					player.getInventory().removeItem(new ItemStack(Material.FIRE_CHARGE, 1));
				}
			}
		}
	}
}
