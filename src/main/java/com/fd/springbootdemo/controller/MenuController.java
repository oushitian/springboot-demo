package com.fd.springbootdemo.controller;

import com.fd.springbootdemo.entity.OmMenu;
import com.fd.springbootdemo.entity.OmUser;
import com.fd.springbootdemo.service.MenuService;
import com.fd.springbootdemo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-21 13:34
 * @Desc 菜单控制器
 **/
@Controller
@RequestMapping("menu")
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取用户菜单
     */
    @RequestMapping("useMenu")
    @ResponseBody
    public List<OmMenu> queryUseMenu(HttpServletRequest request) {
        OmUser omUser = (OmUser) SecurityUtils.getSubject().getSession().getAttribute(Constant.USER_SESSION_KEY);
        log.info("获取用户菜单，用户ID：{}", omUser.getUserId());
        List<OmMenu> result = menuService.queryUseMenuFirst(omUser.getUserId());
        setMenuList(result);
        return result;
    }

    //多级菜单的递归调用
    private void setMenuList(List<OmMenu> menuList){
        for (OmMenu menu : menuList) {
            List<OmMenu> menus = menuService.queryUseMenuByMenuId(menu.getMenuId());
            menu.setChildren(menus);
            setMenuList(menus);
        }
    }
}
