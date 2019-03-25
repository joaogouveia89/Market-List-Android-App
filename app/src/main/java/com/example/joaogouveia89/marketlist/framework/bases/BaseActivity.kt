package com.example.joaogouveia89.marketlist.app.framework.bases

import android.annotation.SuppressLint
import android.databinding.ObservableBoolean
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import com.example.joaogouveia89.marketlist.app.framework.contracts.CallbackBaseViewModel

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), CallbackBaseViewModel {
    protected var showLoading = ObservableBoolean()

    override fun setLoading() {
        showLoading.set(true)
    }

    override fun hideLoading() {
        showLoading.set(false)
    }

}