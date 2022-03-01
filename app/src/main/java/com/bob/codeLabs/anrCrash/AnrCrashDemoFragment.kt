package com.bob.codeLabs.anrCrash

import com.bob.base.mvvm.MVVMFragment
import com.bob.codeLabs.R
import com.bob.codeLabs.databinding.FragmentAnrCrashDemoBinding
import com.bob.lAnrCrash.nativeCrash.NativeCrashHandler

/**
 * created by cly on 2022/1/10
 */
class AnrCrashDemoFragment : MVVMFragment<FragmentAnrCrashDemoBinding>() {

    override fun layoutRes(): Int = R.layout.fragment_anr_crash_demo

    override fun subscribeUi() {
        mBinding.btnJavaCrash.setOnClickListener {
            testJavaCrash()
        }
        mBinding.btnNativeCrash.setOnClickListener {
            NativeCrashHandler.testNativeCrash()
        }
        mBinding.btnAnr.setOnClickListener {
            Thread.sleep(10_000)
        }
    }

    private fun testJavaCrash() {
        val i = 1 / 0
    }
}