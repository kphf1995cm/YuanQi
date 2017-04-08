package com.example.peng.yuanqi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
    public ArrayList<DynamicContent> dc_list=new ArrayList<DynamicContent>();
    public LayoutInflater layoutInflater;
    public MyAdapter myAdapter;
    public Button supportButton;
    public ConnectWebClass connectWebClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        user=MainActivity.loginUser;//获得用户信息
        getUserInfoFromServer();
        dc_list=user.getContent_list();
        listView=(ListView)findViewById(R.id.dc_content_list_view);
        layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);

    }
    private void getUserInfoFromServer()//从服务器端获得用户信息
    {
        user=connectWebClass.getUserInfo(MainActivity.serverUrl,MainActivity.loginUser.getAccount());
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
            DynamicContent tempcontact=dc_list.get(position);
            convertView=null;
            if(convertView==null)
            {
               // if(tempcontact.getSign()==1){convertView=layoutinflater.inflate(R.layout.machine,parent,false);}
               // else if(tempcontact.getSign()==2){convertView=layoutinflater.inflate(R.layout.person,parent,false);}
                convertView=layoutInflater.inflate(R.layout.dynamic_content,parent,false);
              //  TextView tv=(TextView) convertView.findViewById(R.id.tv);
               // TextView tvtime=(TextView) convertView.findViewById(R.id.tvtime);
               // tv.setText(tempcontact.getWord());
              //  tvtime.setText(tempcontact.getTime());
            }
            return convertView;
        }
    }

}
