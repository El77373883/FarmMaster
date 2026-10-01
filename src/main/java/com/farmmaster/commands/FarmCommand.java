package com.farmmaster.commands;

import com.farmmaster.FarmMaster;
import com.farmmaster.gui.MainMenuGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FarmCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo los jugadores pueden usar este comando.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("farmmaster.use")) {
            player.sendMessage(FarmMaster.getInstance().getMiniMessage().deserialize("<red>No tienes permiso para usar este comando.</red>"));
            return true;
        }
        MainMenuGUI gui = new MainMenuGUI(player);
        player.openInventory(gui.getInventory());
        player.playSound(player.getLocation(), org.bukkit.Sound.BLOCK_CHEST_OPEN, 1.0f, 1.2f);
        return true;
    }
}