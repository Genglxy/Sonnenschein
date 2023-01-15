package com.sonnenschein.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SonnenscheinApplication : Application() {

    companion object {
        val TOKEN = context.getString(R.string.Token)

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}