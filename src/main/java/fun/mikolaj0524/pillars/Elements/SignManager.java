package fun.mikolaj0524.pillars.Elements;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.block.sign.Side;
import org.bukkit.block.sign.SignSide;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import static fun.mikolaj0524.pillars.Elements.Communication.*;
import static fun.mikolaj0524.pillars.Elements.Game.gameState;
import static fun.mikolaj0524.pillars.Elements.Game.startGame;
import static fun.mikolaj0524.pillars.Pillars.getPluginInstance;

public class SignManager {

	public static Location signLoc;

	public static void createSign(){
		Configuration cfg = getPluginInstance().getConfig();

		signLoc = new Location(Bukkit.getWorld("world"), cfg.getDouble("sign.x"), cfg.getDouble("sign.y"), cfg.getDouble("sign.z"));

		Block block = signLoc.getWorld().getBlockAt(signLoc);
		block.setType(Material.PALE_OAK_WALL_SIGN);

		WallSign wallSign = (WallSign) block.getBlockData();
		wallSign.setFacing(BlockFace.valueOf(cfg.getString("sign.facing")));
		block.setBlockData(wallSign, false);

		Sign sign = (Sign) block.getState();

		SignSide signSide = (SignSide) sign.getSide(Side.FRONT);
		signSide.setLine(1, colorText("&9&lStart"));

		sign.update(true, false);
	}

	public static void signClick(Player player){
		if(player.hasPermission("luckypillars.start")){
			if(gameState){
				soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
				messageToPlayer(player, "Game is now running!");
			}
			else {
				if(Bukkit.getOnlinePlayers().size() >= 2){
					player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 0.5f);
					startGame();
				}
				else{
					messageToPlayer(player, "Not enough players to start!");
					soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
				}
			}
		}
		else{
			messageToPlayer(player, "You don't have <luckypillars.start> permission!");
			soundToPlayer(player, Sound.BLOCK_NOTE_BLOCK_BASS);
		}
	}

}
