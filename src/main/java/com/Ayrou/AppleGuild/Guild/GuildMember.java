package com.Ayrou.AppleGuild.Guild;

import java.util.UUID;

public class GuildMember {
    private UUID memberUUID;
    private String memberName;
    private Role memberRole;

    public UUID getUniqueId() {
        return memberUUID;
    }

    public String getMemberName() {
        return memberName;
    }

    public Role getMemberRole() {
        return memberRole;
    }
}

class Role {
    private int role;
    private boolean changeDiplomatic;//????
    private boolean changeName;//??????
    private boolean disband;//????
    private boolean upgrade;//????
    private boolean changeRole;//??????
    private boolean announce;//????
    private boolean reviewPlayer;//????
    private boolean invitePlayer;//????
    private boolean kickPlayer;//????
    private boolean manageGroup;//?????
    private boolean guildHall;//??????
    private boolean guildFeaturesTree;//???????

    public Role(int role) {
        this.role = role;
        changeDiplomatic = ((int) Math.pow(2,0) & role) == (int) Math.pow(2,0);
        changeName = ((int) Math.pow(2,1) & role) == (int) Math.pow(2,1);
        disband = ((int) Math.pow(2,2) & role) == (int) Math.pow(2,2);
        upgrade = ((int) Math.pow(2,3) & role) == (int) Math.pow(2,3);
        changeRole = ((int) Math.pow(2,4) & role) == (int) Math.pow(2,4);
        announce = ((int) Math.pow(2,5) & role) == (int) Math.pow(2,5);
        reviewPlayer = ((int) Math.pow(2,6) & role) == (int) Math.pow(2,6);
        invitePlayer = ((int) Math.pow(2,7) & role) == (int) Math.pow(2,7);
        kickPlayer = ((int) Math.pow(2,8) & role) == (int) Math.pow(2,8);
        manageGroup = ((int) Math.pow(2,9) & role) == (int) Math.pow(2,9);
        guildHall = ((int) Math.pow(2,10) & role) == (int) Math.pow(2,10);
        guildFeaturesTree = ((int) Math.pow(2,11) & role) == (int) Math.pow(2,11);
    }
}