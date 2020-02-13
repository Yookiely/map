package com.yookie.map.mapper

import com.yookie.map.TestUser
import com.yookie.map.bean.Head
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component


@Mapper
@Component(value = "WindRoseMapper")
public interface WindRoseMapper {
    @Select("select * from wind_head WHERE refTime = #{refTime}")
    fun getHeadByTime(refTime : String) : Head

    @Select("select num from wind_data WHERE time = #{time}" )
    fun getDataByTime(time : String) : List<Float>


}