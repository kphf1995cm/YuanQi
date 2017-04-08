package com.example.peng.yuanqi;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by peng on 2017/4/4.
 */

public class DynamicContent {
    public String account=null;
    public String name=null;
    public String content;
    public String time=null;
    public Image header=null;
    public int likePersonNum=0;
    public ArrayList<String> likePersonAccount;
    DynamicContent(){
        likePersonAccount=new ArrayList<String>();
    }
}
