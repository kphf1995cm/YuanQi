package com.example.peng.yuanqi;

/**
 * Created by peng on 2017/4/12.
 */

public class TalkContent {
    private String content=null;
    private String time=null;
    public TalkContent(){}

    public TalkContent(String content,String time)
    {
        this.content=content;
        this.time=time;
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
}
