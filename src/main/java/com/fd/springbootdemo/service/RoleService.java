package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.OmRole;
import com.fd.springbootdemo.mapper.OmRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xyl
 * @Create 2018-09-21 17:14
 * @Desc 写点注释吧
 **/
@Service
public class RoleService {

    @Autowired
    private OmRoleMapper omRoleMapper;

    public List<OmRole> selectByUserId(Integer userId) {
        return omRoleMapper.selectByUserId(userId);
    }
}
