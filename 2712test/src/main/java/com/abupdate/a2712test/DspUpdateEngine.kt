package com.abupdate.a2712test

import android.os.SystemClock
import android.text.TextUtils
import android.util.Log

/**
 * @author fighter_lee
 * @date 2020/11/3
 */
object DspUpdateEngine {

    val TAG = "DspUpdateEngine"
    const val MSG_DSP_INIT = "51"
    const val MSG_GET_DSP_MODE = "3"
    const val MSG_DSP_INTO_BOOT_MODE = "0"
    const val MSG_INSTALL_DSP = "1"


    const val EXCEPTION_SOCKET_NOT_CONNECT = 101
    const val DSP_SOCKET_REPLY_DIVIDER = ","
    private var lock = Object()
    private var isInBootMode = false
    private var installCallback: DspInstallCallback? = null

    init {
        SocketUtils.getInstance().setListener(object : SocketUtils.ServerResponseCallBack {
            override fun onResponseMsg(responseMsg: String?) {
                handleMcuMsg(responseMsg)
            }

            override fun onStatus(statusType: Int) {

            }

        })
    }

    open fun isDspInBootMode(): Boolean {
        connectConfirm()

        SocketUtils.getInstance().sendMsgToServer(MSG_DSP_INIT)
        lock()
        SocketUtils.getInstance().sendMsgToServer(MSG_GET_DSP_MODE)
        lock()
        return isInBootMode
    }

    open fun installDsp(path: String, callback: DspInstallCallback) {
        connectConfirm()
        var dspImagePath = path
        if (!dspImagePath.startsWith("/")) {
            dspImagePath = "/${dspImagePath}"
        }
        if (!dspImagePath.endsWith("/")) {
            dspImagePath = "${dspImagePath}/"
        }
        installCallback = callback
        SocketUtils.getInstance().sendMsgToServer("${MSG_INSTALL_DSP}${dspImagePath}")
    }

    open fun intoBootMode(path: String) {
        connectConfirm()
        var dspImagePath = path
        if (!dspImagePath.startsWith("/")) {
            dspImagePath = "/${dspImagePath}"
        }
        if (!dspImagePath.endsWith("/")) {
            dspImagePath = "${dspImagePath}/"
        }
        SocketUtils.getInstance().sendMsgToServer("${MSG_DSP_INTO_BOOT_MODE}${dspImagePath}")
    }

    private fun handleMcuMsg(responseMsg: String?) {
        if (responseMsg == null || responseMsg == "") {
            return
        }

        val arr: Array<String> = responseMsg.split(DSP_SOCKET_REPLY_DIVIDER.toRegex()).toTypedArray()
        if (2 != arr.size) {
            return
        }
        when (arr[0].toInt()) {
            5 -> {
                unLock()
            }

            3 -> {
                if ("0" == arr[1]) {
                    isInBootMode = true
                } else if ("1" == arr[1]) {
                    isInBootMode = false
                }
            }

            2 -> {
                val updateProgress = arr[1].toInt()
                if (updateProgress > 100 || updateProgress < 0) {
                    return
                }
                installCallback?.onProgress(updateProgress)
            }

            1 -> {
                val result = arr[1].toInt()
                installCallback?.onResult(result)
            }

        }
    }

    fun connectConfirm() {
        if (!SocketUtils.getInstance().isSocketConnect) {
            SocketUtils.getInstance().startSocketThread()
        }
        var startTime = System.currentTimeMillis()
        while (!SocketUtils.getInstance().isSocketConnect) {
            SystemClock.sleep(200)
            if (System.currentTimeMillis() - startTime > 2000) {
                break
            }
        }
        if (!SocketUtils.getInstance().isSocketConnect) {
            throw Exception("socket connect fail")
        }
    }

    /**
     * 加锁
     */
    private fun lock() {
        synchronized(lock) {
            try {
                if (TextUtils.equals(Thread.currentThread().name, "main")) {
                    Log.e(TAG, "lock() The main thread can't block")
                    return
                }
                Log.d(TAG, "thread lock")
                lock.wait(2000)
            } catch (e: Exception) {
                Log.d(TAG, "lock exception:" + e.message)
            }
        }
    }

    /**
     * 解锁
     */
    private fun unLock() {
        synchronized(lock) {
            try {
                Log.d(TAG, "thread unlock")
                lock.notify()
            } catch (e: Exception) {
            }
        }
    }

    interface DspInstallCallback {
        fun onProgress(progress: Int)
        fun onResult(result: Int)
    }

}