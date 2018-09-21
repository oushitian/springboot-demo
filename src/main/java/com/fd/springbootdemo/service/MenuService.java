package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.OmMenu;
import com.fd.springbootdemo.mapper.OmMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-21 13:35
 * @Desc 菜单业务层
 **/
@Service
public class MenuService {

    @Autowired
    private OmMenuMapper omMenuMapper;

    public List<OmMenu> queryUseMenuFirst(Integer userId) {
        return omMenuMapper.queryUseMenuFirst(userId);
    }

    public List<OmMenu> queryUseMenuByMenuId(Integer menuId) {
        return omMenuMapper.queryUseMenuByMenuId(menuId);
    }
}
