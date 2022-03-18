package com.bob.codeLabs.ui

import android.content.Intent
import androidx.navigation.findNavController
import com.bob.base.mvvm.MVVMFragment
import com.bob.codeLabs.R
import com.bob.codeLabs.databinding.FragmentMainBinding
import com.bob.codeLabs.handlerThread.SingleThreadTask
import com.bob.codeLabs.hookActivity.HookTestActivity

/**
 * created by cly on 2022/1/7
 */
//@AndroidEntryPoint
class MainFragment : MVVMFragment<FragmentMainBinding>() {

    override fun layoutRes(): Int = R.layout.fragment_main

    override fun subscribeUi() {
        mBinding.btnCrash.setOnClickListener {
            it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToAnrCrashDemoFragment())
        }
        mBinding.btnHandlerThread.setOnClickListener {
            val singleThreadTask = SingleThreadTask()
            singleThreadTask.test("test")
            singleThreadTask.test2()
        }
        mBinding.btnNet.setOnClickListener {
            it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToNetWorkDemoFragment())
        }
        mBinding.btnHookActivity.setOnClickListener {
            requireActivity().startActivity(Intent(context, HookTestActivity::class.java))
        }
    }
}