package fun.mikolaj0524.pillars.Elements;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class RandomItem {

	private static List<Material> materials = List.of(Material.values());

	public static final List<Material> blockedItems = getPluginInstance().getConfig().getStringList("bannedBlocks").stream().map(name -> Material.getMaterial(name.toUpperCase())).collect(Collectors.toList());

	public static void giveItems(){
		for(Player player : inGamePlayers){
			player.getInventory().addItem(getRandomItem());
		}
	}

	public static ItemStack getRandomItem(){
		Material mat = null;
		Random random = new Random();

		while (mat == null){
			int num = random.nextInt(0, materials.size() - 1);
			if(!blockedItems.contains(materials.get(num))){
				mat = materials.get(num);
			}
		}

		return new ItemStack(mat, 1);
	}

}
