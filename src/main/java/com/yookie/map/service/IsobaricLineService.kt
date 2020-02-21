package com.yookie.map.service

import com.yookie.map.bean.Feature
import com.yookie.map.bean.Geometry
import com.yookie.map.bean.IsobaricLine
import com.yookie.map.bean.Property
import com.yookie.map.mapper.IsobaricLineMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheManager = "isobaricLineRedisCacheManager")
open class IsobaricLineService {

    @Autowired
    var isobaricLineMapper: IsobaricLineMapper? = null

    @Cacheable(cacheNames = ["isobaricLine"])
    open fun getIsobaricLine(date: String): IsobaricLine {
        val isobaricLineDataList = isobaricLineMapper!!.getIsobaricLineByDate(date)

        val features = arrayListOf<Feature>()
        isobaricLineDataList.forEach { isobaricLineData ->
            if (isobaricLineData.atmospheric_pressure != null) {
                val coordinates = arrayListOf<Double>().also {
                    it.add(isobaricLineData.lon)
                    it.add(isobaricLineData.lat)
                }

                features.add(Feature("Feature", Property(isobaricLineData.atmospheric_pressure), Geometry("Point", coordinates)))
            }
        }

        return IsobaricLine("FeatureCollection", features)

    }

}