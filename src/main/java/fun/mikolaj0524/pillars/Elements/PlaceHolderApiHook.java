package fun.mikolaj0524.pillars.Elements;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static fun.mikolaj0524.pillars.Elements.Game.gameState;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.inGamePlayers;
import static fun.mikolaj0524.pillars.Elements.PlayerManager.playerData;
import static fun.mikolaj0524.pillars.Elements.Timer.time;

public class PlaceHolderApiHook extends PlaceholderExpansion {


	@Override
	public @NotNull String getAuthor() {
		return "Mikolaj0524";
	}

	@Override
	public @NotNull String getIdentifier() {
		return "luckypillars";
	}

	@Override
	public @NotNull String getVersion() {
		return "1.0.0";
	}

	@Override
	public String onRequest(OfflinePlayer player, @NotNull String params) {
		if(!(player instanceof Player))
			return "";

		if(params.equalsIgnoreCase("kills")){
			return playerData.get(player).getKills().toString();
		}
		else if(params.equalsIgnoreCase("time")){
			int minutes = time / 60;
			int seconds = time % 60;
			if(seconds <= 9){
				return minutes + ":0" +  seconds;
			}
			return minutes + ":" +  seconds;

		}
		else if(params.equalsIgnoreCase("gameState")){
			return gameState ? "Running" : "Waiting";
		}
		else if(params.equalsIgnoreCase("players")){
			return "" + inGamePlayers.size();
		}

		return "";
	}

}
