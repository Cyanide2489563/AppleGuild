package com.Ayrou.AppleGuild.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class GuildCreateEvent extends GuildEvent {

    private static final HandlerList handlerList = new HandlerList();
    private boolean isCancelled;
    private final Player player;
    private final String guildName;

    public GuildCreateEvent (Player player, String guildName) {
        this.player = player;
        this.guildName = guildName;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public Player getPlayer() {
        return player;
    }

    public String getGuildName() {
        return guildName;
    }
}
