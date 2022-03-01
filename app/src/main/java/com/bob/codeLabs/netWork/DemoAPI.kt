package com.bob.codeLabs.netWork

import com.bob.lnetwork.ApiBase
import com.bob.lnetwork.BaseResponse

/**
 * created by cly on 2022/1/18
 */
const val DEMO_URL = "https://www.wanandroid.com"

class DemoAPI : ApiBase(DEMO_URL) {
    private val homeService: HomeService = retrofit.create(HomeService::class.java)

    suspend fun queryTopArticle(): BaseResponse<List<Article>> {
        return homeService.queryTopArticle()
    }

    override fun getDefaultMap(): Map<String?, Any?> {
        return HashMap()
    }
}