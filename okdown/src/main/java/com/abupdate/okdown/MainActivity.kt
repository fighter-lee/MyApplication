package com.abupdate.okdown

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.abupdate.okdown.DownloadUtil.OnDownloadListener
import com.abupdate.okdown.DownloadUtil.OnUploadListener
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.File
import java.io.IOException
import java.lang.Exception
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var builder: StringBuilder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        builder = StringBuilder()
    }

    fun click_download(view: View) {
        val url = "http://172.18.7.210:8000/test.html"
//        val url = "https://akamaicdn.webex.com/client/webexapp.msi"
        val path = externalCacheDir?.absolutePath + "/package"
        print("开始下载")
        print("url:$url")
        print("path:$path")
        try {
            DownloadUtil.get().download(url, path, object : OnDownloadListener {
                override fun onDownloadSuccess() {
                    //成功
                    print("下载完成")
                    print("开始校验md5")
                    verifyMd5()
                }

                override fun onDownloading(progress: Int) {
                    //进度
                    print("下载进度：$progress")
                }

                override fun onDownloadFailed(e: Exception) {
                    //失败
                    print("下载失败:${e.message}")
                }
            })
        } catch (e: Exception) {
            print(e.message)
        }

    }

    private fun print(message: String) {
        runOnUiThread {
            builder?.append(message)
                    ?.append("\r\n")
            tv_logcat.text = builder.toString()
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
        }
    }

    fun verifyMd5() {
        val path = externalCacheDir?.absolutePath + "/package"
        val listFiles = File(path).listFiles()
        if (listFiles.size > 1) {
            print("该路径下存在多个文件，请先删除")
            return
        }
        if (listFiles.isEmpty()) {
            print("该路径下文件不存在。")
            return
        }
        thread {
            val md5ByFile = DownloadUtil.getMd5ByFile(listFiles[0])
            print("md5:$md5ByFile")
            if (md5ByFile == "6f5902ac237024bdd0c176cb93063dc4") {
                print("校验成功")
            } else {
                print("校验失败")
            }
        }
    }


    // 使用OkHttp上传文件
    fun uploadFile(file: File?) {
        val url = "http://172.18.7.210:8000/"
        print("开始上传文件")
        print("url:$url")
        print("path:${file?.absolutePath}")

        try {
            val client = OkHttpClient()
            val contentType: MediaType? = MediaType.parse("application/octet-stream") // 上传文件的Content-Type
            val body = RequestBody.create(contentType, file!!) // 上传文件的请求体
            val request = Request.Builder()
                    .url(url) // 上传地址
                    .post(body)
                    .build()
            val call = client.newCall(request)
            call.enqueue(object : Callback {
                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    // 文件上传成功
                    if (response.isSuccessful) {
                        print("上传成功")
                    } else {
                        print("上传失败：${response.code()}")
                    }
                }

                override fun onFailure(call: Call, e: IOException) {
                    // 文件上传失败
                    Log.e("download", "onFailure: ", e)
                    print("上传失败：${e.message}")
                }
            })
        } catch (e: Exception) {
            print(e.message)
        }
    }

    fun click_upload(view: View) {
        val path = externalCacheDir?.absolutePath + "/package"
        val listFiles = File(path).listFiles()
        if (listFiles.size > 1) {
            print("该路径下存在多个文件，请先删除")
            return
        }
        if (listFiles.isEmpty()) {
            print("该路径下文件不存在。")
            return
        }
        uploadFile(listFiles[0])
    }

}
