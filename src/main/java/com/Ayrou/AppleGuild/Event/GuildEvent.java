package com.Ayrou.AppleGuild.Event;

import com.Ayrou.AppleGuild.Guild.Guild;
import org.bukkit.event.Event;
//????
public abstract class GuildEvent extends Event {
    protected Guild guild;

    public Guild getGuild() {
        return guild;
    }
}
