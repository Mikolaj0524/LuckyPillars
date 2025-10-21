package fun.mikolaj0524.pillars.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

public class ProjectileHit implements Listener {

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {

		if ((event.getEntityType() == EntityType.SNOWBALL || event.getEntityType() == EntityType.EGG ) && event.getHitEntity() instanceof Player) {
			Player hit = (Player) event.getHitEntity();
			hit.damage(1.0);
			Vector knockback = event.getEntity().getVelocity().normalize().multiply(1.0);
			knockback.setY(0.5);
			hit.setVelocity(knockback);
		}

	}

}
