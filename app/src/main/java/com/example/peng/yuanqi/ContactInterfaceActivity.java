package com.example.peng.yuanqi;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by peng on 2017/4/11.
 */

public class ContactInterfaceActivity extends AppCompatActivity {

    public ListView listView;
    public ArrayList<TalkContent> talkContents;
    public Button send;
    public EditText edit;
    public LayoutInflater layoutInflater;
    public Drawable friendHeader=null;//朋友头像
    public Drawable userHeader=null;//自己头像
    public MyAdapter myAdapter;
   // public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contact_interface);
        MainActivity.loginUser.getTalkContentListMap();
        talkContents=MainActivity.loginUser.getTalkContentList(MainActivity.curContactPersonAccount);
        userHeader=MainActivity.loginUser.getHeader();
        friendHeader=MainActivity.connectWebClass.getUserHeader(MainActivity.serverUrl,MainActivity.curContactPersonAccount);
        if(talkContents==null)
            talkContents=new ArrayList<TalkContent>();
        talkContents.add(new TalkContent("Hello",GetTime(),1));
        talkContents.add(new TalkContent("Hi",GetTime(),2));
        talkContents.add(new TalkContent("How are you?",GetTime(),1));
        talkContents.add(new TalkContent("Are you people?",GetTime(),1));
        talkContents.add(new TalkContent("No,but I like people.",GetTime(),2));
        listView=(ListView)findViewById(R.id.contact_listview);
        send=(Button)findViewById(R.id.contact_send);
        edit=(EditText) findViewById(R.id.contact_edit);
        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setSelection(listView.getBottom());
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=edit.getText().toString();
                edit.setText("");
                Log.d("用户点击输出：",s1);
                String s2=s1.replace(" ","");
                String s3=s2.replace("\n","");
                TalkContent tempContent=new TalkContent(s3,GetTime(),1);
                talkContents.add(tempContent);
                myAdapter.notifyDataSetChanged();
                listView.setSelection(listView.getBottom());

            }
        });
    }

    @Override
    protected void onStop()//当退出当前会话时，需要保存当前聊天内容
    {
        MainActivity.loginUser.addTalkContentList(MainActivity.curContactPersonAccount,talkContents);
        MainActivity.loginUser.saveTalkContentListMap();
    }

    public class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return talkContents.size();
        }

        @Override
        public Object getItem(int i) {
            return talkContents.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TalkContent tempcontact=talkContents.get(position);
            convertView=null;
            if(convertView==null)
            {
                if(tempcontact.getSendFlag()==1){convertView=layoutInflater.inflate(R.layout.right_person,parent,false);}
                else if(tempcontact.getSendFlag()==2){convertView=layoutInflater.inflate(R.layout.left_person,parent,false);}
                TextView tv=(TextView) convertView.findViewById(R.id.tv);
                TextView tvtime=(TextView) convertView.findViewById(R.id.tvtime);
                ImageView header=(ImageView)convertView.findViewById(R.id.header);
                tv.setText(tempcontact.getContent());
                tvtime.setText(tempcontact.getTime());
                if(tempcontact.getSendFlag()==1)
                    header.setImageDrawable(userHeader);
                else
                    header.setImageDrawable(friendHeader);
            }
            return convertView;
        }
    }

    public String GetTime()
    {
        Date date=new Date();
        SimpleDateFormat nowTime=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String str=nowTime.format(date);
        return str;
    }
}
