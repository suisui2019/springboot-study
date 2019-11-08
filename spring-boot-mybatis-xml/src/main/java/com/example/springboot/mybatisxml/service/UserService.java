package com.example.springboot.mybatisxml.service;


import com.example.springboot.mybatisxml.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUsers();
}