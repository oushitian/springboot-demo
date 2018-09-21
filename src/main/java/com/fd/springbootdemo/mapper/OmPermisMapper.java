package com.fd.springbootdemo.mapper;

import com.fd.springbootdemo.entity.OmPermis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmPermisMapper {
    int deleteByPrimaryKey(Integer permisId);

    int insert(OmPermis record);

    int insertSelective(OmPermis record);

    OmPermis selectByPrimaryKey(Integer permisId);

    int updateByPrimaryKeySelective(OmPermis record);

    int updateByPrimaryKey(OmPermis record);

    List<OmPermis> selectByUserId(@Param("userId") Integer userId);
}