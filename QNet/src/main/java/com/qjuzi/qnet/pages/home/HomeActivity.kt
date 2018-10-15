package com.qjuzi.qnet.pages.home

import android.app.Activity
import android.os.Bundle
import com.qjuzi.qnet.pages.home.model.HomeStore

/**
 * Activity的责任：
 * 1、初始化model，binding，presenter。
 * 2、生命周期的分发，调用合适presenter进行处理。
 */
class HomeActivity : Activity() {

    private lateinit var store: HomeStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        store = HomeStore(this)

        setContentView(store.binding.root)

        store.mainPresenter.initData()


    }

    override fun onDestroy() {
        store.mainPresenter.destory()
        super.onDestroy()
    }

    override fun onResume() {
        store.delayTaskPresenter.startDelayDataUpdateTask()
        super.onResume()
    }

    override fun onPause() {
        store.delayTaskPresenter.stopDelayDataUpdateTask()
        super.onPause()
    }
}
