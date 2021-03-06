package com.fd.springbootdemo.service;

import com.fd.springbootdemo.annotation.PageQuery;
import com.fd.springbootdemo.entity.OmUser;
import com.fd.springbootdemo.mapper.OmUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author fengdi
 * @Create 2018-09-17 19:30
 * @Desc 写点注释吧
 **/
@Service
@Slf4j
public class UserService {

    @Autowired
    private OmUserMapper omUserMapper;

//    public PageInfo<User> getUserList(int page, int pageSize){
//        // 开启分页插件,放在查询语句上面
//        //利用aop和注解优化次代码
//        PageHelper.startPage(page,pageSize);
//        List<User> list = mapper.findUserList();
//        PageInfo<User> pageInfoUser = new PageInfo<User>(list);
//        return pageInfoUser;
//    }

//    @PageQuery(pageNumName = "page",pageSizeName = "size")//和默认名字不一样的这里需要指明
//    public List<User> getUserListByAnnotation(){
//        return mapper.findUserList();
//    }

    public OmUser findUser(String name) {
        return omUserMapper.selectByUserName(name);
    }


    @PageQuery(pageNumName = "page",pageSizeName = "rows")//和默认名字不一样的这里需要指明
    public List<OmUser> getUserList() {
        return omUserMapper.findUserList();
    }

//    @Async//相当于新开了一个线程执行任务
//    public void testAsync() {
//        log.info("this is asynv");
//    }
//
//    public int insert(User user) {
//        return mapper.insert(user);
//    }
}
