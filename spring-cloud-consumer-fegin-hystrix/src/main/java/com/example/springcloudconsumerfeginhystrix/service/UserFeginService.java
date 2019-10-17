package com.example.springcloudconsumerfeginhystrix.service;

import com.example.springcloudconsumerfeginhystrix.service.impl.UserFeginFailBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//表示"user-service"的服务，指定fallback
@FeignClient(value = "user-service", fallback = UserFeginFailBackImpl.class)
public interface UserFeginService {

    @RequestMapping(value = "/provider/getUser")
    public String getUser(@RequestParam("id") Integer id);
}