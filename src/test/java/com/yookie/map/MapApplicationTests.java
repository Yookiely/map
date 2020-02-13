package com.yookie.map;

import com.yookie.map.bean.Head;
import com.yookie.map.bean.WindRose;
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



    @Test
    public void testMapper() {
        Head employee = windRoseMapper.getHeadByTime("10");
        System.out.println(employee.getParameterNumberName());
    }
}
