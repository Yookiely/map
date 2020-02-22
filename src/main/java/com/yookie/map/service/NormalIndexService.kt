package com.yookie.map.service

import com.yookie.map.bean.NormalIndex
import com.yookie.map.mapper.NormalIndexMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
open class NormalIndexService {
    lateinit var list: List<String>

    @Autowired
    val normalIndexMapper: NormalIndexMapper? = null
    open fun getNormalIndexByDate(param : String,date : String,hour : String) : List<List<NormalIndex>>{
        when(param){
            "SO2" -> list = listOf("0","150","500","650","800","1600","2100")
            "AQI" -> list = listOf("0","50","100","150","200","300","400")
            "NO2" -> list = listOf("0","100","200","700","1200","2340","3090")
            "PM10" -> list = listOf("0","50","150","250","350","420","500")
            "CO" -> list = listOf("0","5","10","35","60","90","120")
            "O3" -> list = listOf("0","160","200","300","400","800","1000")
            "PM2.5" ->list = listOf("0","35","75","115","150","250","350")
            else -> list = listOf("0","50","100","150","200","300","400")
        }

        return listOf(normalIndexMapper!!.getNumByCity(param,date,hour,list[0],list[1]),
                normalIndexMapper.getNumByCity(param,date,hour,list[1],list[2]),
                normalIndexMapper.getNumByCity(param,date,hour,list[2],list[3]),
                normalIndexMapper.getNumByCity(param,date,hour,list[3],list[4]),
                normalIndexMapper.getNumByCity(param,date,hour,list[4],list[5]),
                normalIndexMapper.getNumByCity(param,date,hour,list[5],list[6])
                )
    }

}