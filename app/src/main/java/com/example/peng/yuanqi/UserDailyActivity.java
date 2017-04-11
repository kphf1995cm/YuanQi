package com.example.peng.yuanqi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by peng on 2017/3/14.
 */

public class UserDailyActivity extends AppCompatActivity {
    //public URL serverUrl;
    public User user;
    public ListView listView;
    public ArrayList<DynamicContent> dc_list;
    public LayoutInflater layoutInflater;
    public MyAdapter myAdapter;
    public ConnectWebClass connectWebClass=new ConnectWebClass();
    public Button friend,setting;
   // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        user=MainActivity.loginUser;//获得用户信息
        getUserInfoFromServer();
        //DynamicContent tpdc=new DynamicContent();
        //tpdc.setDynamicShowContent("new","hello","2017",null);
        //user.AddUserContent(tpdc);
        dc_list=user.getContent_list();
        listView=(ListView)findViewById(R.id.dc_content_list_view);
       // message=(Button) findViewById(R.id.main_message);
        friend=(Button)findViewById(R.id.main_friend);
        setting=(Button)findViewById(R.id.main_setting);
        layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);

        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDailyActivity.this,UserMessgeActivity.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDailyActivity.this,UserSettingActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getUserInfoFromServer()//从服务器端获得用户信息
    {
        //user=connectWebClass.getUserInfo(MainActivity.serverUrl,MainActivity.loginUser.getAccount());
    }
    public class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return dc_list.size();
        }

        @Override
        public Object getItem(int i) {
            return dc_list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final DynamicContent tempcontact=dc_list.get(position);
            Log.d(tempcontact.getName(),tempcontact.getTime());
            convertView=null;
            if(convertView==null)
            {
               // if(tempcontact.getSign()==1){convertView=layoutinflater.inflate(R.layout.machine,parent,false);}
               // else if(tempcontact.getSign()==2){convertView=layoutinflater.inflate(R.layout.person,parent,false);}
                convertView=layoutInflater.inflate(R.layout.dynamic_content,parent,false);
                Button praiseButton=(Button)convertView.findViewById(R.id.praise_person);
                ImageView friendHeader=(ImageView)convertView.findViewById(R.id.friend_header);
                TextView friendName=(TextView)convertView.findViewById(R.id.friend_name);
                TextView friendSendTime=(TextView)convertView.findViewById(R.id.friend_send_time);
                TextView friendSendText=(TextView)convertView.findViewById(R.id.friend_send_text);
                friendHeader.setImageDrawable(tempcontact.getHeader());
                friendName.setText(tempcontact.getName());
                friendSendTime.setText(tempcontact.getTime());
                friendSendText.setText(tempcontact.getContent());
              //  TextView tv=(TextView) convertView.findViewById(R.id.tv);\\
               // TextView tvtime=(TextView) convertView.findViewById(R.id.tvtime);
               // tv.setText(tempcontact.getWord());
              //  tvtime.setText(tempcontact.getTime());
                praiseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        connectWebClass.changeUserContentItem(MainActivity.serverUrl,tempcontact.getAccount(),tempcontact.getTime(),user.getAccount());
                        //点赞时需要将自己加入到对方发布动态内容praisePerson中
                    }
                });
            }
            return convertView;
        }
    }
}
