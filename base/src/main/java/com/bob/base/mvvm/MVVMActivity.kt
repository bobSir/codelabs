package com.bob.base.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * created by cly on 2022/1/12
 */
abstract class MVVMActivity<V : ViewDataBinding> : AppCompatActivity() {
    lateinit var mBinding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<V>(this, layoutRes())
        subscribeUi()
    }

    abstract fun layoutRes(): Int

    abstract fun subscribeUi()
}