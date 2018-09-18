package com.fd.springbootdemo.controller;

import com.fd.springbootdemo.annotation.PageQuery;
import com.fd.springbootdemo.entity.Role;
import com.fd.springbootdemo.entity.User;
import com.fd.springbootdemo.service.RoleService;
import com.fd.springbootdemo.service.UserService;
import com.fd.springbootdemo.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author fengdi
 * @Create 2018-09-17 9:46
 * @Desc 控制层
 **/
@Controller
@RequestMapping("/")
@Slf4j//lombok的日志记录 ,只要配置了log4j.properties就可以了
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public String toIndex(){
        return "roleList";
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList(){
        List<Role> roleList = roleService.findRoleList();
        return roleList;
    }

    @RequestMapping("/toFreemarker")
    public String toFreemarker(Map<String, Object> map){
        map.put("name","fengdi");
        log.info("666");
        return "/freemarker";
    }

    @RequestMapping("/HotDev")
    public String demo(){
        return "HotDev";
    }

    @RequestMapping("/exceptionTest")
    public String exceptionTest(){
        int i = 1/0;
        return "exceptionTest";
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public String findUser(String name){
        User user = userService.findUser(name);
        return user.toString();
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public PageInfo<User> getUserList(int page, int pageSize){
        return userService.getUserList(page,pageSize);
    }

    @RequestMapping("/getUserListByAnnotation")
    @ResponseBody
    public PageInfo<User> getUsrListByAnnotation(){
        return PageUtil.getPageInfo(userService.getUserListByAnnotation());
    }

    @RequestMapping("/testAsynv")
    public String testAsync(){
        userService.testAsync();
        return "1";
    }
}
