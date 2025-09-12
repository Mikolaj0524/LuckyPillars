package fun.mikolaj0524.pillars;

import fun.mikolaj0524.pillars.Elements.PlaceHolderApiHook;
import fun.mikolaj0524.pillars.Events.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static fun.mikolaj0524.pillars.Elements.SignManager.createSign;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.loadLocations;
import static fun.mikolaj0524.pillars.Elements.Timer.itemsLoop;
import static fun.mikolaj0524.pillars.Elements.Timer.loop;

public final class Pillars extends JavaPlugin {
	private static Pillars instance;

	@Override
	public void onEnable() {
		getServer().getLogger().info("Lucky pillars - start!");
		instance = this;

		saveDefaultConfig();
		
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new PlayerDeath(), this);
		manager.registerEvents(new BlockBreak(), this);
		manager.registerEvents(new BlockPlace(), this);
		manager.registerEvents(new PlayerJoin(), this);
		manager.registerEvents(new PlayerQuit(), this);
		manager.registerEvents(new PlayerMove(), this);
		manager.registerEvents(new SignClick(), this);
		manager.registerEvents(new Damage(), this);
		manager.registerEvents(new Explosion(), this);
		manager.registerEvents(new PlayerInteract(), this);

		loop();
		loadLocations();
		itemsLoop();
		createSign();
		getCommand("luckypillars").setExecutor(new Command());
		getCommand("luckypillars").setTabCompleter(new Command());

		if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			new PlaceHolderApiHook().register();
		}
	}

	@Override
	public void onDisable() {
		getServer().getLogger().info("Lucky pillars - stop!");
	}

	public static Pillars getPluginInstance(){
		return instance;
	}
}
