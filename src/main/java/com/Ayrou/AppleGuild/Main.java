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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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
}
