package com.example.joaogouveia89.marketlist.app.ui.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.joaogouveia89.marketlist.R
import com.example.joaogouveia89.marketlist.app.framework.bases.BaseActivityViewModel
import com.example.joaogouveia89.marketlist.databinding.ActivityHomeBinding;
class HomeActivity : BaseActivityViewModel<ActivityHomeBinding, HomeViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        mViewModel = HomeViewModel()
        mBinding.viewModel = mViewModel
    }
}