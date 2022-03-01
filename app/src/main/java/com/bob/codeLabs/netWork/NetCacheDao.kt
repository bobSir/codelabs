package com.bob.codeLabs.netWork

import androidx.room.*

/**
 * created by cly on 2022/1/23
 */
@Dao
interface NetCacheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResponseResult(netCache: NetCache): Long

    @Transaction
    @Query("SELECT * FROM net_cache WHERE `key` = :key")
    suspend fun getResponseResult(key: String): NetCache
}