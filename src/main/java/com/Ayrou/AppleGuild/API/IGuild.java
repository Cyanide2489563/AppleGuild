package com.Ayrou.AppleGuild.API;

import java.util.UUID;

/** 公會界面 */
public interface IGuild {

    String getGuildName();
    UUID getGuildLeaderUUID();
    String getGuildLeaderName();
    double getGuildBlance();
    double getGuildExp();
    int getGuildGrade();

    //TODO 補足公會API
}