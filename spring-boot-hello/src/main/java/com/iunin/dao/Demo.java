package com.iunin.dao;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: yonghui
 * @Description: 创建了一个实体类
 * 问题一：如何进行持久化呢？
 * 使用@Entity进行实体类的持久化操作，当JPA检测到我们的实体类当中有
 * @Entity：注解的时候，会在数据库中生成对应的表结构信息
 *
 * 问题二：如何指定主键以及主键的生成策略？
 * 使用@Id指定主键
 * @Date: Created in 9:48 2018/1/30
 */
@Entity
public class Demo {
    /**
     * 使用@Id指定主键
     * 使用@GeneratedValue(strategy = GenerationType.AUTO)指定主键生成策略，MySQL默认的是自增长
     */
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;//主键
    private String name;//姓名
    // import com.alibaba.fastjson.annotation.JSONField;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;//创建时间
    // 是否需要序列化属性
    @JSONField(serialize = true)
    private String remarks;//备注信息

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
