package com.yookie.map;

import com.yookie.map.bean.Data;
import com.yookie.map.bean.Head;
import com.yookie.map.bean.NormalIndex;
import com.yookie.map.bean.WindRose;
import com.yookie.map.mapper.HeatMapMapper;
import com.yookie.map.mapper.NormalIndexMapper;
import com.yookie.map.mapper.WindRoseMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MapApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    WindRoseMapper windRoseMapper;

    @Autowired
    HeatMapMapper heatMapMapper;

    @Autowired
    NormalIndexMapper normalIndexMapper;



    @Test
    public void testMapper() {
//       List<NormalIndex> employee = normalIndexMapper.getNumByCity("PM25","2","2");
//        System.out.println(employee.get(1).getNum());
    }
}
