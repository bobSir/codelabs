package com.bob.codeLabs.handlerThread

import android.os.Handler
import android.os.HandlerThread
import com.orhanobut.logger.Logger

/**
 * created by cly on 2022/1/11
 */
class SingleThreadTask {
    lateinit var thread: HandlerThread
    lateinit var handler: Handler

    fun test(tag: String) {
        thread = HandlerThread(tag)
        thread.start()
        handler = Handler(thread.looper)
        handler.post {
            Logger.d("@cly - singleThread - 0")
        }
    }

    fun test2() {
        handler.post {
            Logger.d("@cly - singleThread - 1")
        }
    }

    fun destroy() {
        thread.quit()
        handler.removeCallbacksAndMessages(null)
    }
}