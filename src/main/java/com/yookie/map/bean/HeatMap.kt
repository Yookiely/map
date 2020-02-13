package com.yookie.map.bean

import com.yookie.map.NoArg


@NoArg
data class HeatMap(
        val max : Int,
        val data : List<Data>
)


@NoArg
data class Data(
        val lat : Float,
        val lng : Float,
        val count : Int
)