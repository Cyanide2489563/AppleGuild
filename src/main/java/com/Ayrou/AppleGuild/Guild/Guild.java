package com.Ayrou.AppleGuild.Guild;

import com.Ayrou.AppleGuild.API.IGuild;
import com.Ayrou.AppleGuild.Main;
import com.Ayrou.AppleGuild.Message.Message;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Guild implements IGuild {

    private Message message = Main.getMessage();
    private GuildManager guildManager = Main.getGuildManager();

    private String guildName;
    private double guildBlance;
    private int guildGrade;
    private int guildMemberLimited;
    private double guildExp;
    private String leaderName;
    private UUID leaderUUID;
    private HashMap<UUID, Long> invitedPlayer;
    private HashMap<UUID, GuildMember> members;
    private HashMap<UUID, Player> onlineMembers;

    public Guild() {

    }

    public Guild(String guildName, UUID leaderUUID, double guildBlance, double guildExp, int guildGrade) {
        this.guildName = guildName;
        this.leaderUUID = leaderUUID;
        this.leaderName = Objects.requireNonNull(Bukkit.getPlayer(leaderUUID)).getName();
        this.members = new HashMap<>();
        this.members.put(leaderUUID, new GuildMember(leaderUUID, leaderName, 4096));
        this.guildBlance = guildBlance;
        this.guildGrade = guildGrade;
        this.guildExp = guildExp;
        this.invitedPlayer = new HashMap<>();
        this.onlineMembers = new HashMap<>();
    }

    public void GuildCreate(String guildName, UUID leaderUUID) {
        this.guildName = guildName;
        this.leaderUUID = leaderUUID;
        this.leaderName = Objects.requireNonNull(Bukkit.getPlayer(leaderUUID)).getName();
        this.guildMemberLimited = 10;
        this.members = new HashMap<>();
        this.members.put(leaderUUID, new GuildMember(leaderUUID, leaderName, 4096));
        this.guildBlance = 0;
        this.guildGrade = 0;
        this.guildExp = 0;
        this.invitedPlayer = new HashMap<>();
        this.onlineMembers = new HashMap<>();
        this.onlineMembers.put(leaderUUID, Bukkit.getPlayer(leaderUUID));
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
        for (HashMap.Entry<UUID, Player> member : onlineMembers.entrySet()) {
            member.getValue().sendMessage(message);
        }
    }

    public static void sendConfirmMessage(UUID uuid, String message, String command, String command1) {
        TextComponent up = new TextComponent("§a============================§r\n");
        TextComponent text = new TextComponent(message + "\n");
        TextComponent text1 = new TextComponent("§2§n[接受]");
        text1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild " + command));
        text1.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(this.message.Affirmative).create()
        ));

        TextComponent space = new TextComponent("§r   ");

        TextComponent text2 = new TextComponent("§4§n[拒絕]\n");
        text2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild " + command1));
        text2.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(this.message.Negative).create()
        ));

        TextComponent down = new TextComponent("§a============================§r");
        up.addExtra(text);
        up.addExtra(text1);
        up.addExtra(space);
        up.addExtra(text2);
        up.addExtra(down);

        Objects.requireNonNull(Bukkit.getPlayer(uuid)).spigot().sendMessage(up);
    }

    public void addGuildOnlineMember(UUID member) {
        onlineMembers.put(member, Bukkit.getPlayer(member));
    }

    public void removeGuildOnlineMember(UUID member) {
        onlineMembers.remove(member);
    }

    void removeGuildData() {
        //TODO ????????
    }

    public void invite(UUID player) {
        Player player1 = Bukkit.getPlayer(player);
        if (player1 != null) {
            invitedPlayer.put(player, System.currentTimeMillis() + guildManager.getInviteTimeout());
            player1.sendMessage(message.replace(
                    message.Guild_Invite_Player_Message,"%GuildName%", guildName
            ));
        }
    }

    public void removeGuildMember(UUID player) {
        members.remove(player);
        onlineMembers.remove(player);
    }

    public boolean isMember(UUID uuid) {
        return members.containsKey(uuid);
    }

    public boolean isInvited(UUID uuid) {
        return invitedPlayer.containsKey(uuid);
    }

    private GuildMember getGuildMember(UUID uuid) {
        return members.get(uuid);
    }
}