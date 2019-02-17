package com.Ayrou.AppleGuild.API;

import java.util.UUID;

public interface IGuild {
    String getGuildName();
    UUID getGuildLeader();
    double getGuildBlance();
    double getGuildExp();
    int getGuildGrade();

    //TODO 補足公會API
}
