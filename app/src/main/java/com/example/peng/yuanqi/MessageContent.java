package com.example.peng.yuanqi;

import android.graphics.drawable.Drawable;

/**
 * Created by peng on 2017/4/9.
 */

public class MessageContent {
    private Drawable friendHeader;
    private String friendAccount;
    private String friendName;
    private String friendLastComTime;
    public void setThreeInfo(Drawable friendHeader,String friendName,String friendLastComTime)
    {
        this.friendHeader=friendHeader;
        this.friendName=friendName;
        this.friendLastComTime=friendLastComTime;
    }
    public void setAllInfo(String friendAccount,Drawable friendHeader,String friendName,String friendLastComTime)
    {
        this.friendAccount=friendAccount;
        this.friendHeader=friendHeader;
        this.friendName=friendName;
        this.friendLastComTime=friendLastComTime;
    }

    public Drawable getFriendHeader() {
        return friendHeader;
    }

    public void setFriendHeader(Drawable friendHeader) {
        this.friendHeader = friendHeader;
    }

    public String getFriendAccount() {
        return friendAccount;
    }

    public void setFriendAccount(String friendAccount) {
        this.friendAccount = friendAccount;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendLastComTime() {
        return friendLastComTime;
    }

    public void setFriendLastComTime(String friendLastComTime) {
        this.friendLastComTime = friendLastComTime;
    }
}
