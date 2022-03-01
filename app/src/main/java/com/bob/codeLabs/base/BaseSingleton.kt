package com.bob.codeLabs.base

/**
 * created by cly on 2022/2/11
 */
abstract class BaseSingleton<in P, out T> {
    @Volatile
    private var instance: T? = null

    protected abstract val creator: (P) -> T

    fun getInstance(param: P): T =
        instance ?: synchronized(this) {
            instance ?: creator(param).also { instance = it }
        }
}