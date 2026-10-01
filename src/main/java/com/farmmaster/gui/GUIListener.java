package com.farmmaster.gui;

import com.farmmaster.FarmMaster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof MainMenuGUI)) {
            return;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        switch (slot) {
            case 20:
                player.closeInventory();
                FarmMaster.getInstance().getMiniMessage().deserialize("<yellow>Abriendo tus granjas...");
                break;
            case 22:
                player.closeInventory();
                player.sendMessage(FarmMaster.getInstance().getMiniMessage().deserialize("<yellow>Selecciona un área con el hacha para crear tu granja."));
                break;
            case 24:
                player.closeInventory();
                player.sendMessage(FarmMaster.getInstance().getMiniMessage().deserialize("<yellow>Abriendo granjas públicas..."));
                break;
            case 38:
                player.closeInventory();
                player.sendMessage(FarmMaster.getInstance().getMiniMessage().deserialize("<yellow>Abriendo mejoras..."));
                break;
            case 40:
                player.closeInventory();
                player.sendMessage(FarmMaster.getInstance().getMiniMessage().deserialize("<yellow>Abriendo combustible..."));
                break;
            case 42:
                player.closeInventory();
                player.sendMessage(FarmMaster.getInstance().getMiniMessage().deserialize("<yellow>Abriendo miembros..."));
                break;
            case 49:
                player.closeInventory();
                player.playSound(player.getLocation(), org.bukkit.Sound.BLOCK_CHEST_CLOSE, 1.0f, 1.2f);
                break;
        }
    }
}