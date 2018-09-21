package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.RolePermis;

public interface RolePermisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermis record);

    int insertSelective(RolePermis record);

    RolePermis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermis record);

    int updateByPrimaryKey(RolePermis record);
}