package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.preparePlayer;

public class TeleportPlayer {

	private static Location spawn;
	private static List<Location> pillars = new ArrayList<>();

	public static void loadLocations(){
		World world = Bukkit.getWorld("world");
		spawn = new Location(world, 0.5, 131, 0.5, 180, 0);
		pillars.add(new Location(world, 0, 102, 15, 180, 0));
		pillars.add(new Location(world, 10, 102, 10, 135, 0));
		pillars.add(new Location(world, 15, 102, 0, 90, 0));
		pillars.add(new Location(world, 10, 102, -10, 45, 0));
		pillars.add(new Location(world, 0, 102, -15, 0, 0));
		pillars.add(new Location(world, -10, 102, -10, -45, 0));
		pillars.add(new Location(world, -15, 102, 0, -90, 0));
		pillars.add(new Location(world, -10, 102, 10, -135, 0));

	}

	public static void teleportToSpawn(Player player){
		player.teleport(spawn);
		preparePlayer(player, Place.LOBBY);
	}

	public static void teleportPlayers(Place place){
		List<Integer> used = new ArrayList<>();
		Random random = new Random();

		for(Player player : inGamePlayers){
			if(place == Place.LOBBY){
				teleportToSpawn(player);
			}
			else{
				Integer selected = null;

				while(selected == null){
					Integer num = random.nextInt(0, pillars.size());
					if(!used.contains(num)){
						used.add(num);
						selected = num;
					}
				}
				player.teleport(pillars.get(selected).clone().add(0.5, 0, 0.5));
				preparePlayer(player, Place.AREA);
			}
		}
	}

}
