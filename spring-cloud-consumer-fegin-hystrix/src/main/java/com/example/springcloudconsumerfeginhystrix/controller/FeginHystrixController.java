package com.example.springcloudconsumerfeginhystrix.controller;

import com.example.springcloudconsumerfeginhystrix.service.UserFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix/consumer")
public class FeginHystrixController {

    @Autowired
    private UserFeginService userFeginService;

    @GetMapping("/getUser")
    public String getUser(Integer id) {
        return userFeginService.getUser(id);
    }
}