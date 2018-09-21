package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.OmPermis;
import com.fd.springbootdemo.mapper.OmPermisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xyl
 * @Create 2018-09-21 17:26
 * @Desc 写点注释吧
 **/
@Service
public class PermisService {

    @Autowired
    private OmPermisMapper omPermisMapper;

    public List<OmPermis> selectByUserId(Integer userId) {
        return omPermisMapper.selectByUserId(userId);
    }
}
