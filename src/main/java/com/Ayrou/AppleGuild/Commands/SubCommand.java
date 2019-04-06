package com.Ayrou.AppleGuild.Commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    public abstract void onCommand(Player player, String[] args);

    public abstract String name();

    public abstract String info();

    public abstract String[] aliases();
}