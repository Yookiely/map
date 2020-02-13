package com.yookie.map.controller

import com.yookie.map.bean.WindRose
import com.yookie.map.service.WindRoseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class WindRoseController {
    @Autowired
    val  windRoseService :WindRoseService? = null

    @GetMapping("/windrose/{time}")
    fun getWindRose(@PathVariable("time") time : String) : WindRose{
        println(time)
        return windRoseService!!.getWindRose(time)
    }

}