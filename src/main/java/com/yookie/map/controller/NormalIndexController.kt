package com.yookie.map.controller

import com.yookie.map.bean.NormalIndex
import com.yookie.map.service.NormalIndexService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class NormalIndexController {

    @Autowired
    val normalIndexService : NormalIndexService? = null


    @GetMapping("/normal/{param}/{date}/{hour}")
    fun getNormal(@PathVariable("date") date : String,@PathVariable("param") param : String,@PathVariable("hour") hour : String) : List<List<NormalIndex>>{
        return normalIndexService!!.getNormalIndexByDate(param, date, hour)
    }


}