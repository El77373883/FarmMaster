package com.farmmaster;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

public class FarmMaster extends JavaPlugin {

    private static FarmMaster instance;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("========================================");
        getLogger().info("   FarmMaster v1.0.0-Premium Cargado");
        getLogger().info("   ¡Listo para automatizar el servidor!");
        getLogger().info("========================================");
        
        getCommand("farmmaster").setExecutor(new com.farmmaster.commands.FarmCommand());
        getServer().getPluginManager().registerEvents(new com.farmmaster.gui.GUIListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("FarmMaster ha sido desactivado. ¡Hasta pronto!");
    }

    public static FarmMaster getInstance() {
        return instance;
    }

    public MiniMessage getMiniMessage() {
        return miniMessage;
    }
}