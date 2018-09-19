package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.Permission;
import com.fd.springbootdemo.mapper.PermissionMapper;
import com.fd.springbootdemo.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xyl
 * @Create 2018-09-19 19:34
 * @Desc 写点注释吧
 **/
@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> findByRoleId(Integer roleId) {
        List<Integer> list = rolePermissionMapper.findByUserId(roleId);
        return permissionMapper.findByUserId(list);
    }
}
