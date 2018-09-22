package com.fd.springbootdemo.entity.vo;

import java.util.List;

/**
 * mybatis分页组件接受的形式为，所以封装成具体的实体类
 * {total:"100",rows:[{"id":"1" , "name":"aaa"},{"id":"2" , "name":"bbb"}]}
 */
public class DataGridResult {

    private Long total;
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
