package com.yookie.map.service

import com.yookie.map.bean.Feature
import com.yookie.map.bean.Geometry
import com.yookie.map.bean.IsobaricLine
import com.yookie.map.bean.Property
import com.yookie.map.mapper.IsobaricLineMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class IsobaricLineService {

    @Autowired
    var isobaricLineMapper: IsobaricLineMapper? = null

    open fun getIsobaricLine(date: String): IsobaricLine {
        val isobaricLineDataList = isobaricLineMapper!!.getIsobaricLineByDate(date)

        val features = arrayListOf<Feature>()
        isobaricLineDataList.forEach { isobaricLineData ->
            val isChina: Boolean = isobaricLineData.lat in 10.0..60.0 && (isobaricLineData.lon + 180) in 50.0..160.0
            if (isobaricLineData.atmospheric_pressure != null && isChina) {
                val coordinates = arrayListOf<Double>().also {
                    it.add(isobaricLineData.lon + 180.0)
                    it.add(isobaricLineData.lat)
                }

                features.add(Feature("Feature", Property(isobaricLineData.atmospheric_pressure), Geometry("Point", coordinates)))
            }
        }

        return IsobaricLine("FeatureCollection", features)

    }

}