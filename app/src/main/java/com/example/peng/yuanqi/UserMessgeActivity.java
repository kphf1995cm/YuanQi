package com.example.peng.yuanqi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
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
    public ArrayList<FriendInfo> messageContentList=new ArrayList<FriendInfo>();
    public LayoutInflater layoutInflater;
    public FriendAdapter friendAdapter;
    public Button message,setting;
    public Button addFriend;
    public User muser=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.user_message);
        messageList=(ListView)findViewById(R.id.message_content_list_view);
        message=(Button)findViewById(R.id.user_message);
        setting=(Button)findViewById(R.id.user_setting);
        addFriend=(Button)findViewById(R.id.add_friend);
        layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        muser=MainActivity.loginUser;
        friendAdapter=new FriendAdapter();
        FriendInfo tfi=new FriendInfo();
        tfi.setAllInfo(muser.getAccount(),"Bob","3-19",null);
        messageContentList.add(tfi);
        FriendInfo ttfi=new FriendInfo();
        ttfi.setAllInfo(muser.getAccount(),"www","4-19",null);
        messageContentList.add(ttfi);
        FriendInfo tttfi=new FriendInfo();
        tttfi.setAllInfo(muser.getAccount(),"bbb","1-19",null);
        messageContentList.add(tttfi);
        messageList.setAdapter(friendAdapter);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMessgeActivity.this,UserDailyActivity.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMessgeActivity.this,UserSettingActivity.class);
                startActivity(intent);
            }
        });
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加一个朋友账号
            }
        });
    }

    public class FriendAdapter extends BaseAdapter
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
            final FriendInfo tempcontact=messageContentList.get(position);
            convertView=null;
            if(convertView==null)
            {
               convertView=layoutInflater.inflate(R.layout.message_content,parent,false);
                ImageView friendHeader=(ImageView) convertView.findViewById(R.id.m_friend_header);
                TextView friendName=(TextView) convertView.findViewById(R.id.m_friend_name);
                TextView friendTime=(TextView) convertView.findViewById(R.id.m_friend_time);
                LinearLayout friendItem=(LinearLayout)convertView.findViewById(R.id.m_friend_item);
                friendHeader.setImageDrawable(tempcontact.getHeader());
                friendName.setText(tempcontact.getName());
                friendTime.setText(tempcontact.getLastComTime());
                friendItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        MainActivity.curContactPersonAccount=tempcontact.getName();//先用getName测试
                        //MainActivity.curContactPersonAccount=tempcontact.getAccount();//保存当前聊天人的账号
                        Intent intent=new Intent(UserMessgeActivity.this,ContactInterfaceActivity.class);
                        startActivity(intent);

                    }
                });
            }
            return convertView;
        }
    }
}
