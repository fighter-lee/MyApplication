package com.raise.jni;

/**
 * @author fighter_lee
 * @date 2020/11/19
 */
public class JniTools {

    public JniTools() {
    }

    public static native int verifyAbupdateData(String var0, int var1, String var2, int var3);

    static {
        System.loadLibrary("abupdate_sn");
    }

}
