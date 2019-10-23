package com.abupdate.common_mqtt;

/**
 * @author fighter_lee
 * @date 2019/10/23
 */
public class MqttManager {

    private static MqttManager mInstance;

    public static MqttManager getInstance() {
        if (mInstance == null) {
            synchronized (MqttManager.class) {
                if (mInstance == null) {
                    mInstance = new MqttManager();
                }
            }
        }
        return mInstance;
    }

}
