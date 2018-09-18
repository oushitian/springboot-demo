package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-17 19:23
 * @Desc 写点注释吧
 **/
@Repository//不写也可以，只是编译的时候会报错
public interface UserMapper {

    @Select("SELECT * FROM user ")
    List<User> findUserList();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);
//    @Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);


}
