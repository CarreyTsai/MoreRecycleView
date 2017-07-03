package com.carrey.morerecycleview

import android.app.Application
import kotlin.properties.Delegates

/**
 * 作者： carrey
 * 时间 2017/6/23
 * desc:
 */
class CommonApp : Application() {

    companion object {
        private var sApp: CommonApp by Delegates.notNull()

        @JvmStatic
        fun getApp(): CommonApp {
            return sApp
        }
    }


    override fun onCreate() {
        super.onCreate()
        sApp = this
        init()
    }

    private fun init() {


    }


}