package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.OmPermis;

public interface OmPermisMapper {
    int deleteByPrimaryKey(Integer permisId);

    int insert(OmPermis record);

    int insertSelective(OmPermis record);

    OmPermis selectByPrimaryKey(Integer permisId);

    int updateByPrimaryKeySelective(OmPermis record);

    int updateByPrimaryKey(OmPermis record);
}