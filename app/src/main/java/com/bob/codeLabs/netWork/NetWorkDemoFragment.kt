package com.bob.codeLabs.netWork

import androidx.fragment.app.viewModels
import com.bob.base.mvvm.MVVMFragment
import com.bob.codeLabs.R
import com.bob.codeLabs.databinding.FragmentNetworkDemoBinding

/**
 * created by cly on 2022/1/19
 */
class NetWorkDemoFragment : MVVMFragment<FragmentNetworkDemoBinding>() {

    private val mViewModel: NetworkDemoViewModel by viewModels()

    override fun layoutRes(): Int = R.layout.fragment_network_demo

    override fun subscribeUi() {
        mBinding.btnRequire.setOnClickListener {
            mViewModel.query()
        }
        observe(mViewModel.topArticles, this::onTopArticles)
        observe(mViewModel.tips) {
            mBinding.tvResult.text = it
        }
    }

    private fun onTopArticles(list: List<Article>) {
        mBinding.tvResult.text = list[0].title
    }
}