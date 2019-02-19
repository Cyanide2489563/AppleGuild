package com.Ayrou.AppleGuild.Event;

import com.Ayrou.AppleGuild.Guild.Guild;
import org.bukkit.event.Event;
//公會事件
public abstract class GuildEvent extends Event {
    protected Guild guild;

    public Guild getGuild() {
        return guild;
    }
}
