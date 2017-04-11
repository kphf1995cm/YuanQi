package com.example.peng.yuanqi;

import java.util.ArrayList;

/**
 * Created by peng on 2017/4/9.
 */

public class FriendComMessageInfo {


    private String friendAccount;
    private ArrayList<String> talkContentList=new ArrayList<String>();
    private String lastComTime;

    public String getFriendAccount() {
        return friendAccount;
    }

    public void setFriendAccount(String friendAccount) {
        this.friendAccount = friendAccount;
    }

    public ArrayList<String> getTalkContentList() {
        return talkContentList;
    }

    public void addTalkContentList(String talkContent) {
        this.talkContentList.add(talkContent);
    }

    public String getLastComTime() {
        return lastComTime;
    }

    public void setLastComTime(String lastComTime) {
        this.lastComTime = lastComTime;
    }


}
