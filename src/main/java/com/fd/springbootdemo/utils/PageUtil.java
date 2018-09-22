package com.fd.springbootdemo.utils;

import com.fd.springbootdemo.entity.vo.DataGridResult;
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
     * @return
     */
    public static DataGridResult getPageInfo(List<?> list){
        PageInfo<?> pageInfo = new PageInfo(list);
        DataGridResult dataGridResult = new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(list);
        return  dataGridResult;
    }

}
