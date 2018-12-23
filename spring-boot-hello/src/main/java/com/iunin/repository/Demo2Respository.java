package com.iunin.repository;

import com.iunin.dao.Demo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author: yonghui
 * @Description:
 * @Date: Created in 8:13 2018/1/31
 */
public interface Demo2Respository extends CrudRepository<Demo,Integer> {

    /**
     * 1、查询方法以：get、find、read开头
     * 2、涉及查询条件时，条件的属性用条件关键字连接，要注意的是条件属性以首字母大写
     */
    // 根据name查询
    public Demo findByName(String name);

    /**
     * 如何编写JPQL语句
     * JPQL语句和HQL语句类似
     */
    @Query("select d from Demo d where d.name =:n" )
    public Demo findByName2(@Param("n") String name);

}
