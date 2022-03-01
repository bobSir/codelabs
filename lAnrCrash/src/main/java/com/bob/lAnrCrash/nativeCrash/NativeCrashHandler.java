package com.bob.lAnrCrash.nativeCrash;

import android.content.Context;

import com.bob.lAnrCrash.javaCrash.CrashHandler;

import java.io.File;

/**
 * created by cly on 2022/1/10
 */
public class NativeCrashHandler {

    static {
        System.loadLibrary("bugly");
    }

    public static void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        File file = new File(applicationContext.getExternalCacheDir(), "native_crash");
        if (!file.exists()) {
            file.mkdirs();
        }
        initNativeCrash(file.getAbsolutePath());
    }

    private static native void initNativeCrash(String path);

    public static native void testNativeCrash();

}
