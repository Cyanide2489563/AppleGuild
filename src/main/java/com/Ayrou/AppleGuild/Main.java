package com.Ayrou.AppleGuild;

import com.Ayrou.AppleGuild.Commands.CommandManager;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Listener.GuildListener;
import com.Ayrou.AppleGuild.Message.Message;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class Main extends JavaPlugin {

    private static Main plugin;
    private static GuildManager guildManager;
    private static Message message = null;
    private static Economy economy = null;

    @Override
    public void onEnable() {
        plugin = this;
        checkPlugin();
        createData();
        message = new Message();
        info(message.Plugin_Initialize);
        if (!setupEconomy()) info("?????????");
        guildManager = new GuildManager();
        CommandManager commandManager = new CommandManager();
        commandManager.setup();
        //getServer().getPluginManager().registerEvents(new MainListener(), this);
        getServer().getPluginManager().registerEvents(new GuildListener(), this);
    }

    @Override
    public void onDisable() {
        guildManager.clearGuilds();
        info(message.Plugin_Close);
    }

    private static void info(String string) {
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
            info("未安裝Vault");
            a++;
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("WorldGuard")) {
            info("未安裝worldguard");
            a++;
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
            info("未安裝worldedit");
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

    private void createData() {
        File languageFolder =  new File(getDataFolder(), "Language");
        if(!languageFolder.exists())
            languageFolder.mkdirs();

        File languageFile =  new File(languageFolder, "language.yml");
        if (!languageFile.exists()) {
            try {
                languageFile.createNewFile();
                InputStream inputStream = this.getClass().getResourceAsStream("/language.yml");
                Files.copy(inputStream, Paths.get(getDataFolder() + "/Language/language.yml"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File guildFolder =  new File(getDataFolder(), "Guild");
        if(!guildFolder.exists()) {
            guildFolder.mkdir();
        }
    }
}
