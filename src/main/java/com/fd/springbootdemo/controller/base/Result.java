package com.fd.springbootdemo.controller.base;


/**
 * @Author xyl
 * @Create 2018-09-19 13:35
 * @Desc 统一的返回类
 **/
public class Result<T> {
    private ResultCodeEnum code;
    private String message;
    private  T data;

    public ResultCodeEnum getCode() {
        return code;
    }

    public Result() {
    }

    public Result setCode(ResultCodeEnum resultCode) {
        this.code = resultCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
