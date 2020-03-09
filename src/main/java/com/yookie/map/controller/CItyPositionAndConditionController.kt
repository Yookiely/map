package com.yookie.map.controller

import com.yookie.map.bean.CityCondition
import com.yookie.map.bean.CityPosition
import com.yookie.map.bean.CityPositionAndCondition
import com.yookie.map.bean.CityPositions
import com.yookie.map.service.CityPositionAndConditionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin


@RestController
class CItyPositionAndConditionController {

    @Autowired
    val cityPositionAndConditionService: CityPositionAndConditionService? = null

    @GetMapping("/citycositionandCondition/allpositions")
    fun getAllPositions(): CityPositions {
        return cityPositionAndConditionService!!.getAllPositions()
    }

    @GetMapping("/citycositionandCondition/condition")
    fun getCondition(position: String, date: String): CityCondition {
        return cityPositionAndConditionService!!.getCityCondition(position, date)
    }

    @GetMapping("/citycositionandCondition/judgecondition")
    fun judgeAndGetCondition(lon: Double, lat: Double, date: String): CityPositionAndCondition {
        val positions = cityPositionAndConditionService!!.getAllPositions().positions

        var minDis = Double.MAX_VALUE
        var minPosition: CityPosition? = null

        positions.forEach {
            val dis = getDistance(lon, lat, it.lon, it.lat)
            if (minDis > dis) {
                minPosition = it
                minDis = dis
            }
        }

        if (minPosition != null) {
            return CityPositionAndCondition(minPosition, cityPositionAndConditionService.getCityCondition(minPosition!!.label, date))
        } else {
            return CityPositionAndCondition(minPosition, null)
        }

    }

    private fun getDistance(alon: Double, alat: Double, blon: Double, blat: Double): Double {
        return acos((sin(alat) * sin(blat)) + (cos(alat) * cos(blat) * cos(alon - blon))) * 6371
    }


}