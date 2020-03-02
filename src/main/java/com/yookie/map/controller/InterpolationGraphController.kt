package com.yookie.map.controller

import com.yookie.map.bean.InterpolationGraph
import com.yookie.map.service.InterpolationGraphService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InterpolationGraphController {

    @Autowired
    val interpolationGraphService: InterpolationGraphService? = null

    @GetMapping("/InterpolationGraph/temperature")
    fun getTemperatureInterpolationGraph(date: String): InterpolationGraph {
        return interpolationGraphService!!.getTemperatureInterpolationGraph(date)
    }
}