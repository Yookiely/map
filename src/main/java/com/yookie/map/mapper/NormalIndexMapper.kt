package com.yookie.map.mapper

import com.yookie.map.bean.NormalIndex
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component


@Mapper
@Component(value = "NormalIndexMapper")
interface NormalIndexMapper {
    @Select("SELECT p.lon,p.lat,${'$'}{param} as num FROM city_position p, city_condition c WHERE p.label = c.city_label AND c.release_date = #{date} AND c.release_hour = #{hour} AND ${'$'}{param} > ${'$'}{min} AND ${'$'}{param} < ${'$'}{max};")
    fun getNumByCity(@Param("param") param : String, @Param("date")date : String, @Param("hour")hour : String,@Param("min")min : String,@Param("max")max : String) : List<NormalIndex>
}