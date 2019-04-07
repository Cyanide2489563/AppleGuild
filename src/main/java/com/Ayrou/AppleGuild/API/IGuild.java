package com.Ayrou.AppleGuild.API;

import java.util.UUID;

/** ???? */
public interface IGuild {

    String getGuildName();
    UUID getGuildLeaderUUID();
    String getGuildLeaderName();
    double getGuildBlance();
    double getGuildExp();
    int getGuildGrade();

    int getGuildMemberLimited();

    boolean isLeader(UUID uniqueId);

    int getGuildMemberSize();

    void sendGuildMessage(String message);
}