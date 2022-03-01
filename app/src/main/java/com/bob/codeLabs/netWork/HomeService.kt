package com.bob.codeLabs.netWork

import androidx.lifecycle.Observer
import com.bob.lnetwork.BaseResponse
import retrofit2.http.GET

/**
 * created by cly on 2022/1/18
 */
interface HomeService {

    @GET("article/top/json")
    suspend fun queryTopArticle(): BaseResponse<List<Article>>

    @GET("article/top/json")
    suspend fun queryTopArticleTest(): Observer<BaseResponse<List<Article>>>
}