package com.example.springbootlog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestLogController
 */
@RestController
public class TestLogController {

    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 测试登录
     */
    @RequestMapping(value = "/testLogin")
    public String testLogin() {
        log.info("用户登录成功！");
        return "ok";
    }

    /**
     * 测试下单
     */
    @RequestMapping(value = "/testNewOrder")
    public String testNewOrder() {
        log.info("用户创建了订单！");
        log.info("请求完成，返回ok！");
        return "ok";
    }

    /**
     * 测试购买
     */
    @RequestMapping(value = "/testPay")
    public String testPay() {
        log.info("用户付款！");
        return "ok";
    }


}
