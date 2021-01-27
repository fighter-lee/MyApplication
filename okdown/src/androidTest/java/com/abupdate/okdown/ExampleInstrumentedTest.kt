package com.abupdate.okdown

import android.util.Base64
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.util.regex.Pattern
import java.util.zip.DataFormatException
import java.util.zip.Deflater
import java.util.zip.Inflater

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.abupdate.okdown", appContext.packageName)
    }

    @Test
    fun testGzip() {
        val json = "{\n" +
                "        \"sender\": \"upclientOtaApp\",\n" +
                "        \"msgName\": \"getContextRsp\",\n" +
                "        \"msgInd\": \"1605772938921\",\n" +
                "        \"msgBody\": {\n" +
                "            \"contextType\": 1,\n" +
                "            \"versionInfo\": {\n" +
                "                \"ecuVersionInfos\": [\n" +
                "                    {\n" +
                "                        \"ecuDid\": \"0X731\",\n" +
                "                        \"ecuSwid\": \"TBox\",\n" +
                "                        \"ecuName\": \"JL_TBOX\",\n" +
                "                        \"dstVersionName\": \"TBBB1B01\",\n" +
                "                        \"fileBytes\": 992778,\n" +
                "                        \"ecuTimeConsuming\": 600\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"releaseNote\": \"请酌情下载~fghfgh\",\n" +
                "                \"upgradeNote\": \"请酌情改装升级~hfgh\",\n" +
                "                \"disclaimer\": \"免责声明fghfghgf\",\n" +
                "                \"strategyTimeConsuming\": 0,\n" +
                "                \"languageFileUrl\": \"https://vsms.abupdate.com/download/strategy/test/language/3a0754874d0347539b511c900eb2296c.xml\"\n" +
                "            },\n" +
                "            \"result\": 0\n" +
                "        }\n" +
                "    }"


        println("json:$json")
        println("大小：${json?.toByteArray()?.size}")

        val replaceSpecialStr = replaceSpecialStr(json)
        println("replaceSpecialStr:$replaceSpecialStr")
        println("大小：${replaceSpecialStr?.toByteArray()?.size}")

//        val compress = Gzip.compress(replaceSpecialStr)
        val compress = zipString(replaceSpecialStr)
        println("compress:$compress")
        println("大小：${compress?.toByteArray()?.size}")

//        val unCompress = Gzip.unCompress(compress)
        val unCompress = unzipString(compress)
        println("unCompress:$unCompress")
        println("大小：${unCompress?.toByteArray()?.size}")
    }

    /**
     * 去除字符串中的空格、回车、换行符、制表符等
     *
     * @param str
     * @return
     */
    fun replaceSpecialStr(str: String?): String? {
        var repl = ""
        if (str != null) {
            val p = Pattern.compile("\\s*|\t|\r|\n")
            val m = p.matcher(str)
            repl = m.replaceAll("")
        }
        return repl.trim { it <= ' ' }
    }

    fun zipString(unzip: String?): String? {
        val deflater = Deflater(9) // 0 ~ 9 压缩等级 低到高
        deflater.setInput(unzip?.toByteArray())
        deflater.finish()
        val bytes = ByteArray(256)
        val outputStream = ByteArrayOutputStream(256)
        while (!deflater.finished()) {
            val length: Int = deflater.deflate(bytes)
            outputStream.write(bytes, 0, length)
        }
        deflater.end()
        return String(Base64.encode(outputStream.toByteArray(), Base64.DEFAULT))
    }

// 解压缩

    // 解压缩
    fun unzipString(zip: String?): String? {
        val decode: ByteArray = Base64.decode(zip,Base64.DEFAULT)
        val inflater = Inflater()
        inflater.setInput(decode)
        val bytes = ByteArray(256)
        val outputStream = ByteArrayOutputStream(256)
        try {
            while (!inflater.finished()) {
                val length: Int = inflater.inflate(bytes)
                outputStream.write(bytes, 0, length)
            }
        } catch (e: DataFormatException) {
            e.printStackTrace()
            return null
        } finally {
            inflater.end()
        }
        return outputStream.toString()
    }
}