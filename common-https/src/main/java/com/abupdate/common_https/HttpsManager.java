package com.abupdate.common_https;

/**
 * @author fighter_lee
 * @date 2019/10/11
 */
public class HttpsManager {

    private static HttpsManager mInstance;

    public static HttpsManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpsManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpsManager();
                }
            }
        }
        return mInstance;
    }

}
