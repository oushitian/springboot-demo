package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.OmRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(OmRole record);

    int insertSelective(OmRole record);

    OmRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(OmRole record);

    int updateByPrimaryKey(OmRole record);

    List<OmRole> findByUserId(Integer userId);

    List<OmRole> selectByUserId(@Param("userId") Integer userId);
}