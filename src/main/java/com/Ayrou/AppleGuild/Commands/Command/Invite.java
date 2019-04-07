package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Commands.SubCommand;
import com.Ayrou.AppleGuild.Guild.Guild;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Invite extends SubCommand {

    private Message message = Main.getMessage();
    private GuildManager guildManager = Main.getGuildManager();

    @Override
    public void onCommand(Player player, String[] args) {

        if (args.length < 2) {
            player.sendMessage(message.Guild_Invite_Fail_Name_Empty);
            return;
        }

        Guild guild = guildManager.getPlayerGuild(player.getUniqueId());

        if (guild != null) {
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                if (target != player) {
                    if (target.isOnline()) {
                        invite(player, target, guild);
                    }
                    else player.sendMessage(message.Guild_Invite_Fail_Player_Offline);
                }
                else player.sendMessage(message.Guild_Invite_Fail_Player_Stupid);
            }
            else player.sendMessage(message.Guild_Invite_Fail_Name_Empty);
        }
        else player.sendMessage(message.Guild_Invite_Fail_No_Guild);
    }

    @Override
    public String name() {
        return "Invite";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

    private void invite(Player player, Player target, Guild guild) {
        if (guild.getGuildMemberLimited() - guild.getGuildMemberSize() > 1) {
            if (!guild.isMember(player.getUniqueId())) {
                if (!guild.isInvited(player.getUniqueId())) {
                    guild.invite(target.getUniqueId());
                    player.sendMessage(message.replace(
                            message.Guild_Invite_Player,"%PlayerName%", target.getName()
                    ));
                }
                else ;
            }
            else player.sendMessage(message.replace(
                    message.Guild_Invite_Fail_Player_joined,"%PlayerName%", target.getName()
            ));
        }
        else player.sendMessage(message.Guild_Invite_Fail_Guild_Full);
    }
}
