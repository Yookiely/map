package com.yookie.map.service

import com.yookie.map.bean.WindRose
import com.yookie.map.mapper.WindRoseMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class WindRoseService {

    @Autowired
    var windRoseMapper: WindRoseMapper? = null


    fun getWindRose(time : String) : WindRose {
        println("查询"+time+"的数据")
        println(windRoseMapper!!.getHeadByTime(time))
        println(windRoseMapper!!.getDataByTime(time))
        return WindRose(windRoseMapper!!.getHeadByTime(time), windRoseMapper!!.getDataByTime(time))
    }

}