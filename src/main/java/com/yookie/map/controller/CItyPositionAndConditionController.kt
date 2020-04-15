package com.yookie.map.controller

import com.yookie.map.bean.CityCondition
import com.yookie.map.bean.CityPosition
import com.yookie.map.bean.CityPositionAndCondition
import com.yookie.map.bean.CityPositions
import com.yookie.map.service.CityPositionAndConditionService
import org.gavaghan.geodesy.Ellipsoid
import org.gavaghan.geodesy.GeodeticCalculator
import org.gavaghan.geodesy.GlobalCoordinates
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CItyPositionAndConditionController {
    private val EARTH_RADIUS = 6371; // 平均半径,单位：m；不是赤道半径。赤道为6378左右

    @Autowired
    val cityPositionAndConditionService: CityPositionAndConditionService? = null

    @GetMapping("/citycositionandcondition/allpositions")
    fun getAllPositions(): CityPositions {
        return cityPositionAndConditionService!!.getAllPositions()
    }

    @GetMapping("/citycositionandcondition/condition")
    fun getCondition(position: String, date: String): CityCondition {
        return cityPositionAndConditionService!!.getCityCondition(position, date)
    }

    @GetMapping("/citycositionandcondition/judgecondition")
    fun judgeAndGetCondition(lon: Double, lat: Double, date: String): CityPositionAndCondition {
        val positions = cityPositionAndConditionService!!.getAllPositions().positions

        var minDis = Double.MAX_VALUE
        var minPosition: CityPosition? = null
        val source = GlobalCoordinates(lat, lon);


        positions.forEach {
            val target = GlobalCoordinates(it.lat, it.lon);
            val dis = getDistanceMeter(source, target, Ellipsoid.WGS84)

            if (minDis > dis) {
                minPosition = it
                minDis = dis
            }
        }
        println(minPosition?.label)
        if (minPosition != null) {
            try {

                return CityPositionAndCondition(minPosition, cityPositionAndConditionService.getCityCondition(minPosition!!.label, date))
            } catch (e: Exception) {
                println(e.message)
                return CityPositionAndCondition(minPosition, null)
            }

        } else {
            return CityPositionAndCondition(minPosition, null)
        }

    }


    private fun getDistanceMeter(gpsFrom: GlobalCoordinates, gpsTo: GlobalCoordinates, ellipsoid: Ellipsoid): Double {
        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        val geoCurve = GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);

        return geoCurve.ellipsoidalDistance;
    }
}