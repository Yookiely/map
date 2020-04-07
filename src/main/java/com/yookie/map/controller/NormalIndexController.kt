package com.yookie.map.controller

import com.yookie.map.bean.NormalIndex
import com.yookie.map.service.NormalIndexService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
class NormalIndexController {

    @Autowired
    val normalIndexService : NormalIndexService? = null


    @RequestMapping("/normal")
    fun getNormal( request : HttpServletRequest) : List<List<NormalIndex>>{
        return normalIndexService!!.getNormalIndexByDate(request.getParameter("param"), request.getParameter("date"), request.getParameter("hour"))

    }


}