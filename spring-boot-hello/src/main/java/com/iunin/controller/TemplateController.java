package com.iunin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author: yonghui
 * @Description:
 * @Date: Created in 12:04 2018/1/31
 */
@Controller
public class TemplateController {

    /**
     * 返回FreeMarker模板
     */
    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("username","zy");
        return "/helloFtl";
    }

    @RequestMapping("/helloThymeleaf")
    public String helloThymeleaf(Map<String,Object> map){
        map.put("username","hyh");
        return "helloThymeleaf";
    }

    @RequestMapping("/index")
    public String jsp(){
        return "index";
    }
}
