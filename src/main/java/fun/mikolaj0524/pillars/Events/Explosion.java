package fun.mikolaj0524.pillars.Events;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import static fun.mikolaj0524.pillars.Elements.RandomItem.blockedItems;

public class Explosion implements Listener {

	@EventHandler
	public void onEntityExplosion(EntityExplodeEvent event){
		for(Block block : event.blockList()){
			if(blockedItems.contains(block)){
				event.blockList().remove(block);
			}
		}
	}

}
