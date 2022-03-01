package com.bob.codeLabs.netWork

import com.bob.base.repository.BaseRepositoryBoth
import com.bob.base.repository.ILocalDataSource
import com.bob.base.repository.IRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * created by cly on 2022/1/19
 */
class NetDemoRepository constructor(
    remoteDataSource: NetDemoRemoteDataSource,
    localDataSource: NetDemoLocalDataSource
) : BaseRepositoryBoth<NetDemoRemoteDataSource, NetDemoLocalDataSource>(
    remoteDataSource,
    localDataSource
) {

    private val TEST_KEY = "111"

    suspend fun query(): DemoResponse<List<Article>> {
        val response = remoteDataSource.query()
        when (response) {
            is DemoResponse.Success -> localDataSource.insertNewData(TEST_KEY, response.data[0].title)
            else -> {
            }
        }
        return response
    }

    suspend fun queryCache(): NetCache {
        return localDataSource.query(TEST_KEY)
    }
}

class NetDemoRemoteDataSource : IRemoteDataSource {
    private val demoAPI: DemoAPI = DemoAPI()

    suspend fun query(): DemoResponse<List<Article>> {
        return processApiResponse { demoAPI.queryTopArticle() }
    }
}

class NetDemoLocalDataSource : ILocalDataSource {
    private val netCacheDao = AppDatabase.getInstance().netCacheDao()

    suspend fun query(key: String): NetCache {
        return netCacheDao.getResponseResult(key)
    }

    suspend fun insertNewData(key: String, value: String) {
        netCacheDao.insertResponseResult(NetCache(key, value))
    }
}