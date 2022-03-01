package com.bob.lnetwork

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * created by cly on 2022/1/18
 */
const val TIME_OUT_SECONDS = 30

private val httpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
    .readTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
    .build()

abstract class ApiBase(url: String) {
    protected val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    protected abstract fun getDefaultMap(): Map<String?, Any?>?
}