package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuildManager;
import com.Ayrou.AppleGuild.Main;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.UUID;

public class GuildManager implements IGuildManager {

    private Main plugin = Main.getInstance();
    public ArrayList<Guild> guilds = new ArrayList<>();
    public double Price;
    public int member;
    public int grade;
    public int function_Points;
    public int InviteTimeout;

    public GuildManager() {
        getGuildConfig();
    }

    public Guild getPlayerGuild(UUID uuid) {
        for (Guild guild : guilds) {
            if(guild.isMember(uuid) || guild.isInvited(uuid)) {
                return guild;
            }
        }
        return null;
    }

    public void addGuild(Guild guild) {
        this.guilds.add(guild);
    }

    public void removeGuild(Guild guild) {
        guild.removeGuildData();
        guilds.remove(guild);
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
        return 0;
    }

    private void getGuildConfig() {
        FileConfiguration config = plugin.getConfig();
        InviteTimeout = config.getInt("Guilds.Guild.InviteTimeout");
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
}