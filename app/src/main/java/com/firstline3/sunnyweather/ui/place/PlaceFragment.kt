package com.firstline3.sunnyweather.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firstline3.sunnyweather.R
import com.firstline3.sunnyweather.databinding.FragmentPlaceBinding

/**
 * ProjectName: SunnyWeather
 * Package: com.firstline3.sunnyweather.ui.place
 * ClassName: PlaceFragment
 * CreateDate: 2021/8/20 8:20 下午
 * Author: zjy
 * Description: java类作用描述
 */
class PlaceFragment: Fragment() {
    val viewModel by lazy { ViewModelProvider(this).get(PlaceViewModel::class.java) }

    private lateinit var adapter: PlaceAdapter
    private var binding: FragmentPlaceBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaceBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        binding?.recyclerView?.layoutManager = layoutManager
        adapter = PlaceAdapter(this, viewModel.placeList)
        binding?.recyclerView?.adapter = adapter
        binding?.searchPlaceEdit?.addTextChangedListener {
            val  content = it.toString()
            if (content.isNotEmpty()) {
                viewModel.searchPlaces(content)
            } else {
                binding?.recyclerView?.visibility = View.GONE
                binding?.bgImageView?.visibility = View.VISIBLE
                viewModel.placeList.clear()
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.placeLiveData.observe(viewLifecycleOwner, Observer {
            val places = it.getOrNull()
            if (places != null) {
                binding?.recyclerView?.visibility = View.VISIBLE
                binding?.bgImageView?.visibility = View.GONE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(places)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "未能查询到任何地点", Toast.LENGTH_SHORT).show()
                it.exceptionOrNull()?.printStackTrace()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}