package com.example.peng.yuanqi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

/**
 * Created by peng on 2017/3/14.
 */

public class RegisterActivity extends AppCompatActivity {

    URL serverUrl = MainActivity.serverUrl;
    ImageView userHeader;
    private final String IMAGE_TYPE = "image/*";
    private final int IMAGE_CODE = 0;
    public ConnectWebClass connectWebClass=new ConnectWebClass();
    public HashSet<String> interest_list=new HashSet<String>();
    public HashMap<Integer,Integer> interestIdClickCount=new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.user_register);
        final EditText userName = (EditText) findViewById(R.id.user_name);
        final EditText userInputPassword = (EditText) findViewById(R.id.user_input_password);
        final EditText userConfirmPassword = (EditText) findViewById(R.id.user_confirm_password);
        userHeader = (ImageView) findViewById(R.id.user_header);
        userHeader.setOnClickListener(listener);

        Button nextStep = (Button) findViewById(R.id.next_step);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (isTheNameExist(userName.getText().toString(), serverUrl)) {
               //     Toast.makeText(RegisterActivity.this, "该昵称已被使用", Toast.LENGTH_LONG).show();
               // } else {
                if (isPasswordSame(userInputPassword.getText().toString(), userConfirmPassword.getText().toString()) == false) {
                    Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_LONG).show();
                } else {
                    final String userAccount=connectWebClass.getUserAccount(serverUrl);//从服务器端获取一个从未使用的账号
                    //importUserInfo(userAccount,userName.getText().toString(), userInputPassword.getText().toString(), serverUrl);
                    //将用户昵称，头像，密码存数据库
                    connectWebClass.setUserPassword(serverUrl,userAccount,userInputPassword.getText().toString());
                    connectWebClass.setUserName(serverUrl,userAccount,userInputPassword.getText().toString());
                    connectWebClass.setUserHeader(serverUrl,userAccount,userHeader.getDrawable());
                    setContentView(R.layout.user_improve_information);
                    final Button interest1,interest2,interest3;
                    Button interest4,interest5,interest6;
                    Button interest7,interest8,interest9;
                    Button interest10,interest11,interest12;
                    Button submit,definition;
                    interest1=(Button)findViewById(R.id.interest_1);
                    interest2=(Button)findViewById(R.id.interest_2);
                    interest3=(Button)findViewById(R.id.interest_3);
                    interest4=(Button)findViewById(R.id.interest_4);
                    interest5=(Button)findViewById(R.id.interest_5);
                    interest6=(Button)findViewById(R.id.interest_6);
                    interest7=(Button)findViewById(R.id.interest_7);
                    interest8=(Button)findViewById(R.id.interest_8);
                    interest9=(Button)findViewById(R.id.interest_9);
                    interest10=(Button)findViewById(R.id.interest_10);
                    interest11=(Button)findViewById(R.id.interest_11);
                    interest12=(Button)findViewById(R.id.interest_12);
                    submit=(Button)findViewById(R.id.submit);
                    definition=(Button)findViewById(R.id.user_self_def);
                    interest1.setOnClickListener(new MyClickListener());
                    interest2.setOnClickListener(new MyClickListener());
                    interest3.setOnClickListener(new MyClickListener());
                    interest4.setOnClickListener(new MyClickListener());
                    interest5.setOnClickListener(new MyClickListener());
                    interest6.setOnClickListener(new MyClickListener());
                    interest7.setOnClickListener(new MyClickListener());
                    interest8.setOnClickListener(new MyClickListener());
                    interest9.setOnClickListener(new MyClickListener());
                    interest10.setOnClickListener(new MyClickListener());
                    interest11.setOnClickListener(new MyClickListener());
                    interest12.setOnClickListener(new MyClickListener());
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            for(String tmp:interest_list)
                            {
                                Log.d(tmp,tmp);
                                //System.out.print(tmp);

                            }
                            connectWebClass.setUserInterestList(serverUrl,userAccount,interest_list);//设置用户兴趣列表
                           // Intent intent=new Intent();//注册完了之后回到用户登陆界面，进入MainActivity Onresume函数
                           // intent.setAction(Intent.ACTION_MAIN);
                           // intent.addCategory(Intent.CATEGORY_LAUNCHER);
                           // startActivity(intent);
                            finish();
                        }
                    });
                    definition.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //用户自定义兴趣点
                        }
                    });

                }
               // }
            }
        });
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view)
        {
            Button b=(Button)findViewById(view.getId());
            if (interestIdClickCount.containsKey(view.getId()) == false) {
                interestIdClickCount.put(view.getId(), 1);
                interest_list.add(b.getText().toString());
                b.setBackgroundColor(BLUE);
            } else {
                if (interestIdClickCount.get(view.getId()) % 2 == 0) {
                    interestIdClickCount.put(view.getId(), interestIdClickCount.get(view.getId()) + 1);
                    interest_list.add(b.getText().toString());
                    b.setBackgroundColor(BLUE);
                } else {
                    interest_list.remove(b.getText().toString());
                    interestIdClickCount.put(view.getId(), interestIdClickCount.get(view.getId()) + 1);
                    b.setBackgroundColor(GRAY);
                }
            }
        }
    }

    private boolean isPasswordSame(String str1, String str2) {
        return str1.compareTo(str2) == 0;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ImageView imageView = (ImageView) view;
            switch (imageView.getId()) {
                case R.id.user_header:
                    setImage();
                    break;
            }
        }

        private void setImage() {
            Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
            getAlbum.setType(IMAGE_TYPE);
            startActivityForResult(getAlbum, IMAGE_CODE);
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量

            Log.e("TAG->onresult", "ActivityResult resultCode error");

            return;

        }
        Bitmap bm = null;


        //外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口

        ContentResolver resolver = getContentResolver();


        //此处的用于判断接收的Activity是不是你想要的那个

        if (requestCode == IMAGE_CODE) {

            try {

                Uri originalUri = data.getData();        //获得图片的uri


                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                //显得到bitmap图片
                //bm.setHeight(20);
                //bm.setWidth(20);
                userHeader.setImageBitmap(bm);//怎样固定所获得的图片尺寸
                //ViewGroup.MarginLayoutParams headerWidthHeight=new ViewGroup.MarginLayoutParams(userHeader.getLayoutParams());
                //headerWidthHeight.setMargins(0,0,0,0);
                //ActionBar.LayoutParams layoutParams=new ActionBar.LayoutParams(headerWidthHeight);
                //layoutParams.height=200;
                //layoutParams.width=200;
               // userHeader.setLayoutParams(layoutParams);
                saveHeader(bm);


            } catch (IOException e) {
                Log.e("TAG-->Error", e.toString());
            }
        }
    }

    private void saveHeader(Bitmap bitmap)//将头像存储在本地
    {

    }
}
