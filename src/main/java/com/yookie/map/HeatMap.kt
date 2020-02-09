package com.yookie.map

data class HeatMap(
        val max : Int,
        val data : Data
)

data class Data(
        val lat : Float,
        val lng : Float,
        val count : Int
)