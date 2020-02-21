package com.yookie.map.controller

import com.yookie.map.bean.CityCondition
import com.yookie.map.bean.CityPositions
import com.yookie.map.service.CityPositionAndConditionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


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


}