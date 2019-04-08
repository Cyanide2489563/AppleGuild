package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Commands.SubCommand;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import com.Ayrou.AppleGuild.Util.Util;
import org.bukkit.entity.Player;

public class GuildCreate extends SubCommand {

    private Message message = Main.getMessage();
    private GuildManager guildManager = Main.getGuildManager();

    @Override
    public void onCommand(Player player, String[] args) {
        create(player, args);
    }

    @Override
    public String name() {
        return "create";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

    private void create(Player player, String[] guildName) {
        if (Main.getGuildManager().getPlayerGuild(player.getUniqueId()) == null) {
            if (guildName.length > 1) {
                int num = 0;
                boolean matches = true;
                for (int i = 0,j = guildName[1].length(); i < j; i++) {
                    String temp = guildName[1].substring(i, i + 1);
                    if(temp.matches("[\u4e00-\u9fa5]")) {
                        num+=1;
                    }
                    else if(temp.matches("[a-zA-Z0-9]*")) {
                        num+=1;
                    }
                    else matches=!matches;
                }
                if (num > 10 || !matches) {
                    player.sendMessage(message.Guild_Create_Fail_Name_Format_Error);
                    return;
                }
                if (Main.getEconomy().getBalance(player) > Main.getGuildManager().getPrice()) {
                    guildManager.addGuildCreateList(player, guildName[1]);
                    Util util = new Util();
                    util.sendConfirmMessage(player.getUniqueId(),
                                    message.replace(message.Guild_Create_Affirmative_Blance,
                                    "%Price%",
                                            String.valueOf(Main.getGuildManager().getPrice())) + "\n",
                                   "CreateConfirm accept " + guildName[1],
                                  "CreateConfirm cancel " + guildName[1]);
                }
                else {
                    player.sendMessage(message.Guild_Create_Fail_Blance_Shortage);
                }
            }
            else {
                player.sendMessage(message.Guild_Create_Fail_Name_Empty);
            }
        }
        else {
            player.sendMessage(message.Guild_Create_Fail_joined);
        }
    }
}