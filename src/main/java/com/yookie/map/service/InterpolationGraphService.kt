package com.yookie.map.service

import com.yookie.map.bean.InterpolationGraph
import com.yookie.map.mapper.InterpolationGraphMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class InterpolationGraphService {

    @Autowired
    var interpolationGraphMapper: InterpolationGraphMapper? = null

    open fun getTemperatureInterpolationGraph(date: String): InterpolationGraph {
        val list = interpolationGraphMapper!!.getTemperatureInterpolationGraph(date)
        var max = Double.MIN_VALUE
        val dataList = arrayListOf<List<Double>>()

        list.forEach {
            val data = arrayListOf<Double>()
            data.apply {
                add(it.lat)
                add(it.lon)
                add(it.num)
            }

            dataList.add(data)
            max = if (max < it.num) it.num else max
        }

        return InterpolationGraph(max, dataList)
    }
}