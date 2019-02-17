package com.Ayrou.AppleGuild.Message;

import java.io.File;

import com.Ayrou.AppleGuild.Main;
import org.bukkit.configuration.file.YamlConfiguration;

public class Message {
    private String Plugin_Close;
    private String Sql_Initialize;
    private String Sql_Connection;
    private String Sql_Disconnect;
    private String Affirmative;
    private String Negative;
    private String Guild_Create_Fail_Name_Empty;
    private String Guild_Create_Fail_Name_Format_Error;
    private String Guild_Create_Fail_Blance_Shortage;
    private String Guild_Create_Fail_Systeam_Error;
    private String Guild_Create_Success;
    private String Guild_Create_Fail_joined;
    private String Guild_Invite_Player;
    private String Guild_Invite_Fail_No_Guild;
    private String Guild_Invite_Fail_Name_Empty;
    private String Guild_Invite_Fail_Player_Offline;
    private String Guild_Invite_Fail_Player_Stupid;
    private String Guild_Invite_Fail_Player_joined;
    private String Guild_Invite_Fail_Player_Already;
    private String Guild_Invite_Fail_Player_Negative;
    private String Guild_Invite_Fail_Guild_Full;
    private String Guild_Invite_Player_Affirmative;
    private String Guild_Join_Accept;
    private String Guild_Join_Fail_Cancel;
    private String Guild_Join_Fail_Accept;
    private String Guild_Join_Fail_Empty;
    private String Guild_Join_Fail_TimeOut;
    private String Guild_Leave_Success;
    private String Guild_Leave_Message;
    private String Guild_Leave_Fail_No_Guild;


    public Message() {
        readResource();
    }

    private void readResource() {
        Main plugin = Main.getInstance();
        File file = new File(plugin.getDataFolder(),"Language/language.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        //插件初始化階段
        String plugin_Initialize = config.getString("Plugin_Initialize");
        Plugin_Close = config.getString("Plugin_Close");
        Sql_Initialize = config.getString("Sql_Initialize");
        Sql_Connection = config.getString("Sql_Connection");
        Sql_Disconnect = config.getString("Sql_Disconnect");
        //通用
        Affirmative = config.getString("Affirmative");
        Negative = config.getString("Negative");
        //公會建立
        Guild_Create_Fail_Name_Empty = config.getString("Guild_Create_Fail_Name_Empty");
        Guild_Create_Fail_Name_Format_Error = config.getString("Guild_Create_Fail_Name_Format_Error");
        Guild_Create_Fail_Blance_Shortage = config.getString("Guild_Create_Fail_Blance_Shortage");
        Guild_Create_Fail_joined = config.getString("Guild_Create_Fail_joined");
        Guild_Create_Fail_Systeam_Error = config.getString("Guild_Create_Fail_Systeam_Error");
        Guild_Create_Success = config.getString("Guild_Create_Success");
        //公會邀請
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
        //公會加入
        Guild_Join_Accept = config.getString("Guild_Join_Accept");
        Guild_Join_Fail_Accept = config.getString("Guild_Join_Fail_Accept");
        Guild_Join_Fail_Cancel = config.getString("Guild_Join_Fail_Cancel");
        Guild_Join_Fail_Empty = config.getString("Guild_Join_Fail_Empty");
        Guild_Join_Fail_TimeOut = config.getString("Guild_Join_Fail_TimeOut");
        //公會離開
        Guild_Leave_Success = config.getString("Guild_Leave_Success");
        Guild_Leave_Message = config.getString("Guild_Leave_Message");
        Guild_Leave_Fail_No_Guild = config.getString("Guild_Leave_Fail_No_Guild");
    }

    public String replace(String target,String string,String string2) {
        return target.replace(string, string2);
    }
}
