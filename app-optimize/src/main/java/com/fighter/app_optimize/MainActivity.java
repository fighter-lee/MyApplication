package com.fighter.app_optimize;

import android.os.Bundle;
import android.os.Debug;
import android.os.SystemClock;
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

                SystemClock.sleep(20000);
                Debug.startMethodTracing("/sdcard/trace");

                Log.d(TAG, "run: start");
                fun1();
                SystemClock.sleep(20000);
                fun2();

                Debug.stopMethodTracing();
            }
        }).start();

    }

    private void fun1() {
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s = s + i;
        }
        Log.d(TAG, "run: " + s);
    }

    private void fun2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
        Log.d(TAG, "run: " + sb.toString());
    }

    private void fun3() {
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb1.append(i);
        }
        Log.d(TAG, "run: " + sb1.toString());
    }
}
