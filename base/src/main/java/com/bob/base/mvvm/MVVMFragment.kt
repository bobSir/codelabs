package com.bob.base.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * created by cly on 2022/1/12
 */
abstract class MVVMFragment<V : ViewDataBinding> : Fragment() {
    lateinit var mBinding: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate<V>(inflater, layoutRes(), container, false)
        subscribeUi()
        return mBinding.root
    }

    abstract fun layoutRes(): Int

    abstract fun subscribeUi()
}