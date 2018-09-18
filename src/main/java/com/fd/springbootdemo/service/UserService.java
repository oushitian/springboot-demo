package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.User;
import com.fd.springbootdemo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-17 19:30
 * @Desc 写点注释吧
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public PageInfo<User> getUserList(int page,int pageSize){
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page,pageSize);
        List<User> list = mapper.findUserList();
        PageInfo<User> pageInfoUser = new PageInfo<User>(list);
        return pageInfoUser;
//        return PageUtil.getPageInfo(mapper.findUserList(),page,pageSize);
    }

    public User findUser(String name) {
        return mapper.findByName(name);
    }
}
