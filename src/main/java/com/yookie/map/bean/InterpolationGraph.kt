package com.yookie.map.bean

import com.yookie.map.NoArg

@NoArg
data class InterpolationGraph(
        val max: Double,
        val data: List<List<Double>>
)