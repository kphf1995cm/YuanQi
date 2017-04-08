package com.example.peng.yuanqi;

import java.util.ArrayList;

/**
 * Created by peng on 2017/4/4.
 */

public class DynamicContent {
    public String account=null;
    public String name=null;
    public ArrayList<String> content;
    public int likePersonNum=0;
    public ArrayList<String> likePersonAccount;
    DynamicContent(){
        content=new ArrayList<String>();
        likePersonAccount=new ArrayList<String>();
    }
}
