package com.abupdate.a2712test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.abup.gear.OTACallback;
import com.abup.gear.ResultCallback;
import com.abup.gear.abup_AECU;
import com.abup.gear.abup_CarState;
import com.abup.gear.onServiceConnectListener;
import com.yfvet.fota.FotaImpl;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private com.abup.gear.fota fota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + FotaImpl.class.getSimpleName());

        fota = FotaImpl.Create(this, new onServiceConnectListener() {
            @Override
            public void onServiceConnect(int i) {
                Log.d(TAG, "onServiceConnect: success?" + i);
            }
        });

    }

    public void click_test1(View view) {
        fota.getIHyAgent().getEcuInfo(new ResultCallback<abup_AECU>() {
            @Override
            public void onFinished(abup_AECU abup_aecu) {
                Log.d(TAG, "onFinished: " + abup_aecu.toString());
            }

            @Override
            public void onFailed(int i) {
                Log.d(TAG, "onFailed: " + i);
            }
        });


    }

    public void click_test2(View view) {
        fota.getIHyAgent().getCarStateData(new ResultCallback<abup_CarState>() {
            @Override
            public void onFinished(abup_CarState abup_carState) {
                Log.d(TAG, "onFinished: " + abup_carState);
            }

            @Override
            public void onFailed(int i) {
                Log.d(TAG, "onFailed: " + i);
            }
        });
    }

    public void click_test3(View view) {
        File file = new File(getFilesDir().getAbsolutePath() + "/mt2712_saic_ep21-ota-192.zip");
        Log.d(TAG, "click_test3: " + file.exists());
        fota.getIUpgrade().ecuInstallPackage(0X7A8, 1111, file.getAbsolutePath(), "V1", new OTACallback() {
            @Override
            public void onUpgradeProgress(int i, int i1) {
                Log.d(TAG, "onUpgradeProgress: " + i + "," + i1);
            }

            @Override
            public void onUpgradeFinished(int i, int i1) {
                Log.d(TAG, "onUpgradeFinished: " + i + "," + i1);
            }
        });
    }
}
