package fun.mikolaj0524.pillars.Events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static fun.mikolaj0524.pillars.Elements.Communication.prepareText;
import static fun.mikolaj0524.pillars.Elements.Communication.soundToPlayer;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerData;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		event.setQuitMessage(prepareText(player.getDisplayName() + " has joined!"));
		soundToPlayer(player, Sound.ENTITY_PLAYER_LEVELUP);
		playerData.remove(player);
		inGamePlayers.remove(player);
	}

}
