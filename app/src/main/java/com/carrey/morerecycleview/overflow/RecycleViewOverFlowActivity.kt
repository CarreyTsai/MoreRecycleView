package com.carrey.morerecycleview.overflow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.carrey.morerecycleview.R
import com.carrey.morerecycleview.entity.OverFlowEntity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 作者： carrey
 * 时间 2017/6/30
 * desc:
 */
class RecycleViewOverFlowActivity : AppCompatActivity() {

    companion object {
        val data = arrayListOf(OverFlowEntity("合肥1", "安徽")
                , OverFlowEntity("合肥2", "安徽")
                , OverFlowEntity("合肥3", "安徽")
                , OverFlowEntity("合肥4", "安徽")
                , OverFlowEntity("合肥5", "安徽")
                , OverFlowEntity("杭州1", "浙江")
                , OverFlowEntity("杭州2", "浙江")
                , OverFlowEntity("杭州3", "浙江")
                , OverFlowEntity("杭州4", "浙江")
                , OverFlowEntity("杭州5", "浙江")
                , OverFlowEntity("杭州6", "浙江")
                , OverFlowEntity("南京1", "江苏")
                , OverFlowEntity("南京2", "江苏")
                , OverFlowEntity("南京3", "江苏")
                , OverFlowEntity("南京4", "江苏")
                , OverFlowEntity("南京5", "江苏")
                , OverFlowEntity("南京6", "江苏")
                , OverFlowEntity("南京7", "江苏")
                , OverFlowEntity("合肥2", "安徽")
                , OverFlowEntity("合肥3", "安徽")
                , OverFlowEntity("合肥4", "安徽")
                , OverFlowEntity("合肥5", "安徽")
                , OverFlowEntity("杭州1", "浙江")
                , OverFlowEntity("杭州2", "浙江")
                , OverFlowEntity("杭州3", "浙江")
                , OverFlowEntity("杭州4", "浙江")
                , OverFlowEntity("杭州5", "浙江")
                , OverFlowEntity("杭州6", "浙江")
                , OverFlowEntity("南京1", "江苏")
                , OverFlowEntity("南京2", "江苏")
                , OverFlowEntity("南京3", "江苏")
                , OverFlowEntity("南京4", "江苏")
                , OverFlowEntity("南京5", "江苏")
                , OverFlowEntity("南京6", "江苏")
                , OverFlowEntity("南京7", "江苏")

        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = OverFlowAdapter(this, data)
        recycleList.addItemDecoration(OverFlowItemDecoration(adapter))
        recycleList.adapter = adapter
    }
}