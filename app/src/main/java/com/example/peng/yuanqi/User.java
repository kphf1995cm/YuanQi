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
    private ArrayList<FriendInfo> friend_list;//朋友个人信息列表
    private ArrayList<DynamicContent> content_list;//用户要显示的动态内容
    private ArrayList<DynamicContent> send_content_list;//用户自己发布的动态内容
    //private ArrayList<MessageContent> friend_info_list;/
    private ArrayList<FriendComMessageInfo> friend_com_message_info_list;//朋友聊天记录列表
    User()
    {
        interset_list=new HashSet<String>();
        friend_list=new ArrayList<FriendInfo>();
        content_list=new ArrayList<DynamicContent>();
        send_content_list=new ArrayList<DynamicContent>();
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

    public ArrayList<DynamicContent> getSend_content_list() {
        return send_content_list;
    }

    public void addSend_content_list(DynamicContent send_content_list) {
        this.send_content_list.add(send_content_list);
    }
}

