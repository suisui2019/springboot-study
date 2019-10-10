package com.example.springcloudconsumerfegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//表示"user-service"的服务 提供
@FeignClient(value = "user-service")
public interface IFeginService {
 
    @RequestMapping(value = "/provider/getUser")
    public String getUser(Integer id);
}