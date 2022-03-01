package com.bob.lAnrCrash.javaCrash

import android.content.Context
import android.util.Log

/**
 * created by cly on 2022/1/8
 */
class CrashHandler : Thread.UncaughtExceptionHandler {

    companion object {
        private lateinit var defaultUncaughtExceptionHandler: Thread.UncaughtExceptionHandler

        @JvmStatic
        fun init(applicationContext: Context) {
            defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(CrashHandler())
        }
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        try {
            //crash上报
            Log.d("@cly_crashHandler", e.printStackTrace().toString())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            defaultUncaughtExceptionHandler.uncaughtException(t, e)
        }
    }
}