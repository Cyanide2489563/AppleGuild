package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuildManager;
import com.Ayrou.AppleGuild.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GuildManager implements IGuildManager {

    private Main plugin = Main.getInstance();
    private ArrayList<Guild> guilds = new ArrayList<>();
    private HashMap<Player,String> guildCreateList = new HashMap<>();
    private double Price;
    private int member;
    private int grade;
    private int function_Points;
    private int InviteTimeout;

    public GuildManager() {
        getGuildConfig();
    }

    public Guild getPlayerGuild(UUID uuid) {
        for (Guild guild : guilds) {
            if(guild.isMember(uuid)) {
                return guild;
            }
        }
        return null;
    }

    public void addGuild(Guild guild) {
        this.guilds.add(guild);
    }

    public void removeGuild(Guild guild) {
        guilds.remove(guild);
        guild.removeGuildData();
    }

    public void clearGuilds() {
        guilds.clear();
    }

    @Override
    public ArrayList<Guild> getGuildList() {
        return guilds;
    }

    @Override
    public int getGuildQuantity() {
        return guilds.size();
    }

    private void getGuildConfig() {
        FileConfiguration config = plugin.getConfig();
        InviteTimeout = config.getInt("Guilds.Guild.InviteTimeout") * 1000;
        Price = config.getDouble("Guilds.Create.Price");
        member = config.getInt("Guilds.Create.Member");
    }

    public double getPrice() {
        return Price;
    }

    public int getGrade() {
        return grade;
    }

    public int getInviteTimeout() {
        return InviteTimeout;
    }

    public int getFunction_Points() {
        return function_Points;
    }

    public int getMember() {
        return member;
    }

    public HashMap<Player, String> getGuildCreateList() {
        return guildCreateList;
    }

    public void addGuildCreateList(Player player, String name) {
        this.guildCreateList.put(player, name);
    }

    public void removeGuildCreateList(Player player, String name) {
        this.guildCreateList.remove(player, name);
    }
}