package com.abupdate.common_download;

/**
 * @author fighter_lee
 * @date 2019/10/11
 */
public class DownloadManager {

    private static DownloadManager mInstance;

    public static DownloadManager getInstance() {
        if (mInstance == null) {
            synchronized (DownloadManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadManager();
                }
            }
        }
        return mInstance;
    }

}
