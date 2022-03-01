package com.bob.codeLabs.netWork

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by cly on 2022/1/23
 */
@Entity(tableName = "net_cache")
data class NetCache(
    @PrimaryKey
    @ColumnInfo(name = "key")
    val key: String,
    @ColumnInfo(name = "value")
    val value: String,
)
