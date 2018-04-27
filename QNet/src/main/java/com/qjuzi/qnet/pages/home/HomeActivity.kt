package com.qjuzi.qnet.pages.home

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.qjuzi.qnet.R
import com.qjuzi.qnet.databinding.ActivityMainBinding
import com.qjuzi.yaa.core.activity.YaaActivity


class HomeActivity : YaaActivity() {

    private lateinit var model :HomeModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        model = HomeModel(this, binding)
        model.mainPresenter.initData()
    }

    @SuppressLint("MissingSuperCall") override fun onDestroy() {
        model.mainPresenter.destory()
        super.onDestroy()
    }

    @SuppressLint("MissingSuperCall") override fun onResume() {
        model.delayTaskPresenter.startDelayDataUpdateTask()
        super.onResume()
    }

    @SuppressLint("MissingSuperCall") override fun onPause() {
        model.delayTaskPresenter.stopDelayDataUpdateTask()
        super.onPause()
    }






}
