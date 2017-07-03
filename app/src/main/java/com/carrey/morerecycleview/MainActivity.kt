package com.carrey.morerecycleview


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.carrey.morerecycleview.entity.MainEntity
import com.carrey.morerecycleview.overflow.RecycleViewOverFlowActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val items = listOf(MainEntity("悬浮效果", RecycleViewOverFlowActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycleList.adapter = MainAdapter(this, items)
    }
}
