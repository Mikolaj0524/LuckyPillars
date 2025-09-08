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
import org.bukkit.entity.Player;

import static fun.mikolaj0524.pillars.Elements.Communication.*;
import static fun.mikolaj0524.pillars.Elements.Game.gameState;
import static fun.mikolaj0524.pillars.Elements.Game.startGame;

public class SignManager {

	public static final Location signLoc = new Location(Bukkit.getWorld("world"), 0, 132, -5);

	public static void createSign(){
		Block block = signLoc.getWorld().getBlockAt(signLoc);
		block.setType(Material.PALE_OAK_WALL_SIGN);

		WallSign wallSign = (WallSign) block.getBlockData();
		wallSign.setFacing(BlockFace.SOUTH);
		block.setBlockData(wallSign, false);

		Sign sign = (Sign) block.getState();

		SignSide signSide = (SignSide) sign.getSide(Side.FRONT);
		signSide.setLine(1, colorText("&9&lStart"));

		sign.update(true, false);
	}

	public static void signClick(Player player){
		if(player.hasPermission("pillars.start")){
			if(gameState){
				player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
				messageToPlayer(player, "Game is now running!");
			}
			else {
				player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 0.5f);
				startGame();
			}
		}
		else{
			player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
			messageToPlayer(player, "You don't have <pillars.start> permission!");
		}
	}

}
