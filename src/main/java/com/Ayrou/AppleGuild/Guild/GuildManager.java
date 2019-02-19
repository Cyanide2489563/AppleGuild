package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuildManager;

import java.util.ArrayList;
import java.util.UUID;

public class GuildManager implements IGuildManager {
    public ArrayList<Guild> guilds = new ArrayList<>();

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
}