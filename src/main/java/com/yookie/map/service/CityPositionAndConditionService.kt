package com.yookie.map.service

import com.yookie.map.bean.CityCondition
import com.yookie.map.bean.CityPositions
import com.yookie.map.mapper.CityPositionAndConditionMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
open class CityPositionAndConditionService {

    @Autowired
    var cityPositionAndConditionMapper: CityPositionAndConditionMapper? = null

    open fun getAllPositions(): CityPositions {
        return CityPositions(cityPositionAndConditionMapper!!.getAllPositions())
    }

    open fun getCityCondition(position: String, date: String): CityCondition {
        val conditions = cityPositionAndConditionMapper!!.getCityCondition(position, date)

        return conditions.first()
    }
}