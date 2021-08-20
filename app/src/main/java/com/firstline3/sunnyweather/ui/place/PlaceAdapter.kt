package com.firstline3.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firstline3.sunnyweather.R
import com.firstline3.sunnyweather.logic.model.Place

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.ui.place
 * ClassName: PlaceAdapter
 * CreateDate: 2021/8/19 10:18 下午
 * Author: zjy
 * Description: java类作用描述
 */
class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Place>)
    : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val  placeName: TextView = view.findViewById(R.id.placeName)
            val placeAddress: TextView = view.findViewById(R.id.placeAddress)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount() = placeList.size
}