package com.bob.codeLabs.anrCrash

import android.content.Context
import com.bob.lAnrCrash.anr.ANRWatchDog
import com.bob.lAnrCrash.javaCrash.CrashHandler
import com.bob.lAnrCrash.nativeCrash.NativeCrashHandler

/**
 * created by cly on 2022/1/10
 */
class AnrCrashHandler {
    companion object {
        fun init(application: Context) {
            ANRWatchDog.getInstance().start()
            CrashHandler.init(application)
            NativeCrashHandler.init(application)
        }
    }
}