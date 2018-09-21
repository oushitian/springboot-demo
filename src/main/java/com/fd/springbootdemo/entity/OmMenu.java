package com.fd.springbootdemo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OmMenu {
    private Integer menuId;

    private Integer parentId;

    private String menuText;

    private String menuUrl;

    private Integer permisId;

    private Byte enableFlag;

    private Integer menuOrder;

    private Date createTime;

    private Date updateTime;

    private String icon;

    private List<OmMenu> children;
}