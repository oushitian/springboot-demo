package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author xyl
 * @Create 2018-09-18 16:03
 * @Desc 写点注释吧
 **/
@Repository
public interface RoleMapper {

    @Select("SELECT * FROM sys_role ")
    List<Role> findRoleList();

}
