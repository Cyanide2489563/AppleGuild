package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Guild.Guild;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.entity.Player;

public class GuildCreateConfirm extends SubCommand {

    private Message message = Main.getMessage();

    @Override
    public void onCommand(Player player, String[] args) {
        if (args[1].equals("accept")) {
            GuildManager guildManager = Main.getGuildManager();

            if (guildManager.getPlayerGuild(player.getUniqueId()) == null) {
                Guild guild = new Guild();
                guild.GuildCreate(args[2], player.getUniqueId());
                guildManager.addGuild(guild);
                player.sendMessage(message.replace(message.Guild_Create_Success,"%GuildName%",args[2]));
            }
           else player.sendMessage(message.Guild_Create_Fail_joined);
        }
        else {
            player.sendMessage(message.Guild_Create_Fail_Cancel);
        }
    }

    @Override
    public String name() {
        return "CreateConfirm";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
