package com.iunin.mapper;

import com.iunin.dao.Demo;
import org.apache.ibatis.annotations.Select;

/**
 * @author: yonghui
 * @Description:
 * @Date: Created in 18:28 2018/1/31
 */
public interface DemoMapper {
    /**
     * 根据name查询Demo对象
     */
    @Select("select * from demo where name = #{name}")
    public Demo queryByName(String name);

    /**
     * 根据id查询Demo对象
     */
    @Select("select * from demo where id = #{id}")
    public Demo queryById(Integer id);

    /**
     * 根据id查询name
     */
    @Select("select name from demo where id = #{id}")
    public String queryNameById(Integer id);

}
