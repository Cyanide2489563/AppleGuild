package com.Ayrou.AppleGuild.Commands;

import com.Ayrou.AppleGuild.Commands.Command.GuildCreate;
import com.Ayrou.AppleGuild.Commands.Command.GuildCreateConfirm;
import com.Ayrou.AppleGuild.Commands.Command.SubCommand;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<>();
    private Main plugin = Main.getInstance();
    private Message message = Main.getMessage();

    private String command = "guild";

    public void setup() {
        plugin.getCommand(command).setExecutor(this);
        plugin.getCommand(command).setTabCompleter(new CommandTabManager());
        this.commands.add(new GuildCreate());
        this.commands.add(new GuildCreateConfirm());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(message.Guild_Command_Invalid_Sender);
            return true;
        }

        Player player = (Player) sender;

        if (arg1.getName().equalsIgnoreCase(command)) {
            if (args.length == 0) {
                player.sendMessage(message.Guild_Command_Help);
                return true;
            }

            SubCommand target = this.get(args[0]);

            if (target == null) {
                player.sendMessage(message.Guild_Command_Invalid_SubCommand);
                return true;
            }

            //ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(args));
            //arrayList.remove(0);

            try{
                target.onCommand(player,args);
            }catch (Exception e){
                player.sendMessage(message.Guild_Command_Error);
                e.printStackTrace();
            }
        }
        return true;
    }

    private SubCommand get(String name) {

        for (SubCommand sc : this.commands) {
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