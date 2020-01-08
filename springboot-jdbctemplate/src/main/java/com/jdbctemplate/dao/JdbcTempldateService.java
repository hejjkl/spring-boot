package com.jdbctemplate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class JdbcTempldateService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void getInfo(String idno){
        String lbcontsql="select * from sy_userinfo where idno =?";
        Map<String,Object> lbMap=jdbcTemplate.queryForMap(lbcontsql,idno);
    }
}
