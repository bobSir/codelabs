package com.bob.codeLabs.netWork

import com.bob.lnetwork.BaseResponse
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

/**
 * created by cly on 2022/1/19
 */
inline fun <T> processApiResponse(request: () -> BaseResponse<T>): DemoResponse<T> {
    return try {
        val response = request()
        if (response.errorCode == 0) {
            DemoResponse.success(response.data!!)
        } else {
            DemoResponse.failure(response.errorMsg)
        }
    } catch (e: Exception) {
        when (e) {
            is HttpException -> DemoResponse.netError("网络错误")
            is UnknownHostException -> DemoResponse.netError("网络错误")
            is ConnectException -> DemoResponse.netError("连接失败")
            is SSLHandshakeException -> DemoResponse.netError("证书验证失败")
            is SocketTimeoutException -> DemoResponse.netError("连接超时")
            else -> DemoResponse.netError("网络异常")
        }
    }
}