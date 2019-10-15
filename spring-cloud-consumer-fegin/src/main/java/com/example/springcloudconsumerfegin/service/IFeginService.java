package com.example.springcloudconsumerfegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//表示"user-service"的服务 提供
@FeignClient(value = "user-service")
public interface IFeginService {
 
    @RequestMapping(value = "/provider/getUser")
    public String getUser(@RequestParam("id") Integer id);
}