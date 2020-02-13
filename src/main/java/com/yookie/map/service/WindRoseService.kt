package com.yookie.map.service

import com.yookie.map.bean.WindRose
import com.yookie.map.mapper.WindRoseMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
@CacheConfig(cacheManager = "winRoseRedisCacheManager")
open class WindRoseService {

    @Autowired
    var windRoseMapper: WindRoseMapper? = null

    @Cacheable(cacheNames = ["windrose"])
    open fun getWindRose(time : String) : WindRose {
        println("查询"+time+"的数据")
        return WindRose(windRoseMapper!!.getHeadByTime(time), windRoseMapper!!.getDataByTime(time))
    }

}