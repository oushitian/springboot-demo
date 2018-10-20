package com.fd.springbootdemo.controller.member;

import com.fd.springbootdemo.entity.Member;
import com.fd.springbootdemo.service.MmenberService;
import com.fd.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author xyl
 * @Create 2018-10-20 16:32
 * @Desc 写点注释吧
 **/
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MmenberService memeberService;

    @RequestMapping("/save")
    public int save(@RequestBody Member member){
        return memeberService.save(member);
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne(Integer id){
        return id + "";
    }

}
