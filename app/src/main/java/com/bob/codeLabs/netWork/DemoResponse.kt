package com.bob.codeLabs.netWork

/**
 * created by cly on 2022/1/19
 */
sealed class DemoResponse<out T> {
    companion object {
        fun <T> success(result: T): DemoResponse<T> = Success(result)
        fun <T> failure(msg: String): DemoResponse<T> = Failure(msg)
        fun <T> netError(msg: String): DemoResponse<T> = NetError(msg)
    }

    data class Success<out T>(val data: T) : DemoResponse<T>()
    data class Failure(val msg: String) : DemoResponse<Nothing>()
    data class NetError(val msg: String) : DemoResponse<Nothing>()
}