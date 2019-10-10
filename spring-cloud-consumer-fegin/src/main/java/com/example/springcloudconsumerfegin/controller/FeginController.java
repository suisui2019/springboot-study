package com.example.springcloudconsumerfegin.controller;

import com.example.springcloudconsumerfegin.service.IFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class FeginController {

    @Autowired
    private IFeginService feginService;

    @GetMapping("/getUser")
    public String getUser(Integer id) {
        return feginService.getUser(id);
    }
}