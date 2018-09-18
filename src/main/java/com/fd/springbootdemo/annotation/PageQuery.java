package com.fd.springbootdemo.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PageQuery {

    String pageNumName() default "pageNum";//页号的参数名
    String pageSizeName() default "pageSize";//每页行数的参数名

}
