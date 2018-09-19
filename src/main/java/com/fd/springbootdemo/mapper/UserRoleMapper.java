package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    @Select("select role_id from user_role where user_id = #{userId}")
    List<Integer> findByUserId(@Param("userId") Integer userId);

}