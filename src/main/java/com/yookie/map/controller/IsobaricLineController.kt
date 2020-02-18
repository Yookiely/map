package com.yookie.map.controller

import com.yookie.map.bean.IsobaricLine
import com.yookie.map.service.IsobaricLineService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class IsobaricLineController {

    @Autowired
    val isobaricLineService: IsobaricLineService? = null

    @GetMapping("/isobaricline/{date}")
    fun getIsobaricLine(@PathVariable("date") date: String): IsobaricLine {
        return isobaricLineService!!.getIsobaricLine(date)
    }
}