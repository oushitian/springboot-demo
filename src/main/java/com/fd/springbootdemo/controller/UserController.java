package com.fd.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author fengdi
 * @Create 2018-09-17 9:46
 * @Desc 控制层
 **/
@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping("/toFreemarker")
    public String toFreemarker(Map<String, Object> map){
        map.put("name","fengdi");
        System.out.println("6666");
        return "/freemarker";
    }

    @RequestMapping("/HotDev")
    public String demo(){
        return "HotDev";
    }

}
