package com.bob.lnetwork

import com.google.gson.annotations.SerializedName

/**
 * created by cly on 2022/1/18
 */
data class BaseResponse<T>(
    @SerializedName("data")
    val data: T,
    @SerializedName("errorCode")
    val errorCode: Int,
    @SerializedName("errorMsg")
    val errorMsg: String
)