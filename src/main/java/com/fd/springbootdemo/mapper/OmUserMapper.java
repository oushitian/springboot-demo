package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.OmUser;
import org.apache.ibatis.annotations.Param;

public interface OmUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(OmUser record);

    int insertSelective(OmUser record);

    OmUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(OmUser record);

    int updateByPrimaryKey(OmUser record);

    OmUser selectByUserName(@Param("userName") String userName);
}