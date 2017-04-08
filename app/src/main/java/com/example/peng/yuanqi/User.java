package com.example.peng.yuanqi;

/**
 * Created by peng on 2017/4/5.
 */

import android.media.Image;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by CloudsRosy on 2017/4/5.
 */
public class User {
    private String account=null;
    private String name=null;
    private Image header=null;
    private String password=null;
    private HashSet<String> interset_list;
    private ArrayList<FriendInfo> friend_list;
    private ArrayList<DynamicContent> content_list;
    User()
    {
        interset_list=new HashSet<String>();
        friend_list=new ArrayList<FriendInfo>();
        content_list=new ArrayList<DynamicContent>();
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHeader(Image header) {
        this.header = header;
    }

    public Image getHeader() {
        return header;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public HashSet<String> getInterset_list() {
        return interset_list;
    }

    public void AddUserInterestList(String interest)
    {
        interset_list.add(interest);
    }

    public void DeleteUserInterestList(String interest)
    {
        interset_list.remove(interest);
    }

    public ArrayList<FriendInfo> getFriend_list() {
        return friend_list;
    }

    public void AddUserFriendList(FriendInfo friend)
    {
        friend_list.add(friend);
    }

    public void DeleteUserFriendListntent(String friend)
    {
        friend_list.remove(friend);
    }

    public ArrayList<DynamicContent> getContent_list() {
        return content_list;
    }

    public void AddUserContent(DynamicContent content)
    {
        content_list.add(content);
    }

}

