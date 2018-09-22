package com.fd.springbootdemo.controller;


import com.fd.springbootdemo.entity.vo.DataGridResult;
import com.fd.springbootdemo.service.UserService;
import com.fd.springbootdemo.utils.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author fengdi
 * @Create 2018-09-17 9:46
 * @Desc 控制层
 **/
@Controller
@RequestMapping("/user")
@Slf4j//lombok的日志记录 ,只要配置了log4j.properties就可以了
@Api(value = "usercontroller",description = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户查询.
     * @return
     */
    @ApiOperation(value ="查询所有用户",notes ="",httpMethod = "POST")
    @RequestMapping("/userList")
    @RequiresPermissions("person_kaoqin")//权限管理;
    public String userInfo(){
        return "userList";
    }

    /**
     * 用户查询.
     * @return
     */

    @RequestMapping("/findUserList")
    @ResponseBody
    public DataGridResult userInfos(){
        return PageUtil.getPageInfo(userService.getUserList());
    }

//    @RequestMapping("/exceptionTest")
//    public String exceptionTest(){
//        int i = 1/0;
//        return "exceptionTest";
//    }

//    @ApiOperation(value = "新增用户",notes = "",httpMethod = "POST")
//    @ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
//    @PostMapping("/user")
//    public String createUser(@RequestBody User user){
//        int num =  userService.insert(user);
//        if(num>0){
//            return "success";
//        }
//        return "error";
//    }

//    @ApiOperation(value = "查询用户",notes = "分页查询",httpMethod = "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page",value = "分页数",required = true,dataType = "Integer"),
//            @ApiImplicitParam(name = "pageSize",value = "分页行数",required = true,dataType = "Integer")
//    })
//    @RequestMapping("/getUserList")
//    @ResponseBody
//    public PageInfo<User> getUserList(Integer page, Integer pageSize){
//        return userService.getUserList(page,pageSize);
//    }

//    @RequestMapping("/getUserListByAnnotation")
//    @ResponseBody
//    public PageInfo<User> getUsrListByAnnotation(){
//        return PageUtil.getPageInfo(userService.getUserListByAnnotation());
//    }

//    @RequestMapping("/testAsynv")
//    public String testAsync(){
//        userService.testAsync();
//        return "1";
//    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public String updatePwd(String newpass){
        return "success";
    }
}
