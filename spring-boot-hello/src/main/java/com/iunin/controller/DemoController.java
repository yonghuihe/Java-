package com.iunin.controller;

import com.iunin.dao.Demo;
import com.iunin.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: yonghui
 * @Description:
 * @Date: Created in 20:54 2018/1/30
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("")
    public String index(){
        return "欢迎访问demo页面";
    }

    @RequestMapping("/save")
    public String save(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("李四");
        demo.setCreateTime(new Date());
        demo.setRemarks("添加了一个李四");
        demoService.save(demo);
        return "save ok";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        demoService.delete(id);//根据页面传入的id删除对象
        return "delete ok";
    }

    @RequestMapping("/getOne")
    public Demo getOne(){
        Demo demo = new Demo();
        demo.setId(2);
        return demoService.getOne(demo);
    }

    @RequestMapping("/getAll")
    public Iterable<Demo> getAll(){
        return demoService.getAll();
    }

    @RequestMapping("/findByName")
    public Demo fingByName(String demoName){
        Demo demo = demoService.findByName(demoName);
        return demo;
    }

    @RequestMapping("/findByName2")
    public Demo fingByName2(String demoName){
        System.out.println(demoName);
        Demo demo = demoService.findByName2(demoName);
        return demo;
    }

    @RequestMapping("/getByName")
    public Demo getByName(String name){
        return demoService.getByName(name);
    }

    @RequestMapping("/getById")
    public Demo getById(Integer id){
        return demoService.getById(id);
    }
    //========================================================================
    @RequestMapping("/queryByName")
    public Demo queryByName(String name){
        Demo demo = demoService.queryByName(name);
        return demo;
    }

    @RequestMapping("/queryById")
    public Demo queryById(Integer id){
        Demo demo = demoService.queryById(id);
        return demo;
    }

    @RequestMapping("/queryNameById")
    public String queryNameById(Integer id){
        String name = demoService.queryNameById(id);
        return name;
    }
}
