package fun.mikolaj0524.pillars.Events;

import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

import static fun.mikolaj0524.pillars.Elements.Communication.messageToPlayer;
import static fun.mikolaj0524.pillars.Elements.Communication.soundToPlayer;
import static fun.mikolaj0524.pillars.Elements.Game.restartGame;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class Command implements Listener, CommandExecutor, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args){
		if(sender instanceof Player player){
			if(command.getName().equals("luckypillars")){
				if(args.length == 1){
					if(args[0].equals("restart")){
						if(player.hasPermission("luckypillars.restart")){
							restartGame();
							messageToPlayer(player, "Successfully restarted the game!");
							soundToPlayer(player, Sound.ENTITY_PLAYER_LEVELUP);
						}
						else{
							messageToPlayer(player, "You don't have <luckypillars.restart> permission!");
							soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
						}
					}
					else if (args[0].equals("rlc")) {
						if(player.hasPermission("luckypillars.rlc")){
							getPluginInstance().reloadConfig();
							messageToPlayer(player, "Successfully reloaded config!");
							soundToPlayer(player, Sound.ENTITY_PLAYER_LEVELUP);
						}
						else{
							messageToPlayer(player, "You don't have <luckypillars.rlc> permission!");
							soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
						}
					}
					else{
						messageToPlayer(player, "Usage /luckypillars <restart/rlc>!");
						soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
					}
				}
				else{
					messageToPlayer(player, "Usage /luckypillars <restart/rlc>!");
					soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
				}

			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args){
		List<String> suggestions = new ArrayList<>();
		if(command.getName().equals("luckypillars")){
			if(args.length == 1){
				suggestions = List.of("restart", "rlc");
			}
		}
		return suggestions;
	}

}
