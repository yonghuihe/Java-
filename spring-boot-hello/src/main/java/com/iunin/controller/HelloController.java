package com.iunin.controller;

import com.iunin.dao.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: yonghui
 * @Description:
 * @Date: Created in 9:46 2018/1/30
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/hello1")
    public String hello1(){
        return "hello1";
    }

    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("张三");
        demo.setCreateTime(new Date());
        demo.setRemarks("这是一个备注信息");
        return demo;
    }

}
