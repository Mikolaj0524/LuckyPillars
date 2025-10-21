package fun.mikolaj0524.pillars.Elements;

import fun.mikolaj0524.pillars.Objects.Place;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.preparePlayer;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class TeleportPlayer {

	private static Location spawn;
	private static List<Location> pillars = new ArrayList<>();

	public static void loadLocations(){
		World world = Bukkit.getWorld("world");
		Configuration cfg = getPluginInstance().getConfig();
		spawn = new Location(world, cfg.getDouble("spawn.x"), cfg.getDouble("spawn.y"), cfg.getDouble("spawn.z"), cfg.getInt("spawn.yaw"), 0);

		for(String key : cfg.getConfigurationSection("pillars").getKeys(false)){
			double x = cfg.getDouble("pillars." + key + ".x");
			double y = cfg.getDouble("pillars." + key + ".y");
			double z = cfg.getDouble("pillars." + key + ".z");
			int yaw = cfg.getInt("pillars." + key + ".yaw");
			pillars.add(new Location(world, x, y, z, yaw, 0));
		}
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
