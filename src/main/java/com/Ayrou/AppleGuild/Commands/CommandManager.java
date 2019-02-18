package com.Ayrou.AppleGuild.Commands;

import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        if (sender instanceof Player) {

            Player player = (Player) sender;
            Message message = Main.getMessage();

            if (arg3.length == 0) {
                player.sendMessage("此功能尚未實作");
                return true;
            }
            if(arg3[0].equalsIgnoreCase("Create")) {
                if(arg3.length > 1) {

                }
                else {
                    player.sendMessage(message.Guild_Create_Fail_Name_Empty);
                }
            }
            if(arg3[0].equalsIgnoreCase("Invite")) {
                if(arg3.length > 1) {

                }
                else {
                    player.sendMessage(message.Guild_Invite_Fail_Name_Empty);
                }
            }
            if(arg3[0].equalsIgnoreCase("Accept")) {

            }
            if(arg3[0].equalsIgnoreCase("Cancel")) {

            }
            if(arg3[0].equalsIgnoreCase("Leave")) {

            }
            if(arg3[0].equalsIgnoreCase("Menu")) {

            }
            if(arg3[0].equalsIgnoreCase("setAnnouncement")) {

            }
            if(arg3[0].equalsIgnoreCase("SetDiplomaticStatus")) {

            }
            if(arg3[0].equalsIgnoreCase("SetRecruitAnnouncement")) {

            }
            if(arg3[0].equalsIgnoreCase("addGroup")) {

            }
            if(arg3[0].equalsIgnoreCase("Affirmative")) {

            }
            if(arg3[0].equalsIgnoreCase("Negative")) {

            }
            if(arg3[0].equalsIgnoreCase("Hell")) {
                if (player.isOp()) {

                }
                else player.sendMessage("權限不足");
            }
        }
        return true;
    }
}