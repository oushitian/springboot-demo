package com.fd.springbootdemo.service;

import com.fd.springbootdemo.entity.Member;
import com.fd.springbootdemo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xyl
 * @Create 2018-10-20 16:34
 * @Desc 写点注释吧
 **/
@Service
public class MmenberService {

    @Autowired
    private MemberMapper memberMapper;

    public int save(Member member) {
        return memberMapper.insertSelective(member);
    }
}
