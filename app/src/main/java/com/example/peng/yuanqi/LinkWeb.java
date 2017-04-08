package com.example.peng.yuanqi;

import android.media.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by peng on 2017/4/7.
 */

public interface LinkWeb {

    public  int testUserAccountAndPassword(URL url, String account, String password);//测试下用户的账号和密码在数据库中是否存在，返回0，存在，返回1，账号不存在，返回2账号存在，但密码错误
    public String getUserAccount(URL url);//获取一个未被使用的用户账号

    public String getUserName(URL url,String account);//获取用户昵称
    public void setUserName(URL url,String account,String name);//设置用户昵称


    public Image getUserHeader(URL url,String account); //获取用户头像
    public void setUserHeader(URL url,String account,Image header); //设置用户头像



    public String getUserPassword(URL url,String account); //获取用户密码
    public String setUserPassword(URL url,String account,String password); //设置用户密码



    public HashSet<String> getUserInterestList(URL url, String account);//获取用户兴趣列表
    public void AddUserInterestList(URL url,String account,String interest);//在用户兴趣列表里面增加一项内容
    public void DeleteUserInterestItem(URL url,String account,String interest);//在用户兴趣列表里面删除一项内容



    public ArrayList<DynamicContent> getUserContent(URL url,String account); //获取用户发布的动态内容列表
    public void AddUserContentList(URL url,String account,DynamicContent content);//用户发布的动态内容里面增加一项内容
    public void DeleteUserContentItem(URL url,String account,DynamicContent content);//在用户发布的动态内容里面删除一项内容



    public HashSet<String> getUserFriendList(URL url,String account); //获取用户朋友列表
    public void AddUserFriendList(URL url,String account,String friend_account);//用户的朋友列表里面增加一项内容
    public void DeleteUserFriendItem(URL url,String account,String friend_account);//在用户的朋友列表里面删除一项内容

}
