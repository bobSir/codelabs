package com.bob.codeLabs

import android.app.Application
import com.bob.codeLabs.anrCrash.AnrCrashHandler
import com.bob.codeLabs.util.BobLog
import com.bob.codeLabs.util.ContextUtil

/**
 * created by cly on 2022/1/7
 */
//@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextUtil.init(this)
        BobLog.init()
        AnrCrashHandler.init(this)
    }
}