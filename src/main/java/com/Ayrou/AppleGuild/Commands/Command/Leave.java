package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Commands.SubCommand;
import com.Ayrou.AppleGuild.Guild.Guild;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.entity.Player;

public class Leave extends SubCommand {

    private Message message = Main.getMessage();
    private GuildManager guildManager = Main.getGuildManager();

    @Override
    public void onCommand(Player player, String[] args) {
        leave(player);
    }

    @Override
    public String name() {
        return "leave";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

    private void leave(Player player) {
        Guild guild = guildManager.getPlayerGuild(player.getUniqueId());

        if (guild != null) {
            if(guild.isLeader(player.getUniqueId())) {
                if (guild.getGuildMemberSize() > 1) {
                    player.sendMessage(message.Guild_Leave_Select_New_Leader);
                }
                else player.sendMessage(message.replace(
                        message.Guild_Leave_Success,"%GuildName%", guild.getGuildName()
                ));
                guild.removeGuildMember(player.getUniqueId());
            }
            else {
                guild.sendGuildMessage(message.replace(
                        message.Guild_Leave_Message, "%PlayName%", player.getName()
                ));
                guild.removeGuildMember(player.getUniqueId());
            }
        }
        else player.sendMessage(message.Guild_Leave_Fail_No_Guild);
    }
}