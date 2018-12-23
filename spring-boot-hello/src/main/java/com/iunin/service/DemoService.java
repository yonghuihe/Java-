package com.iunin.service;

import com.iunin.dao.Demo;
import com.iunin.dao.DemoDao;
import com.iunin.mapper.DemoMapper;
import com.iunin.repository.Demo2Respository;
import com.iunin.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: yonghui
 * @Description:
 * @Date: Created in 20:34 2018/1/30
 */
@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private Demo2Respository demo2Respository;

    @Autowired
    private DemoDao demoDao;

    @Autowired
    private DemoMapper demoMapper;

    /**
     * save、update、delete：方法需要绑定事务
     *
     * 使用@Transactional进行事务的绑定
     *
     * @param demo
     */

    // 保存/更改数据
    @Transactional
    public void save(Demo demo){
        demoRepository.save(demo);
    }

    // 删除数据
    @Transactional
    public void delete(Integer id){
        demoRepository.delete(id);
    }

    // 查询所有数据
    public Demo getOne(Demo demo){
        return demoRepository.findOne(demo.getId());
    }

    // 查询所有数据（慎用！！！）
    public Iterable<Demo> getAll(){
        return demoRepository.findAll();
    }

    // 根据名称查询对象
    public Demo findByName(String name){
        System.out.println(name);
        Demo demo = demo2Respository.findByName(name);
        System.out.println(demo);
        return demo;
    }

    // 通过名称查询对象
    public Demo findByName2(String name){
        Demo demo = demo2Respository.findByName2(name);
        return demo;
    }

    // 根据name查询Demo对象
    public Demo getByName(String name){
        return demoDao.getByName(name);
    }

    // 根据id查询Demo对象
    public Demo getById(Integer id){
        return demoDao.getById(id);
    }
    //=========================================================================

    // 根据名称查询Demo对象
    public Demo queryByName(String name){
        Demo demo = demoMapper.queryByName(name);
        return demo;
    }

    // 根据id查询Demo对象
    public Demo queryById(Integer id){
        Demo demo = demoMapper.queryById(id);
        return demo;
    }

    // 根据id查询name
    public String queryNameById(Integer id){
        String name = demoMapper.queryNameById(id);
        return name;
    }

}
