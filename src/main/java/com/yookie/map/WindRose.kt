package com.yookie.map

 data class WindRose(
    val head : Head,
    val data : List<Float>
 )

data class Head(
    val dx : Int,
    val dy : Int,
    val la1 : Float,
    val la2 : Float,
    val lo1: Float, // 经度
    val lo2: Float, // 经度
    val nx: Int, //数量
    val ny: Int, //数量
    val parameterCategory: Int, // 固定值
    val parameterNumber: Int, //固定值
    val parameterNumberName: String, //无意义值，可默认为eastward_wind
    val parameterUnit: String, //单位
    val refTime: String //时间

)

