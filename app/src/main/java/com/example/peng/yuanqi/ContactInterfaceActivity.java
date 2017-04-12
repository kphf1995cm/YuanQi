package com.example.peng.yuanqi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ListView;

/**
 * Created by peng on 2017/4/11.
 */

public class ContactInterfaceActivity extends AppCompatActivity {

    public ListView listView;
    public

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contact_interface);

    }
}
