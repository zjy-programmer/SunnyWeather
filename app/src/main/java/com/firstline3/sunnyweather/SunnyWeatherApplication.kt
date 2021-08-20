package com.firstline3.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather
 * ClassName: SunnyWeatherApplication
 * CreateDate: 2021/8/12 12:54 上午
 * Author: zjy
 * Description: java类作用描述
 */
class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}