package com.abupdate.nantest;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.abupdate.common.Trace;
import com.abupdate.common.UIThreadUtil;
import com.abupdate.common_download.DLManager;
import com.abupdate.common_download.DownEntity;
import com.abupdate.common_download.listener.SimpleUIDownListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    StringBuilder builder;
    private TextView tvLogcat;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new StringBuilder();
        tvLogcat = findViewById(R.id.tv_logcat1);
        scrollView = findViewById(R.id.scrollView);
    }

    private void startPostFileServer() {
        StoreFileServer.startServer();
    }

    private void startFileDownServer() {
        List<SharedFile> sharedFiles = new ArrayList<>();
        SharedFile sharedFile1 = new SharedFile();
        sharedFile1.setPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/iport_log.txt");
        sharedFiles.add(sharedFile1);
        FileSerer serer = new FileSerer(sharedFiles);
        try {
            serer.start();
            print("server create success");
        } catch (IOException e) {
            e.printStackTrace();
            print("server create fail:" + e.getMessage());
        }
    }

    public void click_start(View view) {
        startFileDownServer();
    }

    public void click_download_file(View view) {
        print("start download");
        DownEntity downEntity = new DownEntity().setFilePath(getFilesDir().getAbsolutePath() + "/update.zip")
                .setUrl("http://172.18.7.80:8089/storage/emulated/0/iport_log.txt");
        DLManager.getInstance().add(downEntity);
        DLManager.getInstance().execAsync(new SimpleUIDownListener() {
            @Override
            public void on_start() {
                super.on_start();
                print("on start");
            }

            @Override
            public void on_finished(List<DownEntity> successDownEntities, List<DownEntity> failedDownEntities) {
                super.on_finished(successDownEntities, failedDownEntities);
                print("on finish");
            }

            @Override
            public void on_success(DownEntity downEntity) {
                super.on_success(downEntity);
                print("on success");
            }

            @Override
            public void on_failed(DownEntity errDownEntity) {
                super.on_failed(errDownEntity);
                print("on fail");
            }

            @Override
            public void on_manual_cancel() {
                super.on_manual_cancel();
                print("on cancel");
            }

            @Override
            public void on_all_progress(int progress, long down_size, long total_size) {
                super.on_all_progress(progress, down_size, total_size);
                print("progress:" + progress);
            }

        });
    }

    private void print(final String message) {
        Trace.d(TAG, "print() " + message);
        UIThreadUtil.postUI(new Runnable() {
            @Override
            public void run() {
                builder.append(message)
                        .append("\r\n");
                tvLogcat.setText(builder.toString());
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}
