package com.carrey.morerecycleview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carrey.morerecycleview.entity.MainEntity
import kotlinx.android.synthetic.main.activity_main_item.view.*

/**
 * 作者： carrey
 * 时间 2017/6/23
 * desc:
 */
class MainAdapter(val comtext: Context, val mItems: List<MainEntity>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mInflate: LayoutInflater = LayoutInflater.from(comtext)

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val entity = mItems.get(position)
        holder?.bindData(entity)
        holder?.itemView?.setOnClickListener {
            comtext.startActivity(Intent(comtext, entity.clazz))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, p1: Int): ViewHolder {
        return ViewHolder(mInflate.inflate(R.layout.activity_main_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(positon: MainEntity) {
            itemView.tvName.text = positon.name
        }

    }
}