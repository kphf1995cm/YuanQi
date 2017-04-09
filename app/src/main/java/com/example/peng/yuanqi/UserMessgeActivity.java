package com.example.peng.yuanqi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by peng on 2017/4/8.
 */

//用户查看消息活动
public class UserMessgeActivity extends AppCompatActivity {
    public ListView messageList;
    public ArrayList<MessageContent> messageContentList=new ArrayList<MessageContent>();
    public LayoutInflater layoutInflater;
    public MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_message);
        messageList=(ListView)findViewById(R.id.message_content_list_view);
        layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myAdapter=new MyAdapter();
        messageList.setAdapter(myAdapter);
    }

    public class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return messageContentList.size();
        }

        @Override
        public Object getItem(int i) {
            return messageContentList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MessageContent tempcontact=messageContentList.get(position);
            convertView=null;
            if(convertView==null)
            {
               convertView=layoutInflater.inflate(R.layout.message_content,parent,false);
                ImageView friendHeader=(ImageView) convertView.findViewById(R.id.m_friend_header);
                TextView friendName=(TextView) convertView.findViewById(R.id.m_friend_name);
                TextView friendTime=(TextView) convertView.findViewById(R.id.m_friend_time);
                LinearLayout friendItem=(LinearLayout)convertView.findViewById(R.id.m_friend_item);
                friendHeader.setImageDrawable(tempcontact.getFriendHeader());
                friendName.setText(tempcontact.getFriendName());
                friendTime.setText(tempcontact.getFriendLastComTime());
                friendItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
            return convertView;
        }
    }
}
