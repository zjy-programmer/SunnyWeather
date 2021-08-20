package com.firstline3.sunnyweather.logic

import androidx.lifecycle.liveData
import com.firstline3.sunnyweather.logic.model.Place
import com.firstline3.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.logic
 * ClassName: Repository
 * CreateDate: 2021/8/13 11:51 下午
 * Author: zjy
 * Description: java类作用描述
 */
object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}