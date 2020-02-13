package com.yookie.map.mapper

import com.yookie.map.bean.Data
import com.yookie.map.bean.HeatMap
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component


@Mapper
@Component(value = "HeatMapMapper")
interface HeatMapMapper {

    @Select("select lat,lng,count from head_map WHERE date = #{date}")
    fun getHeadMapByDate(date : String) : List<Data>

}