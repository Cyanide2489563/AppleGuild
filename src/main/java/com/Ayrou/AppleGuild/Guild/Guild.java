package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuild;
import com.Ayrou.AppleGuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Guild implements IGuild {

    private GuildManager guildManager = Main.getGuildManager();

    private String guildName;
    private double guildBlance;
    private int guildGrade;
    private int guildMemberLimited;
    private double guildExp;
    private String leaderName;
    private UUID leaderUUID;
    private HashMap<UUID, Long> invitedPlayer;
    private ArrayList<GuildMember> members;
    private ArrayList<Player> onlineMembers;

    public Guild() {

    }

    public Guild(String guildName, UUID leaderUUID, double guildBlance, double guildExp, int guildGrade) {
        this.guildName = guildName;
        this.leaderUUID = leaderUUID;
        this.leaderName = Bukkit.getPlayer(leaderUUID).getName();
        this.members = new ArrayList<>();
        this.members.add(new GuildMember(leaderUUID, leaderName, 4096));
        this.guildBlance = guildBlance;
        this.guildGrade = guildGrade;
        this.guildExp = guildExp;
        this.invitedPlayer = new HashMap<>();
    }

    public void GuildCreate(String guildName, UUID leaderUUID) {
        this.guildName = guildName;
        this.leaderUUID = leaderUUID;
        this.leaderName = Bukkit.getPlayer(leaderUUID).getName();
        this.guildMemberLimited = 10;
        this.members = new ArrayList<>();
        this.members.add(new GuildMember(leaderUUID, leaderName, 4096));
        this.guildBlance = 0;
        this.guildGrade = 0;
        this.guildExp = 0;
        this.invitedPlayer = new HashMap<>();
        addGuildOnlineMember(Bukkit.getPlayer(leaderUUID));
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

    @Override
    public int getGuildMemberLimited() {
        return guildMemberLimited;
    }

    @Override
    public boolean isLeader(UUID uniqueId) {
        return uniqueId.equals(leaderUUID);
    }

    @Override
    public int getGuildMemberSize() {
        return members.size();
    }

    @Override
    public void sendGuildMessage(String message) {
        for (Player member : onlineMembers) {
            member.sendMessage(message);
        }
    }

    @Override
    public void addGuildOnlineMember(Player member) {
        onlineMembers.add(member);
    }

    @Override
    public void removeGuildOnlineMember(Player member) {
        onlineMembers.remove(member);
    }

    void removeGuildData() {
        //TODO ????????
    }

    private void invite(Player player) {
        GuildMember member = getGuildMember(player.getUniqueId());
        if (!members.contains(member) && !invitedPlayer.containsKey(player.getUniqueId())) {
            invitedPlayer.put(player.getUniqueId(), System.currentTimeMillis() + guildManager.getInviteTimeout());
        }
    }

    boolean isMember(UUID uuid) {
        for (GuildMember member : members) {
            if (member.getUniqueId().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInvited(UUID uuid) {
        return invitedPlayer.containsKey(uuid);
    }

    private GuildMember getGuildMember(UUID uuid) {
        return members.stream().filter(m -> m.getUniqueId().equals(uuid)).findFirst().orElse(null);
    }
}