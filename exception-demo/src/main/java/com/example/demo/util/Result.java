package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 封装返回类
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;

    //返回代码
    private Integer  code;

    //返回消息
    private String message;

    //返回对象
    private  Object data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.data = object;
    }
}