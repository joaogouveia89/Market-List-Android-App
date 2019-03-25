package com.example.joaogouveia89.marketlist.app.framework.bases

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.databinding.ViewDataBinding


//https://medium.com/@sandeeptengale/writing-good-baseactivity-class-for-android-activity-100636c81011
@SuppressLint("Registered")
open class BaseActivityViewModel<T:ViewDataBinding, V:ViewModel>: BaseActivity() {
    protected lateinit var mBinding:T
    protected lateinit var mViewModel:V
}