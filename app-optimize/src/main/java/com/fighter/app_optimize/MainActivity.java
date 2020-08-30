package com.fighter.app_optimize;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Object o = new Object();
                    Log.d(TAG, "run: xxxxxxxxxxxx");
                }
            }
        }).start();

        Shape.setModel(5);

    }
}
