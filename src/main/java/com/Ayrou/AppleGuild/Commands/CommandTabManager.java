package com.Ayrou.AppleGuild.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandTabManager implements TabCompleter {
    private static final List<String> DiplomaticCOMMANDS = Arrays.asList("allies","peace","war","hostility");
    private static final List<String> HellCOMMANDS = Arrays.asList("Setup","Create","Remove","List");
    private static final List<String> COMMANDS = Arrays.asList(
            "Create", "Invite", "Accept", "Cancel","Help","Menu","leave","Hell","SetAnnouncement",
            "SetDiplomaticStatus","SetRecruitAnnouncement","addGroup");
    private static final List<String> BLANK = Arrays.asList("", "");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args[0].equalsIgnoreCase("Hell") && sender.isOp()) {
            if(args.length > 2) {
                return BLANK;
            }
            return StringUtil.copyPartialMatches(args[0], HellCOMMANDS, HellCOMMANDS);
        }
        if (args[0].equalsIgnoreCase("SetDiplomaticStatus")) {
            if(args.length > 2) {
                return BLANK;
            }
            return StringUtil.copyPartialMatches(args[0], DiplomaticCOMMANDS, DiplomaticCOMMANDS);
        }
        if (args[0].equalsIgnoreCase("invite") || args[0].equalsIgnoreCase("kick")) {
            if(args.length > 2) {
                return BLANK;
            }
            List<String> PLAYERLIST = new ArrayList<>();
            for(Player player : Bukkit.getServer().getOnlinePlayers()){
                PLAYERLIST.add(player.getName());
            }
            return StringUtil.copyPartialMatches(args[0], PLAYERLIST, PLAYERLIST);
        }
        if(args.length >= 2) {
            return BLANK;
        }
        return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
    }
}
