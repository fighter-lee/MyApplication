package com.abupdate.nantest;

import android.os.Environment;
import android.util.Log;

import com.abupdate.common.Trace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * @author fighter_lee
 * @date 2019/12/11
 */
public class FileSerer extends NanoHTTPD {
    private static final String REQUEST_ROOT = "/";
    private List<SharedFile> fileList;
    private static final String TAG = "FileSerer";

    public FileSerer(List<SharedFile> sharedFiles) {
        super(8089);
        this.fileList = sharedFiles;
    }

    //当接受到连接时会调用此方法
    @Override
    public Response serve(IHTTPSession session) {
        Log.d(TAG, "serve: " + session.getUri());
        if (REQUEST_ROOT.equals(session.getUri()) || session.getUri().equals("")) {
            return responseRootPage(session);
        }
        return responseFile(session);
    }

    //对于请求根目录的，返回分享的文件列表
    public Response responseRootPage(IHTTPSession session) {
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPER html><html><body>");
        builder.append("<ol>");
        for (int i = 0, len = fileList.size(); i < len; i++) {
            File file = new File(fileList.get(i).getPath());
            if (file.exists()) {
                //文件及下载文件的链接，定义了一个文件类，这里使用getPath方法获得路径，使用getName方法获得文件名
                builder.append("<li> <a href=\"" + file.getPath() + "\">" + file.getName() + "</a></li>");
            }
        }
        builder.append("<li>分享文件数量：  " + fileList.size() + "</li>");
        builder.append("</ol>");
        builder.append("</body></html>\n");
        //回送应答
        return newFixedLengthResponse(String.valueOf(builder));
    }

    //对于请求文件的，返回下载的文件
    public Response responseFile(IHTTPSession session) {
        Map<String, String> headers = session.getHeaders();
        for (Map.Entry<String, String> stringStringEntry : headers.entrySet()) {
            Trace.d(TAG, "responseFile() key:" + stringStringEntry.getKey() + "  ,  value:" + stringStringEntry.getValue());
        }
        try {
            //uri：用于标示文件资源的字符串，这里即是文件路径
            String uri = session.getUri();
            headers.put("Content-Length", "" + new File(uri).length());
            //文件输入流
            FileInputStream fis = new FileInputStream(uri);
            // 返回OK，同时传送文件，为了安全这里应该再加一个处理，即判断这个文件是否是我们所分享的文件，避免客户端访问了其他个人文件
            return newFixedLengthResponse(Response.Status.OK, "application/octet-stream", fis, fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response404(session, null);
    }

    //页面不存在，或者文件不存在时
    public Response response404(IHTTPSession session, String url) {
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html><html>body>");
        builder.append("Sorry,Can't Found" + url + " !");
        builder.append("</body></html>\n");
        return newFixedLengthResponse(builder.toString());
    }

    @Override
    public Response serve(String uri, Method method,
                          Map<String, String> header, Map<String, String> parameters,
                          Map<String, String> files) {
        String answer = "";
        File file = new File(Environment.getExternalStorageDirectory() + "/iport_log.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newFixedLengthResponse(Response.Status.OK, "application/octet-stream", fis, file.length());
    }
}
