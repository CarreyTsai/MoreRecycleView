package com.carrey.morerecycleview.overflow

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carrey.morerecycleview.R
import com.carrey.morerecycleview.entity.OverFlowEntity
import kotlinx.android.synthetic.main.activity_over_flow_item.view.*

/**
 * 作者： carrey
 * 时间 2017/6/30
 * desc:
 */
class OverFlowAdapter(val comtext: Context, var mItems: List<OverFlowEntity>) : RecyclerView.Adapter<OverFlowAdapter.ViewHolder>(), GroupListener {


    override fun getGroupName(position: Int): String {
        return mItems[position].province

    }

    private var mInflate: LayoutInflater = LayoutInflater.from(comtext)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = mItems[position]
        holder.bindData(entity)

    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        return ViewHolder(mInflate.inflate(R.layout.activity_over_flow_item, p0, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(entity: OverFlowEntity) {
            itemView.tvName.text = entity.name

        }

    }
}