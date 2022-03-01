package com.bob.codeLabs.ui

import com.bob.base.mvvm.MVVMActivity
import com.bob.codeLabs.R
import com.bob.codeLabs.databinding.ActivityMainBinding
import com.bob.codeLabs.netWork.Article

//@AndroidEntryPoint
class MainActivity : MVVMActivity<ActivityMainBinding>() {
//    @Inject
//    lateinit var testHilt: TestHilt

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun subscribeUi() {
//        testHilt.run()
    }
}