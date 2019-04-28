package com.Ayrou.AppleGuild.Listener;

import com.Ayrou.AppleGuild.Guild.Guild;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class MainListener implements Listener {

    private GuildManager guildManager = Main.getGuildManager();

    @EventHandler
    public void PlayerJoin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        Guild guild = guildManager.getPlayerGuild(player.getUniqueId());
        if (guild != null) {
            guild.addGuildOnlineMember(player.getUniqueId());
        }
    }

    @EventHandler
    public void PlayerKick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        Guild guild = guildManager.getPlayerGuild(player.getUniqueId());
        if (guild != null) {
            guild.removeGuildOnlineMember(player.getUniqueId());
        }
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Guild guild = guildManager.getPlayerGuild(player.getUniqueId());
        if (guild != null) {
            guild.removeGuildOnlineMember(player.getUniqueId());
        }
    }


}
