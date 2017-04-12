package com.example.peng.yuanqi;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by peng on 2017/4/12.
 */

public class EditContentActivity extends AppCompatActivity {
    public Button send_dy_con=null;
    public EditText edit_content=null;
    public User euser=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.edit_dynamic_content);
        send_dy_con=(Button)findViewById(R.id.send_dy_con);
        edit_content=(EditText)findViewById(R.id.edit_content);
        send_dy_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                euser=MainActivity.loginUser;
                SimpleDateFormat simpleDateFormat= null;
                String date;
                /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                    date=simpleDateFormat.format(new java.util.Date());
                }
                else
                   date="API Lower";*/
                date=GetTime();
                DynamicContent dynamicContent=new DynamicContent();
                dynamicContent.setAccount(euser.getAccount());
                dynamicContent.setDynamicShowContent(euser.getName(),edit_content.getText().toString(),date,euser.getHeader());
                MainActivity.loginUser.addSend_content_list(dynamicContent);
                MainActivity.connectWebClass.AddUserContentList(MainActivity.serverUrl,euser.getAccount(),dynamicContent);//在当前用户里面增加一条发布动态内容
                finish();
            }
        });
    }
    public String GetTime()
    {

        Date date=new Date();
        java.text.SimpleDateFormat nowTime=new java.text.SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        String str=nowTime.format(date);
        return str;
    }
}
