package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Commands.SubCommand;
import com.Ayrou.AppleGuild.Guild.Guild;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.entity.Player;

public class GuildCreateConfirm extends SubCommand {

    private Message message = Main.getMessage();

    @Override
    public void onCommand(Player player, String[] args) {

        GuildManager guildManager = Main.getGuildManager();

        if (guildManager.getPlayerGuild(player.getUniqueId()) == null) {
            if (args[1].equals("accept")) {
                if (guildManager.getGuildCreateList().containsKey(player)) {
                    guildManager.removeGuildCreateList(player, args[2]);
                    Guild guild = new Guild();
                    guild.GuildCreate(args[2], player.getUniqueId());
                    guildManager.addGuild(guild);
                    player.sendMessage(message.replace(message.Guild_Create_Success,"%GuildName%",args[2]));
                }
                else player.sendMessage(message.Guild_Create_Fail_Cancel);
            }
            else {
                player.sendMessage(message.Guild_Create_Fail_Cancel);
                guildManager.removeGuildCreateList(player, args[2]);
            }
        }
        else player.sendMessage(message.Guild_Create_Fail_joined);

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