package com.bob.lAnrCrash.anr;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/**
 * created by cly on 2022/1/8
 */
public class ANRWatchDog extends Thread {
    private static final String TAG = "ANR";
    private int timeout = 5000;
    private boolean ignoreDebugger = true;

    static ANRWatchDog sWatchdog;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private ANRWatchDog() {
        super("ANR-WatchDog-Thread");
    }

    private class ANRChecker implements Runnable {

        private boolean mCompleted;
        private long mStartTime;
        private long executeTime = SystemClock.uptimeMillis();

        @Override
        public void run() {
            synchronized (ANRWatchDog.this) {
                mCompleted = true;
                executeTime = SystemClock.uptimeMillis();
            }
        }

        void schedule() {
            mCompleted = false;
            mStartTime = SystemClock.uptimeMillis();
            mainHandler.postAtFrontOfQueue(this);
        }

        boolean isBlocked() {
            return !mCompleted || executeTime - mStartTime >= 5000;
        }
    }

    public interface ANRListener {
        void onAnrHappened(String stackTraceInfo);
    }

    private ANRChecker anrChecker = new ANRChecker();

    private ANRListener anrListener;

    public void addANRListener(ANRListener listener) {
        this.anrListener = listener;
    }

    public static ANRWatchDog getInstance() {
        if (sWatchdog == null) {
            sWatchdog = new ANRWatchDog();
        }
        return sWatchdog;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void run() {
        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND); // 设置为后台线程
        while (true) {
            while (!isInterrupted()) {
                synchronized (this) {
                    anrChecker.schedule();
                    long waitTime = timeout;
                    long start = SystemClock.uptimeMillis();
                    while (waitTime > 0) {
                        try {
                            wait(waitTime);
                        } catch (InterruptedException e) {
                            Log.w(TAG, e.toString());
                        }
                        waitTime = timeout - (SystemClock.uptimeMillis() - start);
                    }
                    if (!anrChecker.isBlocked()) {
                        continue;
                    }
                }
                if (!ignoreDebugger && Debug.isDebuggerConnected()) {
                    continue;
                }
                String stackTraceInfo = getStackTraceInfo();
                Log.e("@cly_anr", stackTraceInfo);
                if (anrListener != null) {
                    anrListener.onAnrHappened(stackTraceInfo);
                }
            }
            anrListener = null;
        }
    }

    private String getStackTraceInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            stringBuilder
                    .append(stackTraceElement.toString())
                    .append("\r\n");
        }
        return stringBuilder.toString();
    }
}
