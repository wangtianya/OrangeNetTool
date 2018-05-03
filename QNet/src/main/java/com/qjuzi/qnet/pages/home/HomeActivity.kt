package com.qjuzi.qnet.pages.home

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.qjuzi.qnet.R
import com.qjuzi.qnet.pages.home.model.HomeModel
import com.qjuzi.yaa.core.activity.YaaActivity
import com.qjuzi.yaa.core.util.YaaToast
import kotlinx.android.synthetic.main.page_delay.*


/**
 * Activity的责任：
 * 1、初始化model，binding，presenter。
 * 2、生命周期的分发，调用合适presenter进行处理。
 */
class HomeActivity : YaaActivity() {

    private lateinit var model : HomeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = HomeModel(this, DataBindingUtil.setContentView(this, R.layout.activity_main))
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