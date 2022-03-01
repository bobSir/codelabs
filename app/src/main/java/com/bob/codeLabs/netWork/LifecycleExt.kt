package com.bob.codeLabs.netWork

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * created by cly on 2022/1/19
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> observer(t) } })
}