package com.abupdate.a2712test;


import android.util.Log;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketUtils {
    private static final int SOCKET_INIT_SUCCESS = 1;
    private static final int SOCKET_CONNECT_ERROR = 2;
    private static final int SOCKET_SEND_MSG_TIMEOUT_ERROR = 3;

    public final String TAG = getClass().getSimpleName();
    private boolean mSocketConnect = false;
    public static SocketUtils mInstance = null;
    private ReadWriteThread mReadWriteThread = null;
    private ServerResponseCallBack mServerResponseCallBack = null;

    public static SocketUtils getInstance() {
        if (null == mInstance) {
            mInstance = new SocketUtils();
        }
        return mInstance;
    }

    public SocketUtils() {
    }

    public void startSocketThread() {
        if (null == mReadWriteThread) {
            mReadWriteThread = new ReadWriteThread();
        }
        mReadWriteThread.start();
    }

    public void stopSocketThread() {
        mReadWriteThread.setInputStreamRead(false);
        mReadWriteThread.closeScoket();
        mReadWriteThread = null;
    }

    public void sendMsgToServer(String strMsgToServer) {
        try {
            mReadWriteThread.setValueToServer(strMsgToServer);
        } catch (Exception e) {
        }
    }

    public boolean isSocketConnect() {
        return mSocketConnect;
    }

    public void setListener(ServerResponseCallBack serverResponseCallBack) {
        mServerResponseCallBack = serverResponseCallBack;
    }

    public interface ServerResponseCallBack {

        void onResponseMsg(String responseMsg);

        void onStatus(int statusType);

    }


    public class ReadWriteThread extends Thread {
        private final int PORT = 7777;
        private final String HOST = "localhost";

        private boolean mbInputStreamRead = true;
        private Socket mSocket = null;
        private BufferedWriter mBufferedWriter = null;
        private InputStreamReader mInputStreamReader = null;
        private String mstrMsgToServer = "";

        public ReadWriteThread() {
        }

        @Override
        public void run() {
            super.run();
            Log.d(TAG, "run()+++");
            initScoket();
            Log.d(TAG, "run()---");
        }

        public void initScoket() {
            try {
                mSocket = new Socket(HOST, PORT);
                mBufferedWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
                mInputStreamReader = new InputStreamReader(mSocket.getInputStream());

                Log.d(TAG, "initScoket() SOCKET INIT SUCCESS ");
                mServerResponseCallBack.onStatus(SOCKET_INIT_SUCCESS);
                mSocketConnect = true;
                while (mbInputStreamRead) {
                    char[] cha = new char[512];
                    int len = mInputStreamReader.read(cha);
                    String strFromMcuMsg = new String(cha, 0, len);
                    Log.d(TAG, "initScoket() strFromMcuMsg===" + strFromMcuMsg);
                    mServerResponseCallBack.onResponseMsg(strFromMcuMsg);
                }
                mSocketConnect = false;
                closeScoket();

            } catch (Exception e) {
                mSocketConnect = false;
                mServerResponseCallBack.onStatus(SOCKET_CONNECT_ERROR);
                Log.e(TAG, "initScoket()  Exception==" + e.toString());
                closeScoket();
            }
        }

        public void closeScoket() {

            try {
                mbInputStreamRead = false;
                if (null != mInputStreamReader) {
                    mInputStreamReader.close();
                    mInputStreamReader = null;
                }
                if (null != mBufferedWriter) {
                    mBufferedWriter.close();
                    mBufferedWriter = null;
                }
                if (null != mSocket) {
                    mSocket.close();
                    mSocket = null;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        public void setInputStreamRead(boolean mbInputStreamRead) {
            this.mbInputStreamRead = mbInputStreamRead;
        }

        public void setValueToServer(String strMsgToServer) {
            mstrMsgToServer = strMsgToServer;
            if (!mSocketConnect) {
                Log.e(TAG, "setValueToServer()  socket disconnect mSocketConnect==" + mSocketConnect);
                return;
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "setValueToServer(1)  mBufferedWriter==null ? " + (null == mBufferedWriter));
                        int count = 0;
                        while (null == mBufferedWriter) {
                            sleep(500);
                            Log.d(TAG, "while count==" + count);

                            if (null != mBufferedWriter) {
                                break;
                            }
                            count++;
                            if (10 < count) {
                                mSocketConnect = false;
                                mServerResponseCallBack.onStatus(SOCKET_SEND_MSG_TIMEOUT_ERROR);
                                return;
                            }

                        }
                        Log.d(TAG, "setValueToServer(2)  mstrMsgToServer== " + mstrMsgToServer + "  mBufferedWriter==" + mBufferedWriter);

                        mBufferedWriter.write(mstrMsgToServer);
                        mBufferedWriter.flush();

                    } catch (Exception e) {
                        Log.e(TAG, "setValueToServer()  Exception== " + e.toString());
                        mServerResponseCallBack.onStatus(SOCKET_SEND_MSG_TIMEOUT_ERROR);
                        closeScoket();
                    }
                }
            }).start();
        }
    }

}
