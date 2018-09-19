package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.Role;
import com.fd.springbootdemo.entity.UserRole;
import com.fd.springbootdemo.mapper.RoleMapper;
import com.fd.springbootdemo.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xyl
 * @Create 2018-09-19 19:09
 * @Desc 写点注释吧
 **/
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<Role> findByUserId(Integer uid) {
        List<Integer> list = userRoleMapper.findByUserId(uid);
        return roleMapper.findByUserId(list);
    }
}
