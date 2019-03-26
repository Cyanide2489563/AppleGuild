package com.Ayrou.AppleGuild;

import com.Ayrou.AppleGuild.Commands.CommandManager;
import com.Ayrou.AppleGuild.Commands.CommandTabManager;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Listener.GuildListener;
import com.Ayrou.AppleGuild.Listener.MainListener;
import com.Ayrou.AppleGuild.Message.Message;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;
    public CommandManager commandManager;
    private static GuildManager guildManager;
    private static Message message = null;
    private static Economy economy = null;

    @Override
    public void onEnable() {
        plugin = this;
        checkPlugin();
        info(message.Plugin_Initialize);
        if (!setupEconomy()) info("經濟插件未正確啟用");
        guildManager = new GuildManager();
        commandManager = new CommandManager();
        getCommand("Guild").setTabCompleter(new CommandTabManager());
        getServer().getPluginManager().registerEvents(new MainListener(), this);
        getServer().getPluginManager().registerEvents(new GuildListener(), this);
    }

    @Override
    public void onDisable() {
        guildManager.clearGuilds();
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

    public static GuildManager getGuildManager() {
        return guildManager;
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

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider;
        economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) economy = economyProvider.getProvider();
        return (economy != null);
    }

    public static Economy getEconomy() {
        return economy;
    }
}
