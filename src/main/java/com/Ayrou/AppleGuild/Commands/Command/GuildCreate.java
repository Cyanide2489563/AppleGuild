package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Event.GuildCreateEvent;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GuildCreate {

    Message message = Main.getMessage();

    public GuildCreate(Player player, String guildName[]) {
        if (guildName.length > 1) {
            //TODO 完成公會名稱驗證
            Bukkit.getPluginManager().callEvent(new GuildCreateEvent(player,guildName[1]));
            player.sendMessage("建立公會需花費30000元是否建立公會");
        }
        else {
            player.sendMessage(message.Guild_Create_Fail_Name_Empty);
        }
    }
}