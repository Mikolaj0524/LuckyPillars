package fun.mikolaj0524.pillars.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerDeath;

public class Damage implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent event){
		Player player1 = (Player) event.getEntity();
		Player player2 = (Player) event.getDamageSource().getCausingEntity();
		event.setCancelled(true);

		double health = player1.getHealth() - event.getFinalDamage();
		if(health <= 0){
			playerDeath(player1, player2);
		}

	}

}
