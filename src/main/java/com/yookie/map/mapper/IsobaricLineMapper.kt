package com.yookie.map.mapper

import com.yookie.map.bean.IsobaricLineData
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component(value = "IsobaricLineMapper")
interface IsobaricLineMapper {

    @Select("SELECT city_label, lon, lat, atmospheric_pressure, release_date\n" +
            "FROM city_position\n" +
            "left join city_condition\n" +
            "on city_position.label = city_condition.city_label\n" +
            "where release_date = #{release_date}")
    fun getIsobaricLineByDate(release_date: String): List<IsobaricLineData>


}