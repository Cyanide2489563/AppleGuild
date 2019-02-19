package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuildManager;

import java.util.ArrayList;

public class GuildManager implements IGuildManager {
    public ArrayList<Guild> guilds = new ArrayList<>();

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
}