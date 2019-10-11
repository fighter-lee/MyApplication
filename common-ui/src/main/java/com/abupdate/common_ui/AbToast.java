package com.abupdate.common_ui;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Toast;

import com.abupdate.common.CommonVal;
import com.abupdate.common.ThreadUtil;

/**
 * Created by raise.yang on 19/09/04.
 */
public class AbToast {

    private static Toast m_toast;

    public static void show(@NonNull final String content) {
        if (m_toast != null) {
            m_toast.cancel();
        }
    }

    public static void show(@StringRes int resId) {
    }

    public static void show(@NonNull final View view) {
    }
}
