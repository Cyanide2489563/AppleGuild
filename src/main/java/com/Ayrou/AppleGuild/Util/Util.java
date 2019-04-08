package com.Ayrou.AppleGuild.Util;

import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;

import java.util.Objects;
import java.util.UUID;

public class Util {

    private Message message = Main.getMessage();

    public void sendConfirmMessage(UUID uuid, String message, String command, String command1) {
        TextComponent up = new TextComponent("§a============================§r\n");
        TextComponent text = new TextComponent(message + "\n");
        TextComponent text1 = new TextComponent("§2§n[接受]");
        text1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild " + command));
        text1.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(this.message.Affirmative).create()
        ));

        TextComponent space = new TextComponent("§r   ");

        TextComponent text2 = new TextComponent("§4§n[拒絕]\n");
        text2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild " + command1));
        text2.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(this.message.Negative).create()
        ));

        TextComponent down = new TextComponent("§a============================§r");
        up.addExtra(text);
        up.addExtra(text1);
        up.addExtra(space);
        up.addExtra(text2);
        up.addExtra(down);

        Objects.requireNonNull(Bukkit.getPlayer(uuid)).spigot().sendMessage(up);
    }
}
