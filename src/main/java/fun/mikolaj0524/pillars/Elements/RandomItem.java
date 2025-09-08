package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;

public class RandomItem {

	private static List<Material> materials = List.of(Material.values());

	private static List<Material> blockedItems = List.of(
			Material.COMMAND_BLOCK,
			Material.CHAIN_COMMAND_BLOCK,
			Material.REPEATING_COMMAND_BLOCK,
			Material.COMMAND_BLOCK_MINECART,
			Material.JIGSAW,
			Material.STRUCTURE_BLOCK,
			Material.STRUCTURE_VOID,
			Material.BARRIER,
			Material.DEBUG_STICK,
			Material.LIGHT,
			Material.BEDROCK
	);

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
