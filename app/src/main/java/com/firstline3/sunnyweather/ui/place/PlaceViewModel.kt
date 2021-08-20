package com.firstline3.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.firstline3.sunnyweather.logic.Repository
import com.firstline3.sunnyweather.logic.model.Place

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.ui.place
 * ClassName: PlaceViewModel
 * CreateDate: 2021/8/17 11:22 下午
 * Author: zjy
 * Description: java类作用描述
 */
class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}