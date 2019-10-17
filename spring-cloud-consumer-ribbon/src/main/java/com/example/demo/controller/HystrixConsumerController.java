package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者
 */
@Slf4j
@RestController
@RequestMapping("/hystrix/consumer")
public class HystrixConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用 user微服务
     */
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @GetMapping("getUser")
    public String getUser(Integer id) {
        String url = "http://user-service/provider/getUser?id=" + id;
        return restTemplate.getForObject(url, String.class);
    }

    public String getDefaultUser(Integer id) {
        log.info("熔断，默认回调函数");
        return "{\"id\":-1,\"name\":\"熔断用户\",\"msg\":\"请求异常，返回熔断用户！\"}";
    }
}