package fun.mikolaj0524.pillars.Elements;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class MapManager {

	public static void clearWorld(){
		World world = Bukkit.getWorld("world");

		for(int x = -25; x <= 25; x++){
			for(int y = 61; y <= 120; y++){
				for(int z = -25; z <= 25; z++){
					Block block = world.getBlockAt(x, y, z);
					if(!block.getType().equals(Material.BEDROCK)){
						block.setType(Material.AIR);
					}
				}
			}
		}
	}

}
