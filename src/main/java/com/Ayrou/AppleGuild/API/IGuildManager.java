package com.Ayrou.AppleGuild.API;

import com.Ayrou.AppleGuild.Guild.Guild;

import java.util.ArrayList;

public interface IGuildManager {
    //TODO 取得所有公會物件函式
    ArrayList<Guild> getGuildList();
    int getGuildQuantity();
}
