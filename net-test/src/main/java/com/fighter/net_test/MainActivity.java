package com.fighter.net_test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_name);
    }

    public void click_test(View view) {

        String networkState = NetUtils.getNetworkState(this);
        textView.setText("网络类型：" + networkState);
    }
}
