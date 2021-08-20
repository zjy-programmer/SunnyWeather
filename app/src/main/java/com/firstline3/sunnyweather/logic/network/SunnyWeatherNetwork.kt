package com.firstline3.sunnyweather.logic.network

import retrofit2.await

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.logic.network
 * ClassName: SunnyWeatherNetwork
 * CreateDate: 2021/8/13 9:43 下午
 * Author: zjy
 * Description: java类作用描述
 */
object SunnyWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()


}