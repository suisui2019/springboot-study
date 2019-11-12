package com.example.springboot.mybatisannotation.service;


import com.example.springboot.mybatisannotation.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUsers();

    /**
     * 增加用户
     *
     */
    int add(User user);
}