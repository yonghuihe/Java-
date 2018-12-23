package com.iunin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: yonghui
 * @Description: JdbcTemplate
 * 1、在类上@Repository注解,标注这是一个持久化操作对象
 * 2、引入JdbcTemplate
 * @Date: Created in 10:30 2018/1/31
 */
@Repository
public class DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Demo getByName(String name){
        String sql = "SELECT * FROM demo WHERE name = ?";
        RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<>(Demo.class);
        Demo demo = jdbcTemplate.queryForObject(sql,new Object[]{name},rowMapper);// 这里需要的参数是object数组类型的
        return demo;
    }

    public Demo getById(Integer id){
        String sql = "SELECT * FROM demo WHERE id = ?";
        RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<>(Demo.class);
        Demo demo = jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper);// 这里需要的参数是object数组类型的
        return demo;
    }

}
