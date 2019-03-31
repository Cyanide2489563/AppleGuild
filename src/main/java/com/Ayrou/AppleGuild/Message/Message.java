package com.Ayrou.AppleGuild.Message;

import java.io.File;

import com.Ayrou.AppleGuild.Main;
import org.bukkit.configuration.file.YamlConfiguration;

public class Message {
    public String Plugin_Initialize;
    public String Plugin_Close;
    public String Sql_Initialize;
    public String Sql_Connection;
    public String Sql_Disconnect;
    public String Affirmative;
    public String Negative;
    public String Guild_Create_Fail_Name_Empty;
    public String Guild_Create_Fail_Name_Format_Error;
    public String Guild_Create_Fail_Blance_Shortage;
    public String Guild_Create_Fail_Systeam_Error;
    public String Guild_Create_Success;
    public String Guild_Create_Fail_joined;
    public String Guild_Invite_Player;
    public String Guild_Invite_Fail_No_Guild;
    public String Guild_Invite_Fail_Name_Empty;
    public String Guild_Invite_Fail_Player_Offline;
    public String Guild_Invite_Fail_Player_Stupid;
    public String Guild_Invite_Fail_Player_joined;
    public String Guild_Invite_Fail_Player_Already;
    public String Guild_Invite_Fail_Player_Negative;
    public String Guild_Invite_Fail_Guild_Full;
    public String Guild_Invite_Player_Affirmative;
    public String Guild_Join_Accept;
    public String Guild_Join_Fail_Cancel;
    public String Guild_Join_Fail_Accept;
    public String Guild_Join_Fail_Empty;
    public String Guild_Join_Fail_TimeOut;
    public String Guild_Leave_Success;
    public String Guild_Leave_Message;
    public String Guild_Leave_Fail_No_Guild;


    public Message() {
        readResource();
    }

    private void readResource() {
        Main plugin = Main.getInstance();
        File file = new File(plugin.getDataFolder(),"Language/language.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        //???????
        Plugin_Initialize = config.getString("Plugin_Initialize");
        Plugin_Close = config.getString("Plugin_Close");
        Sql_Initialize = config.getString("Sql_Initialize");
        Sql_Connection = config.getString("Sql_Connection");
        Sql_Disconnect = config.getString("Sql_Disconnect");
        //??
        Affirmative = config.getString("Affirmative");
        Negative = config.getString("Negative");
        //????
        Guild_Create_Fail_Name_Empty = config.getString("Guild_Create_Fail_Name_Empty");
        Guild_Create_Fail_Name_Format_Error = config.getString("Guild_Create_Fail_Name_Format_Error");
        Guild_Create_Fail_Blance_Shortage = config.getString("Guild_Create_Fail_Blance_Shortage");
        Guild_Create_Fail_joined = config.getString("Guild_Create_Fail_joined");
        Guild_Create_Fail_Systeam_Error = config.getString("Guild_Create_Fail_Systeam_Error");
        Guild_Create_Success = config.getString("Guild_Create_Success");
        //????
        Guild_Invite_Player = config.getString("Guild_Invite_Player");
        Guild_Invite_Fail_No_Guild = config.getString("Guild_Invite_Fail_No_Guild");
        Guild_Invite_Fail_Name_Empty = config.getString("Guild_Invite_Fail_Name_Empty");
        Guild_Invite_Fail_Player_Offline = config.getString("Guild_Invite_Fail_Player_Offline");
        Guild_Invite_Fail_Player_Stupid = config.getString("Guild_Invite_Fail_Player_Stupid");
        Guild_Invite_Fail_Player_joined = config.getString("Guild_Invite_Fail_Player_joined");
        Guild_Invite_Fail_Player_Already = config.getString("Guild_Invite_Fail_Player_Already");
        Guild_Invite_Fail_Player_Negative = config.getString("Guild_Invite_Fail_Player_Negative");
        Guild_Invite_Fail_Guild_Full = config.getString("Guild_Invite_Fail_Guild_Full");
        Guild_Invite_Player_Affirmative = config.getString("Guild_Invite_Player_Affirmative");
        //????
        Guild_Join_Accept = config.getString("Guild_Join_Accept");
        Guild_Join_Fail_Accept = config.getString("Guild_Join_Fail_Accept");
        Guild_Join_Fail_Cancel = config.getString("Guild_Join_Fail_Cancel");
        Guild_Join_Fail_Empty = config.getString("Guild_Join_Fail_Empty");
        Guild_Join_Fail_TimeOut = config.getString("Guild_Join_Fail_TimeOut");
        //????
        Guild_Leave_Success = config.getString("Guild_Leave_Success");
        Guild_Leave_Message = config.getString("Guild_Leave_Message");
        Guild_Leave_Fail_No_Guild = config.getString("Guild_Leave_Fail_No_Guild");
    }

    public String replace(String target,String string,String string2) {
        return target.replace(string, string2);
    }
}
