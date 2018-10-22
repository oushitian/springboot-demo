package com.fd.springbootdemo.controller;

import com.fd.springbootdemo.controller.base.Result;
import com.fd.springbootdemo.controller.base.ResultCodeEnum;
import com.fd.springbootdemo.entity.OmUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author fengdi
 * @Create 2018-09-19 9:27
 * @Desc 登入控制器
 **/
@Controller
@RequestMapping
@Slf4j
public class LoginController {

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map){
        log.info("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    /**
     * 登录方法(前后端分离)
     * @param user
     * @return
     */
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result ajaxLogin(OmUser user) {
        Map<String,String> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            return new Result<>().setCode(ResultCodeEnum.SUCCESS).setMessage("登录成功").setData(subject.getSession().getId().toString());
        } catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }

    /**
     * 登出ShiroConfig的filterChainDefinitionMap.put("/logout", "logout");配置了，所以这方法不配也可以
     */
    @RequestMapping("/logout")
    public void onLogout() {
        log.info("退出登录");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        log.error("没有权限");
        return "403";
    }
}
