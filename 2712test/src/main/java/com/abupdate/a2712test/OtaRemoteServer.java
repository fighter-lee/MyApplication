package com.abupdate.a2712test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;

import com.abupdate.lib_ota_adapter.IAECUCallback;
import com.abupdate.lib_ota_adapter.ICarInfoCallback;
import com.abupdate.lib_ota_adapter.ICarStateCallback;
import com.abupdate.lib_ota_adapter.IInstallCallback;
import com.abupdate.lib_ota_adapter.IOtaRemoteService;


/**
 * @author fighter_lee
 * @date 2020/7/13
 */
public class OtaRemoteServer extends Service {
    private static final String TAG = "OtaRemoteServer";

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    IOtaRemoteService.Stub stub = new IOtaRemoteService.Stub() {

        @Override
        public void getEcuInfo(String s, String s1, IAECUCallback iaecuCallback) throws RemoteException {

        }

        @Override
        public void getCarInfo(ICarInfoCallback iCarInfoCallback) throws RemoteException {

        }

        @Override
        public void getCarState(ICarStateCallback iCarStateCallback) throws RemoteException {

        }

        @Override
        public void installPackage(String s, String s1, String s2, String s3, IInstallCallback iInstallCallback) throws RemoteException {
            for (int i = 0; i <= 100; i += 5) {
                SystemClock.sleep(500);
                iInstallCallback.onInstallProgress(s, s1, i);
                if (i >= 100) {
                    SystemClock.sleep(1000);
                    iInstallCallback.onInstallFinished(s, s1, 0);
                }
            }
        }
    };
}
