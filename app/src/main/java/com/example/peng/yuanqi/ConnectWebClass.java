package com.example.peng.yuanqi;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.preference.PreferenceActivity;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by peng on 2017/4/8.
 */

public  class ConnectWebClass implements LinkWeb {
    @Override
    public  int testUserAccountAndPassword(URL url, String account, String password)//测试下用户的账号和密码在数据库中是否存在，返回0，存在，返回1，账号不存在，返回2账号存在，但密码错误
    {
        return 0;
    }

    @Override
    public String getUserAccount(URL url) {
        return null;
    }

    @Override
    public String getUserName(URL url, String account) {
        return null;
    }

    @Override
    public void setUserName(URL url, String account, String name) {

    }

    @Override
    public boolean testAccountExist(URL url, String account) {
        return false;
    }

    @Override
    public Drawable getUserHeader(URL url, String account) {
        return null;
    }

    @Override
    public void setUserHeader(URL url, String account, Drawable header) {

    }

    @Override
    public String getUserPassword(URL url, String account) {
        return null;
    }

    @Override
    public String setUserPassword(URL url, String account, String password) {
        return null;
    }

    @Override
    public HashSet<String> getUserInterestList(URL url, String account) {
        return null;
    }

    @Override
    public void AddUserInterestList(URL url, String account, String interest) {

    }

    @Override
    public void setUserInterestList(URL url, String account, HashSet<String> interest_list) {

    }

    @Override
    public void DeleteUserInterestItem(URL url, String account, String interest) {

    }

    @Override
    public ArrayList<DynamicContent> getUserShowContent(URL url, String account) {
        return null;
    }

    @Override
    public ArrayList<DynamicContent> getUserSendContent(URL url, String account) {
        return null;
    }


    @Override
    public void AddUserContentList(URL url, String account, DynamicContent content) {

    }

    @Override
    public void DeleteUserContentItem(URL url, String account, DynamicContent content) {

    }

    @Override
    public void changeUserContentItem(URL url, String account, String send_time,String support_account) {//在用户发布的动态内容里面修改一项内容,增加点赞人的账号

    }

    @Override
    public ArrayList<FriendInfo> getUserFriendList(URL url, String account) {
        return null;
    }

    @Override
    public void AddUserFriendList(URL url, String account, FriendInfo friend_account) {

    }

    @Override
    public void DeleteUserFriendItem(URL url, String account, String friend_account) {

    }

    @Override
    public User getUserInfo(URL url, String account) {
        return null;
    }
}
