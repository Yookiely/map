package com.yookie.map.mapper

import com.yookie.map.bean.IsobaricLineData
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component(value = "IsobaricLineMapper")
interface IsobaricLineMapper {

    @Select("SELECT city_label, lon, lat, atmospheric_pressure, release_date FROM city_position left join city_condition on city_position.label = city_condition.city_label where release_date = #{release_date}")
    fun getIsobaricLineByDate(release_date: String): List<IsobaricLineData>


}