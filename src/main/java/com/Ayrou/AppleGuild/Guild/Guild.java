package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuild;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

public class Guild implements IGuild {

    private String guildName;
    private double guildBlance;
    private int guildGrade;
    private double guildExp;
    private String leaderName;
    private UUID leaderUUID;
    private HashMap<UUID, Long> invitedPlayer;

    Guild(String guildName, UUID leaderUUID, double guildBlance, double guildExp, int guildGrade) {
        this.guildName = guildName;
        this.leaderUUID = leaderUUID;
        this.leaderName = Bukkit.getPlayer(leaderUUID).getName();
        this.guildBlance = guildBlance;
        this.guildGrade = guildGrade;
        this.guildExp = guildExp;
        this.invitedPlayer = new HashMap<>();
    }

    public void GuildCreate(String guildName, UUID leaderUUID) {
        this.guildName = guildName;
        this.leaderUUID = leaderUUID;
        this.leaderName = Bukkit.getPlayer(leaderUUID).getName();
        this.guildBlance = 0;
        this.guildGrade = 0;
        this.guildExp = 0;
        this.invitedPlayer = new HashMap<>();
    }

    /**
     * @return String GuildName
     */
    @Override
    public String getGuildName() {
        return guildName;
    }

    /**
     * @return UUID GuildLeaderUUID
     */
    @Override
    public UUID getGuildLeaderUUID() {
        return leaderUUID;
    }

    /**
     * @return String GuildLeaderName
     */
    @Override
    public String getGuildLeaderName() {
        return leaderName;
    }

    /**
     * @return double GuildBlance
     */
    @Override
    public double getGuildBlance() {
        return guildBlance;
    }

    /**
     * @return double GuildExp
     */
    @Override
    public double getGuildExp() {
        return guildExp;
    }

    /**
     * @return int GuildGrade
     */
    @Override
    public int getGuildGrade() {
        return guildGrade;
    }

    public void removeGuildData() {
        //TODO 完成移除公會資料
    }
}