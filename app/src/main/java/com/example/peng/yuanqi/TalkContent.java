package com.example.peng.yuanqi;

/**
 * Created by peng on 2017/4/12.
 */

public class TalkContent {
    private String content=null;
    private String time=null;
    private int sendFlag;//发送者标识符 自己发送为1，朋友发送为2
    public TalkContent(){}

    public TalkContent(String content,String time,int sendFlag)
    {
        this.content=content;
        this.time=time;
        this.sendFlag=sendFlag;
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

    public int getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(int sendFlag) {
        this.sendFlag = sendFlag;
    }
}
