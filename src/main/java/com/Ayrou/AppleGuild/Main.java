package com.Ayrou.AppleGuild;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.Ayrou.AppleGuild.Message.Message;

public final class Main extends JavaPlugin {
    private static Main plugin;
    private static Message message = null;

    @Override
    public void onEnable() {
        plugin = this;
        checkPlugin();
        info(message.Plugin_Initialize);
    }

    @Override
    public void onDisable() {
        info(message.Plugin_Close);
    }

    public static void info(String string) {
        Bukkit.getConsoleSender().sendMessage("[AppleGuild] " + string);
    }

    public static Main getInstance() {
        return plugin;
    }

    public static Message getMessage() {
        return message;
    }

    private void checkPlugin() {
        int a = 0;
        if (!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
            info("缺少Vault");
            a++;
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("WorldGuard")) {
            info("缺少worldguard");
            a++;
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
            info("缺少worldedit");
            a++;
        }
        if (a > 0) {
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
}
