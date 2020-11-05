package com.abupdate.a2712test;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.power.CarPowerManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.abup.gear.OTACallback;
import com.abup.gear.ResultCallback;
import com.abup.gear.abup_CarState;
import com.abup.gear.onServiceConnectListener;
import com.yfvet.fota.FotaImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private com.abup.gear.fota fota;
    private Car mCar;
    private CarPowerManager mCarPowerManager;

    private static final String VIP_SOCKET_START_COMMAND = "0";     //Start command.
    private static final String VIP_SOCKET_HANDSHAKE_COMMAND = "1"; //Handshake.
    private static final String VIP_SOCKET_WORK_MODE_COMMAND = "2";      //Get check command.
    private static final String VIP_SOCKET_CONFIRM_COMMAND = "20";
    private static final String VIP_SOCKET_REPLY_DIVIDER = ",";
    private static final String VIP_SOCKET_SERVER_IP = "localhost";
    private static final int VIP_SOCKET_SERVER_PORT = 7777;//7000;
    private static final int VIP_SOCKET_TIMEOUT = 2000;
    private boolean mHandShakeFlag = false;
    private Socket mSocketClient;
    private BufferedWriter mBufferedWriter;
    private InputStreamReader mInputStreamReader;
    private boolean mSocketReadFlag = true;
    private static final int COPY_SIZE = 1024;
    private BufferedReader mBufferReader;

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

        Log.d(TAG, "onCreate: " + FotaImpl.class.getSimpleName());

        fota = FotaImpl.Create(this, new onServiceConnectListener() {
            @Override
            public void onServiceConnect(int i) {
                print("yfveApi.fota create success?" + i);
            }
        });
        mCar = Car.createCar(this, mServiceConnection);
        mCar.connect();

    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            print("Car Service connect");
            onCarServerConnect();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };

    private void onCarServerConnect() {
        try {
            if (mCar != null) {
                mCarPowerManager = (CarPowerManager) mCar.getCarManager(Car.POWER_SERVICE);
                print("CarPowerManager init");
            }
            if (mCarPowerManager == null) {
                print("mCarPowerManager==null ");
            }
        } catch (CarNotConnectedException e) {
            print("carImpl can not connect android car service");
        }
    }

    public void click_test1(View view) {
        //        fota.getIHyAgent().getEcuInfo(new ResultCallback<abup_AECU>() {
        //            @Override
        //            public void onFinished(abup_AECU abup_aecu) {
        //                print("getEcuInfo: " + abup_aecu.toString());
        //            }
        //
        //            @Override
        //            public void onFailed(int i) {
        //                print("getEcuInfo onFailed: " + i);
        //            }
        //        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!DspUpdateEngine.INSTANCE.isDspInBootMode()) {
                    DspUpdateEngine.INSTANCE.intoBootMode("/fota/package/dsp");
                } else {
                    DspUpdateEngine.INSTANCE.installDsp("/fota/package/dsp", new DspUpdateEngine.DspInstallCallback() {
                        @Override
                        public void onProgress(int progress) {
                            Log.d(TAG, "onProgress: " + progress);
                        }

                        @Override
                        public void onResult(int result) {
                            Log.d(TAG, "onResult: " + result);
                        }
                    });
                }
            }
        }).start();



    }

    public void click_test2(View view) {
        fota.getIHyAgent().getCarStateData(new ResultCallback<abup_CarState>() {
            @Override
            public void onFinished(abup_CarState abup_carState) {
                print("getCarStateData: " + abup_carState);
            }

            @Override
            public void onFailed(int i) {
                print("getCarStateData onFailed: " + i);
            }
        });

    }

    public void click_test3(View view) {
        File file = new File(getFilesDir().getAbsolutePath() + "/mt2712_saic_ep21-ota-192.zip");
        Log.d(TAG, "click_test3: " + file.exists());
        fota.getIUpgrade().ecuInstallPackage(0X7A8, 1111, file.getAbsolutePath(), "V1", new OTACallback() {
            @Override
            public void onUpgradeProgress(int i, int i1) {
                print("ecuInstallPackage onUpgradeProgress: " + i + "," + i1);
            }

            @Override
            public void onUpgradeFinished(int i, int i1) {
                print("ecuInstallPackage onUpgradeFinished: " + i + "," + i1);
            }
        });
    }

    public void click_test4(View view) {
        //        sendCommandToMcu("3", null, true);
        SocketUtils.getInstance().sendMsgToServer("3");
    }

    public void click_test5(View view) {
        //        sendCommandToMcu("0", "/sdcard/ota", false);
        SocketUtils.getInstance().sendMsgToServer("0/sdcard/ota/");
    }

    public void click_test6(View view) {
        //        sendCommandToMcu("1", "/sdcard/ota", false);
        SocketUtils.getInstance().sendMsgToServer("1/sdcard/ota/");
    }

    private void sendCommandToMcu(final String command, final String path, final boolean getWorkMode) {
        print("startUpgrade: command = " + command + " path = " + path);
        new Thread() {
            @Override
            public void run() {
                try {
                    if (command.equals(VIP_SOCKET_HANDSHAKE_COMMAND)) {
                        mHandShakeFlag = true;
                    } else {
                        mHandShakeFlag = false;
                    }
                    mSocketClient = new Socket(VIP_SOCKET_SERVER_IP, VIP_SOCKET_SERVER_PORT);
                    if (getWorkMode) {
                        mSocketClient.setSoTimeout(VIP_SOCKET_TIMEOUT);
                    }
                    OutputStreamWriter writer = new OutputStreamWriter(mSocketClient.getOutputStream());
                    mBufferedWriter = new BufferedWriter(writer);
                    if (path != null) {
                        String comm = command + path + "/";
                        print("command data length:" + comm.length());
                        mBufferedWriter.write(comm);
                    } else {
                        print("command data length:" + command.length());
                        mBufferedWriter.write(command);
                    }
                    mBufferedWriter.flush();

                    Log.d(TAG, "run: Read start");
                    InputStream inputStream = mSocketClient.getInputStream();
                    mInputStreamReader = new InputStreamReader(inputStream);
                    //                    BufferedReader bufferedReader = new BufferedReader(mInputStreamReader);
                    while (mSocketReadFlag) {
                        char[] input = new char[COPY_SIZE];
                        print("run: before read data. ");
                        int length = mInputStreamReader.read(input);
                        //                        int length = bufferedReader.read(input);
                        if (length > 0) {
                            String inputFromMcu = new String(input, 0, length);
                            Log.d(TAG, "run: data = " + inputFromMcu);
                            handleDspData(inputFromMcu);
                        }
                    }

                    print("run: read finish.");

                    mInputStreamReader.close();
                    inputStream.close();
                    mBufferedWriter.close();
                    writer.close();
                    mSocketClient.close();
                    resetSocket();

                } catch (IOException e) {
                    resetSocket();
                    print("run: sendCommand exception." + e.getMessage());
                }
                super.run();
            }
        }.start();
    }

    private void handleDspData(String str) {
        if (str == null || str.equals("")) {
            return;
        }

        String[] arr = str.split(VIP_SOCKET_REPLY_DIVIDER);
        print("handleDspData()  socket data arr==" + Arrays.toString(arr));
        if (2 != arr.length) {
            print("handleDspData()  Error  arr.length==" + arr.length);
            return;
        }
        switch (Integer.parseInt(arr[0])) {
            case 0://Define.KEY_UPDATE_STATUS:
                break;

            case 2://Define.KEY_UPDATE_PROGRESS:
                int updateProgress = Integer.parseInt(arr[1]);
                if (updateProgress <= 100) {
                    print("handleDspData: Update progress = " + updateProgress);
                }
                break;

            case 1://Define.KEY_UPDATE_RESULT:
                mSocketReadFlag = false;
                print("handleDspData: update result = " + arr[1]);
                break;

            case 3:
                if ("0".equals(arr[1])) {
                    if (!mHandShakeFlag) {
                        mSocketReadFlag = false;
                    }
                    print("dsp: work mode update.");
                } else if ("1".equals(arr[1])) {
                    mSocketReadFlag = false;
                    print("dsp: work mode normal.");
                }
                break;
            case 5:
                if ("0".equals(arr[1])) {
                    mSocketReadFlag = false;
                    print("handleDspData: dsp init complete");
                }
                break;
        }
    }

    private void resetSocket() {
        mSocketReadFlag = false;
        mBufferedWriter = null;
        mBufferReader = null;
        try {
            if (mSocketClient != null) {
                mSocketClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mSocketClient = null;
    }

    private void print(final String message) {
        Log.d(TAG, "print() " + message);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                builder.append(message)
                        .append("\r\n");
                tvLogcat.setText(builder.toString());
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    public void click_test7(View view) {
        SocketUtils.getInstance().sendMsgToServer("51");
        //        sendCommandToMcu("51", null, true);
    }
}
