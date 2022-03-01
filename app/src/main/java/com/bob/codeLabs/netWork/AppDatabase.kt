package com.bob.codeLabs.netWork

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bob.codeLabs.util.ContextUtil

/**
 * created by cly on 2022/1/23
 */
@Database(
    entities = [NetCache::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun netCacheDao(): NetCacheDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ContextUtil.getContext().applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}