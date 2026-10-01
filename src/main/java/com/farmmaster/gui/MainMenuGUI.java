package com.farmmaster.gui;

import com.farmmaster.FarmMaster;
import com.farmmaster.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;

public class MainMenuGUI {

    private final Inventory inventory;

    public MainMenuGUI(Player player) {
        this.inventory = Bukkit.createInventory(null, 54, 
            FarmMaster.getInstance().getMiniMessage().deserialize("<gradient:#FFD700:#FFA500><bold>FarmMaster - Panel de Control")
        );

        ItemStack border = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setName("<dark_gray> ")
                .build();
        for (int i = 0; i < 54; i++) {
            if (i < 9 || i > 44 || i % 9 == 0 || i % 9 == 8) {
                inventory.setItem(i, border);
            }
        }

        inventory.setItem(20, new ItemBuilder(Material.WHEAT)
                .setName("<gradient:#00FF00:#00AA00><bold>Mis Granjas</bold>")
                .setLore(Arrays.asList(
                    "<gray>Aquí puedes ver y administrar",
                    "<gray>todas tus granjas automáticas.",
                    "",
                    "<yellow>» Clic para abrir"
                ))
                .addGlow()
                .build());

        inventory.setItem(22, new ItemBuilder(Material.DIAMOND_HOE)
                .setName("<gradient:#00FFFF:#0088FF><bold>Crear Nueva Granja</bold>")
                .setLore(Arrays.asList(
                    "<gray>Selecciona un área con el hacha",
                    "<gray>y crea tu granja automática.",
                    "",
                    "<yellow>» Clic para crear"
                ))
                .build());

        inventory.setItem(24, new ItemBuilder(Material.OAK_SAPLING)
                .setName("<gradient:#FFAA00:#FF5500><bold>Granjas Públicas</bold>")
                .setLore(Arrays.asList(
                    "<gray>Explora las granjas de otros",
                    "<gray>jugadores en el servidor.",
                    "",
                    "<yellow>» Clic para explorar"
                ))
                .build());

        inventory.setItem(38, new ItemBuilder(Material.ANVIL)
                .setName("<gradient:#FF00FF:#AA00AA><bold>Mejoras</bold>")
                .setLore(Arrays.asList(
                    "<gray>Mejora la velocidad, radio",
                    "<gray>y almacenamiento de tu granja.",
                    "",
                    "<yellow>» Clic para mejorar"
                ))
                .build());

        inventory.setItem(40, new ItemBuilder(Material.COAL)
                .setName("<gradient:#FF5555:#AA0000><bold>Combustible</bold>")
                .setLore(Arrays.asList(
                    "<gray>Administra el combustible",
                    "<gray>de tus granjas automáticas.",
                    "",
                    "<yellow>» Clic para gestionar"
                ))
                .build());

        inventory.setItem(42, new ItemBuilder(Material.PLAYER_HEAD)
                .setName("<gradient:#55FFFF:#00AAAA><bold>Miembros</bold>")
                .setLore(Arrays.asList(
                    "<gray>Invita a otros jugadores",
                    "<gray>a administrar tu granja.",
                    "",
                    "<yellow>» Clic para gestionar"
                ))
                .build());

        inventory.setItem(49, new ItemBuilder(Material.BARRIER)
                .setName("<red><bold>Cerrar</bold>")
                .setLore(Arrays.asList("<gray>Cierra este menú."))
                .build());
    }

    public Inventory getInventory() {
        return inventory;
    }
}