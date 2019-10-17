package com.example.springcloudconsumerfeginhystrix.service.impl;

import com.example.springcloudconsumerfeginhystrix.service.UserFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFeginFailBackImpl implements UserFeginService {

    @Override
    public String getUser(Integer id) {
        log.info("熔断，默认回调函数");
        return "{\"id\":-1,\"name\":\"熔断用户\",\"msg\":\"请求异常，返回熔断用户！\"}";
    }
}