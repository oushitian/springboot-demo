package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.OmMenu;

import java.util.List;

public interface OmMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(OmMenu record);

    int insertSelective(OmMenu record);

    OmMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(OmMenu record);

    int updateByPrimaryKey(OmMenu record);

    List<OmMenu> queryUseMenuFirst(Integer userId);

    List<OmMenu> queryUseMenuByMenuId(Integer parentId);
}