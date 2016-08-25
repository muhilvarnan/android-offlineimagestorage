package com.offlinestorage;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by root on 25/8/16.
 */
public class FileCache {

    private File cacheDir;

    public FileCache(Context context) {

        if((Environment
                .getExternalStorageState()).equals(Environment.MEDIA_MOUNTED)) {
            cacheDir = new File(Environment.getExternalStorageDirectory(), "fcImages");
        } else {
            cacheDir = context.getCacheDir();
        }
        if(!cacheDir.mkdirs()) {
            cacheDir.mkdirs();
        }
    }

    public File getFile(String url) {
        String filename = String.valueOf(url.hashCode());

        File f = new File(cacheDir, filename);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("file", f.getName());
        return f;
    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if(files == null) {
            return;
        }

        for(File f : files) {
            f.delete();
        }
    }
}
