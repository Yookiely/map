package com.yookie.map.service

import com.yookie.map.bean.HeatMap
import com.yookie.map.mapper.HeatMapMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
open class HeatMapService {
    @Autowired
    var heatMapMapper : HeatMapMapper? = null


    @Cacheable(cacheNames = ["heatmap"],cacheManager = "heatmapRedisCacheManager")
    open fun getHeatMap(date : String) : HeatMap{
        return HeatMap(3,heatMapMapper!!.getHeadMapByDate(date))
    }
}