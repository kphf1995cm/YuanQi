package com.example.peng.yuanqi;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by peng on 2017/4/8.
 */

public class FriendInfo {

    private String account=null;
    private String name=null;
    private String lastComTime=null;
    private Drawable Header=null;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getHeader() {
        return Header;
    }

    public void setHeader(Drawable header) {
        Header = header;
    }

    public String getLastComTime() {
        return lastComTime;
    }

    public void setLastComTime(String lastComTime) {
        this.lastComTime = lastComTime;
    }

}
