package com.example.springbootencry.controller;

import com.example.springbootencry.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Java碎碎念
 * @Date: 2019/10/24 21:40
 */
@RestController
public class TestController {

    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 响应数据 加密
     */
    @RequestMapping(value = "/sendResponseEncryData")
    public Result sendResponseEncryData() {
        Result result = Result.createResult().setSuccess(true);
        result.setDataValue("name", "Java碎碎念");
        result.setDataValue("encry", true);
        return result;
    }

    /**
     * 获取 解密后的 请求参数
     */
    @RequestMapping(value = "/getRequestData")
    public Result getRequestData(@RequestBody Object object) {
        log.info("controller接收的参数object={}", object.toString());
        Result result = Result.createResult().setSuccess(true);
        return result;
    }
}
