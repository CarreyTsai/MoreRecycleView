package com.carrey.morerecycleview.overflow

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.text.TextPaint
import android.text.TextUtils
import android.view.View

/**
 * 作者： carrey
 * 时间 2017/7/3
 * desc:
 */
class OverFlowItemDecoration(val adapter: OverFlowAdapter) : RecyclerView.ItemDecoration(), GroupListener {
    override fun getGroupName(position: Int): String {

        return adapter.getGroupName(position)

    }

    private val mGroupHeight = 150
    private val mPaint = Paint()


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        if (position == 0 || isFirstInGroup(position)) {
            outRect!!.top = mGroupHeight
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        val left = parent.left
        val right = parent.right
        val childCount = parent.childCount
        mPaint.color = Color.parseColor("#333333")
        for (pos in 0 until childCount) {
            val childView = parent.getChildAt(pos)
            val bottom = childView.top
            val top = bottom
            c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
        }

    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val itemCount = state.itemCount
        val childCount = parent.childCount
        val left = parent.left + parent.paddingLeft
        val right = parent.right - parent.paddingRight
        var preGroupName: String
        var currentGroupName = ""
        val textPaint = TextPaint()
        textPaint.color = Color.parseColor("#333333")
        textPaint.textSize = 32.0.toFloat()
        mPaint.color = Color.GRAY
        for (pos in 0 until childCount) {
            val view = parent.getChildAt(pos)
            val position = parent.getChildAdapterPosition(view)
            preGroupName = currentGroupName
            currentGroupName = getGroupName(position)
            if (TextUtils.equals(preGroupName, currentGroupName)) continue
            val viewBottom = view.bottom
            var top = Math.max(view.top, mGroupHeight)
            if (position + 1 < itemCount) {
                val nextGroupName = getGroupName(position + 1)
                if (!currentGroupName.equals(nextGroupName) && viewBottom < top) {
                    top = viewBottom
                }
            }

            c.drawRect(left.toFloat(), (top - mGroupHeight).toFloat(), right.toFloat(), top.toFloat(), mPaint)

            val fontMetrics = textPaint.fontMetrics

            val baseLine = top - (mGroupHeight - (fontMetrics.bottom - fontMetrics.top)) / 2 - fontMetrics.bottom

            c.drawText(currentGroupName, (left + left).toFloat(), baseLine, textPaint)
        }


    }

    fun isFirstInGroup(pos: Int): Boolean {
        if (pos == 0) {
            return true
        } else {
            val proGroupName = getGroupName(pos - 1)
            val groupName = getGroupName(pos)
            return !TextUtils.equals(proGroupName, groupName)
        }

    }
}