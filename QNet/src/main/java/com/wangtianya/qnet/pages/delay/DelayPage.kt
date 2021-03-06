package com.wangtianya.qnet.pages.delay

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangtianya.qnet.R
import com.wangtianya.qnet.common.tools.thread.ThreadUtil
import com.wangtianya.qnet.databinding.PageDelayBinding
import com.wangtianya.qnet.pages.delay.model.DelayPageModel
import com.qjuzi.tools.core.activity.YaaFragment

/**
 * Created by wangtianya on 2018/4/25.
 */

@SuppressLint("MissingSuperCall")
class DelayPage : YaaFragment() {

    lateinit var model : DelayPageModel
    lateinit var binding: PageDelayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.page_delay, null, false)
        model = DelayPageModel(this, binding)
        model.mainPresenter.initData()
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return model.binding.root
    }

    override fun onResume() {
        super.onResume()
        ThreadUtil.runOnUI{ model.itemPingPresenter.startAllPing() }
    }

    override fun onPause() {
        super.onPause()
        ThreadUtil.runOnUI{ model.itemPingPresenter.stopAllPing() }
    }

}