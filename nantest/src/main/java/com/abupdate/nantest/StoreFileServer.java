package com.abupdate.nantest;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fighter_lee
 * @date 2019/12/11
 */
public class StoreFileServer extends TempFileNanoService {

    private static final String TAG = "FileServer";

    private static class ExampleManager implements TempFileManager {

        private final File tmpdir;

        private final List<TempFile> tempFiles;

        private ExampleManager() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Log.d(TAG, "ExampleManager: " + absolutePath);
            this.tmpdir = new File(absolutePath);
            this.tempFiles = new ArrayList<TempFile>();
        }

        @Override
        public void clear() {
            Log.d(TAG, "clear: ");
            if (!this.tempFiles.isEmpty()) {
                System.out.println("Cleaning up:");
            }
            for (TempFile file : this.tempFiles) {
                try {
                    System.out.println("   " + file.getName());
                    file.delete();
                } catch (Exception ignored) {
                }
            }
            this.tempFiles.clear();
        }

        @Override
        public TempFile createTempFile(String filename_hint) throws Exception {
            Log.d(TAG, "createTempFile: " + filename_hint);
            DefaultTempFile tempFile = new DefaultTempFile(this.tmpdir);
            this.tempFiles.add(tempFile);
            System.out.println("Created tempFile: " + tempFile.getName());
            return tempFile;
        }
    }

    private static class ExampleManagerFactory implements TempFileManagerFactory {

        @Override
        public TempFileManager create() {
            Log.d(TAG, "create: ");
            return new ExampleManager();
        }
    }

    public static void startServer() {
        StoreFileServer server = new StoreFileServer();
        server.setTempFileManagerFactory(new ExampleManagerFactory());
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //        ServerRunner.executeInstance(server);
    }

}
