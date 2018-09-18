package com.fd.springbootdemo.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-18 11:05
 * @Desc   封装相关的Page操作工具类
 **/
public class PageUtil {

    /**
     * 得到分页对象的封装
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getPageInfo(List<?> list){
        return (T) new PageInfo(list);
    }

}
