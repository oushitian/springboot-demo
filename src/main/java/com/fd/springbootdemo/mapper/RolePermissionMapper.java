package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    @Select("select permission_id from role_permission where role_id = #{roleId}")
    List<Integer> findByUserId(@Param("roleId") Integer roleId);
}