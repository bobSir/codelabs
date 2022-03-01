package com.bob.base.repository

/**
 * created by cly on 2022/1/18
 */
open class BaseRepositoryBoth<T : IRemoteDataSource, R : ILocalDataSource>(
    val remoteDataSource: T,
    val localDataSource: R,
)

open class BaseRepositoryRemote<T : IRemoteDataSource>(
    val remoteDataSource: T,
)

open class BaseRepositoryLocal<R : ILocalDataSource>(
    val localDataSource: R,
)
