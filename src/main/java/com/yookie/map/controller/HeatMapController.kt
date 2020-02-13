package com.yookie.map.controller

import com.yookie.map.bean.HeatMap
import com.yookie.map.service.HeatMapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class HeatMapController {

    @Autowired
    val heatMapService : HeatMapService? = null


    @GetMapping("/heatmap/{date}")
    fun getHeatMap(@PathVariable("date") date : String) : HeatMap{
        return heatMapService!!.getHeatMap(date)

    }
}