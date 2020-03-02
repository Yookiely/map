package com.yookie.map.mapper

import com.yookie.map.bean.NormalIndex
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component(value = "InterpolationGraphMapper")
interface InterpolationGraphMapper {

    @Select("SELECT lon, lat, temperature as num\n" +
            "FROM city_position\n" +
            "left join city_condition\n" +
            "on city_position.label = city_condition.city_label\n" +
            "where release_date = #{release_date}")
    fun getTemperatureInterpolationGraph(@Param("release_date") release_date: String): List<NormalIndex>
}