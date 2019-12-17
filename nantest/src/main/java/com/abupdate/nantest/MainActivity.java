package com.abupdate.nantest;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.abupdate.common.Trace;
import com.abupdate.common.UIThreadUtil;
import com.abupdate.common_download.DLManager;
import com.abupdate.common_download.DownConfig;
import com.abupdate.common_download.DownEntity;
import com.abupdate.common_download.listener.SimpleUIDownListener;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    StringBuilder builder;
    private TextView tvLogcat;
    private ScrollView scrollView;
    private long startTime;
    private long fileSize = 133602353;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new StringBuilder();
        tvLogcat = findViewById(R.id.tv_logcat1);
        scrollView = findViewById(R.id.scrollView);
        DownConfig.setSegmentDownload(false);
    }

    private void startPostFileServer() {
        StoreFileServer.startServer();
    }

    private void startFileDownServer() {
        List<SharedFile> sharedFiles = new ArrayList<>();
        SharedFile sharedFile1 = new SharedFile();
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/update.zip";
        sharedFile1.setPath(filePath);
        sharedFiles.add(sharedFile1);
        FileSerer serer = new FileSerer(sharedFiles);
        try {
            serer.start();
            print("server create success");
            print("IP:" + getLocalIpAddress(this));
            print("share file url: [http://" + (getLocalIpAddress(this) + ":8089") + filePath + "]");
            Log.d(TAG, "startFileDownServer: " + new File(filePath).length());
            print("file size:" + covertFileSizeDescription(new File(filePath).length()));
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
                .setFileSize(fileSize)
                .setUrl("http://172.18.7.175:8089/storage/emulated/0/update.zip");
        DLManager.getInstance().add(downEntity);
        DLManager.getInstance().execAsync(new SimpleUIDownListener() {
            @Override
            public void on_start() {
                super.on_start();
                startTime = System.currentTimeMillis();
                print("on start:" + getDateToString(startTime));
            }

            @Override
            public void on_finished(List<DownEntity> successDownEntities, List<DownEntity> failedDownEntities) {
                super.on_finished(successDownEntities, failedDownEntities);
                long currentTimeMillis = System.currentTimeMillis();
                print("on finish: " + getDateToString(currentTimeMillis));
                long allTime = (currentTimeMillis - startTime) / 1000;
                print("all time:" + (allTime) + "秒");
                print("average speed:" + ((fileSize+0.5f) / 1024 / 1024 / allTime) + " MB/s");
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

    /**
     * 获取当前ip地址
     *
     * @param context
     * @return
     */
    public static String getLocalIpAddress(Context context) {
        try {

            WifiManager wifiManager = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception ex) {
            return " 获取IP出错鸟!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();
        }
        // return null;
    }

    public static String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    public static String getDateToString(long milSecond) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);

    }

    /**
     * 文件大小转换
     *
     * @param size
     * @return
     */
    public static String covertFileSizeDescription(long size) {
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("###.0");
        if (size >= 1024 * 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("G");
        } else if (size >= 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0));
            bytes.append(format.format(i)).append("M");
        } else if (size >= 1024) {
            double i = (size / (1024.0));
            bytes.append(format.format(i)).append("KB");
        } else if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B");
            } else {
                bytes.append((int) size).append("B");
            }
        }
        return bytes.toString();
    }

}
