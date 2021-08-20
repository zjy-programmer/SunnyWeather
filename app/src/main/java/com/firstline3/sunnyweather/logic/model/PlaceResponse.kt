package com.firstline3.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.logic.model
 * ClassName: PlaceResponse
 * CreateDate: 2021/8/12 12:59 上午
 * Author: zjy
 * Description: java类作用描述
 */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)
