package com.yookie.map.mapper

import com.yookie.map.bean.CityCondition
import com.yookie.map.bean.CityPosition
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component


@Mapper
@Component(value = "CItyPositionAndConditionMapper")
interface CityPositionAndConditionMapper {

    @Select("select * from city_position")
    fun getAllPositions(): List<CityPosition>

    @Select("select * from city_condition c where c.city_label = #{city_label} and c.release_date = #{release_date}")
    fun getCityCondition(@Param("city_label") city_label: String, @Param("release_date") release_date: String): List<CityCondition>
}