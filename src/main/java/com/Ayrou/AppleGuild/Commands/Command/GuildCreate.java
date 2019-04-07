package com.Ayrou.AppleGuild.Commands.Command;

import com.Ayrou.AppleGuild.Commands.SubCommand;
import com.Ayrou.AppleGuild.Guild.Guild;
import com.Ayrou.AppleGuild.Guild.GuildManager;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
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
                    Guild.sendConfirmMessage(player.getUniqueId(), );
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

    private void guildCreateConfirm(Player player, String name) {
        TextComponent up = new TextComponent("§a============================§r\n");
        TextComponent text = new TextComponent(message.replace(message.Guild_Create_Affirmative_Blance,
                                        "%Price%",
                                               String.valueOf(Main.getGuildManager().getPrice())) + "\n");
        TextComponent text1 = new TextComponent("§2§n[接受]");
        text1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild CreateConfirm accept " + name));
        text1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("接受").create()));

        TextComponent space = new TextComponent("§r   ");

        TextComponent text2 = new TextComponent("§4§n[拒絕]\n");
        text2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild CreateConfirm cancel " + name));
        text2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("拒絕").create()));

        TextComponent down = new TextComponent("§a============================§r");
        up.addExtra(text);
        up.addExtra(text1);
        up.addExtra(space);
        up.addExtra(text2);
        up.addExtra(down);

        player.spigot().sendMessage(up);
    }
}