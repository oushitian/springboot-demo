package com.fd.springbootdemo.entity;

import lombok.Data;

/**
 * @Author fengdi
 * @Create 2018-09-18 15:58
 * @Desc 写点注释吧
 **/
@Data
public class Role {

    /**
     * 角色id
     */
    protected Long id;

    /**
     * 角色编号
     */
    protected String roleCode;

    /**
     * 角色名称
     */
    protected String roleName;
    /**
     * 状态   0:可用   1:不可用
     */
    protected Integer status;
}
