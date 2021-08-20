package com.firstline3.sunnyweather.logic.network

import com.firstline3.sunnyweather.logic.model.Constant
import com.firstline3.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.logic.network
 * ClassName: PlaceService
 * CreateDate: 2021/8/12 1:03 上午
 * Author: zjy
 * Description: java类作用描述
 */
interface PlaceService {
    @GET("v2/place?token=${Constant.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}