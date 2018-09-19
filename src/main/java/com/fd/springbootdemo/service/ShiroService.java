package com.fd.springbootdemo.service;

import org.springframework.stereotype.Service;

/**
 * @Author xyl
 * @Create 2018-09-19 12:09
 * @Desc 写点注释吧
 **/
@Service
public class ShiroService {

    public String getPasswordByUsername(String username){
        switch (username){
            case "liming":
                return "123";
            case "hanli":
                return "456";
            default:
                return null;
        }
    }
}
