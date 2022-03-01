package com.bob.codeLabs.netWork

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * created by cly on 2022/1/19
 */
class NetworkDemoViewModel : ViewModel() {
    private val netDemoRepository: NetDemoRepository = NetDemoRepository(NetDemoRemoteDataSource(), NetDemoLocalDataSource())

    val topArticles: MutableLiveData<List<Article>> = MutableLiveData()

    val tips: MutableLiveData<String> = MutableLiveData()

    fun query() {
        viewModelScope.launch {
//            val async = async { netDemoRepository.queryCache() }

            val queryCache = netDemoRepository.queryCache()
            tips.postValue(queryCache.value)
            when (val result = netDemoRepository.query()) {
                is DemoResponse.Success -> topArticles.value = result.data
            }
        }
    }
}