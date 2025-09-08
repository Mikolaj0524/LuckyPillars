package fun.mikolaj0524.pillars;

import fun.mikolaj0524.pillars.Events.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static fun.mikolaj0524.pillars.Elements.SignManager.createSign;
import static fun.mikolaj0524.pillars.Elements.TeleportPlayer.loadLocations;
import static fun.mikolaj0524.pillars.Elements.Timer.itemsLoop;
import static fun.mikolaj0524.pillars.Elements.Timer.loop;

public final class Pillars extends JavaPlugin {
	private static Pillars instance;

	@Override
	public void onEnable() {
		instance = this;

		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new BlockBreak(), this);
		manager.registerEvents(new BlockPlace(), this);
		manager.registerEvents(new PlayerJoin(), this);
		manager.registerEvents(new PlayerQuit(), this);
		manager.registerEvents(new PlayerMove(), this);
		manager.registerEvents(new SignClick(), this);
		manager.registerEvents(new Damage(), this);


		loop();
		loadLocations();
		itemsLoop();
		createSign();

	}

	@Override
	public void onDisable() {

	}

	public static Pillars getPluginInstance(){
		return instance;
	}
}
