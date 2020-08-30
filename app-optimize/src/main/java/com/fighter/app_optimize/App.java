package com.fighter.app_optimize;

import android.app.Application;
import android.os.Debug;
import android.os.SystemClock;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Debug.startMethodTracing("/sdcard/trace");
        SystemClock.sleep(3000);
//        aaa();
        Debug.stopMethodTracing();
    }

    private void aaa() {
        int count = 0;
        while (true){
            count ++;
            if (count >= 1000){
                break;
            }
            SystemClock.sleep(10);
        }
    }
}
