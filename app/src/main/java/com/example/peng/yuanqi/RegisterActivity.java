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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by peng on 2017/3/14.
 */

public class RegisterActivity extends AppCompatActivity {

    URL serverUrl = MainActivity.serverUrl;
    ImageView userHeader;
    private final String IMAGE_TYPE = "image/*";
    private final int IMAGE_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                if (isTheNameExist(userName.getText().toString(), serverUrl)) {
                    Toast.makeText(RegisterActivity.this, "该昵称已被使用", Toast.LENGTH_LONG).show();
                } else {
                    if (isPasswordSame(userInputPassword.getText().toString(), userConfirmPassword.getText().toString()) == false) {
                        Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_LONG).show();
                    } else {
                        importUserAccountPassInfo(userName.getText().toString(), userInputPassword.getText().toString(), serverUrl);
                        Intent intent = new Intent(RegisterActivity.this, UserInfoCompleteActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    //判断账号是否存在，调数据库
    private boolean isTheNameExist(String string, URL url) {
        return false;
    }

    ;

    private boolean isPasswordSame(String str1, String str2) {
        return str1.compareTo(str2) == 0;
    }

    //将用户账号及密码导入数据库
    private void importUserAccountPassInfo(String account, String password, URL url) {
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
