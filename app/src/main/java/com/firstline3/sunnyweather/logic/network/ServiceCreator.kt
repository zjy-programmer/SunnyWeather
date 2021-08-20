package com.firstline3.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.logic.network
 * ClassName: ServiceCreator
 * CreateDate: 2021/8/12 1:17 上午
 * Author: zjy
 * Description: java类作用描述
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}
