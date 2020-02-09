package com.yookie.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@SpringBootApplication
public class MapApplication {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public List<TestUser> index(){
        String sql  = "select * from test_user";

        List<TestUser> userList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            TestUser user = new TestUser();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        });

        return userList;
    }

    @RequestMapping("/test")
    public WindRose getWind(){
        WindRose windRose = new WindRose(new Head(1,1,1.0f,1.0f));
        return windRose;

    }

    public static void main(String[] args) {
        SpringApplication.run(MapApplication.class, args);
    }

}
