package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Event.GuildCreateEvent;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GuildCreate extends SubCommand {

    @Override
    public void onCommand(Player player, String[] args) {

    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

    private void GuildCreate(Player player, String guildName[]) {
        Message message = Main.getMessage();
        if (Main.getGuildManager().getPlayerGuild(player.getUniqueId()) != null) {
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
                if(Main.getEconomy().getBalance(player) > 30000){
                    Bukkit.getPluginManager().callEvent(new GuildCreateEvent(player, guildName[1]));
                    player.sendMessage("建立公會需花費30000元是否建立公會");
                }
                else {
                    player.sendMessage(message.Guild_Create_Fail_Blance_Shortage);
                    return;
                }
            }
            else {
                player.sendMessage(message.Guild_Create_Fail_Name_Empty);
            }
        }
        else {
            player.sendMessage("你已有公會");
        }
    }
}