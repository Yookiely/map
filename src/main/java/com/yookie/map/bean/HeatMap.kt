package com.yookie.map.bean

data class HeatMap(
        val max : Int,
        val data : List<Data>
)

data class Data(
        val lat : Float,
        val lng : Float,
        val count : Int
)