package com.example.peng.yuanqi;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.ArrayList;

/**
 * Created by peng on 2017/4/4.
 */

public class DynamicContent {
    private String account;
    private String name;
    private String content;
    private String time;
    private Drawable header;

    private ArrayList<String> praisePersonAccount=new ArrayList<String>();

    public void setDynamicShowContent(String name,String content,String time,Drawable header)
    {
        this.name=name;
        this.content=content;
        this.time=time;
        this.header=header;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Drawable getHeader() {
        return header;
    }

    public void setHeader(Drawable header) {
        this.header = header;
    }

    public ArrayList<String> getPraisePersonAccount() {
        return praisePersonAccount;
    }

    public void addPraisePersonItem(String praisePersonAccount) {
        this.praisePersonAccount.add(praisePersonAccount);
    }
}
