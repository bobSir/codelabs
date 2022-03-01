package com.bob.codeLabs.util

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


/**
 * created by cly on 2022/1/11
 */
class BobLog {

    companion object {
        fun init() {
            val build = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(1)
                .methodOffset(2)
                .build()
            Logger.addLogAdapter(object : AndroidLogAdapter(build) {
                override fun isLoggable(priority: Int, tag: String?): Boolean {
                    return true
                }
            })
        }
    }
}