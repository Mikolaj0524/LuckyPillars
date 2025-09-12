package fun.mikolaj0524.pillars.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explosion implements Listener {

	@EventHandler
	public void onEntityExplosion(EntityExplodeEvent event){
		event.blockList().clear();
	}

}
