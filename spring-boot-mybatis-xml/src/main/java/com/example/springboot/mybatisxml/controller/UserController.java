package com.example.springboot.mybatisxml.controller;

import com.example.springboot.mybatisxml.entity.User;
import com.example.springboot.mybatisxml.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @Author: java_suisui
 *
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询 所有用户
     *
     */
    @GetMapping("/queryAllUsers")
    public List<User> queryAllUsers(){
        return userService.queryAllUsers();
    }
}
