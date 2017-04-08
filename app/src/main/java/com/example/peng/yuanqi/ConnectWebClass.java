package com.example.peng.yuanqi;

import android.media.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by peng on 2017/4/8.
 */

public abstract class ConnectWebClass implements LinkWeb {
    public  int testUserAccountAndPassword(URL url, String account, String password)//测试下用户的账号和密码在数据库中是否存在，返回0，存在，返回1，账号不存在，返回2账号存在，但密码错误
    {


        return 0;
    }
}
