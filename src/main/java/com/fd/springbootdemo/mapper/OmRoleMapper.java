package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.OmRole;

public interface OmRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(OmRole record);

    int insertSelective(OmRole record);

    OmRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(OmRole record);

    int updateByPrimaryKey(OmRole record);
}