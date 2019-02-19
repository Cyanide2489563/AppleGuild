package com.Ayrou.AppleGuild.Listener;

import com.Ayrou.AppleGuild.Event.GuildCreateEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GuildListener implements Listener {

    @EventHandler
    public void onGuildCreate(GuildCreateEvent event) {
        Player player = event.getPlayer();
        String guildName = event.getGuildName();


    }

    @EventHandler
    public void onGuildDisband() {

    }
}
