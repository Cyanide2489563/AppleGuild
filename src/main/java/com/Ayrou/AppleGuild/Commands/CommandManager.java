package com.Ayrou.AppleGuild.Commands;

import com.Ayrou.AppleGuild.Commands.Command.GuildCreate;
import com.Ayrou.AppleGuild.Commands.Command.SubCommand;
import com.Ayrou.AppleGuild.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
    private Main plugin = Main.getInstance();

    public String command = "guild";

    CommandManager() {
        plugin.getCommand(command).setExecutor(this);

        this.commands.add(new GuildCreate());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        return false;
    }

    private SubCommand get(String name) {
        Iterator<SubCommand> subcommands = this.commands.iterator();

        while (subcommands.hasNext()) {
            SubCommand sc = subcommands.next();

            if (sc.name().equalsIgnoreCase(name)) {
                return sc;
            }

            String[] aliases;
            int length = (aliases = sc.aliases()).length;

            for (int i = 0; i < length; i++) {
                String alias = aliases[i];
                if (name.equalsIgnoreCase(alias)) {
                    return sc;
                }
            }
        }
        return null;
    }
}