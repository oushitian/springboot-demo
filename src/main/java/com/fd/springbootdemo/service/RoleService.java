package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.Role;
import com.fd.springbootdemo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-18 16:02
 * @Desc 业务层
 **/
@Service
public class RoleService {

    @Autowired
    private RoleMapper mapper;

    public List<Role> findRoleList() {
        return mapper.findRoleList();
    }
}
