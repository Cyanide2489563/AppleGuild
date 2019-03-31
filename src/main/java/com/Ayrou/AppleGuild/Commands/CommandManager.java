package com.Ayrou.AppleGuild.Commands;

import com.Ayrou.AppleGuild.Commands.Command.GuildCreate;
import com.Ayrou.AppleGuild.Commands.Command.SubCommand;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<>();
    private Main plugin = Main.getInstance();
    private Message message = plugin.getMessage();

    public String command = "guild";

    public void setup() {
        plugin.getCommand(command).setExecutor(this);
        plugin.getCommand(command).setTabCompleter(new CommandTabManager());
        this.commands.add(new GuildCreate());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("無效的命令發送者");
            return true;
        }

        Player player = (Player) sender;

        if (arg1.getName().equalsIgnoreCase(command)) {
            if (args.length == 0) {
                player.sendMessage("輸入/guild help 查看指令選項");
                return true;
            }

            SubCommand target = this.get(args[0]);

            if (target == null) {
                player.sendMessage("無效的子指令");
                return true;
            }

            ArrayList<String> arrayList = new ArrayList<>();

            arrayList.addAll(Arrays.asList(args));
            arrayList.remove(0);

            try{
                target.onCommand(player,args);
            }catch (Exception e){
                player.sendMessage("An error has occurred.");
                e.printStackTrace();
            }
        }
        return true;
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