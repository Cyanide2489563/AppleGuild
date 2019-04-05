package com.Ayrou.AppleGuild.Listener;

import com.Ayrou.AppleGuild.Event.GuildCreateEvent;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GuildListener implements Listener {

    private GuildManager guildManager = Main.getGuildManager();

    @EventHandler
    public void onGuildCreate(GuildCreateEvent event) {

    }
    /*
    @EventHandler
    public void onGuildDisband() {

    }*/
}
