package com.example.springboot.mybatisxml.dao.mapper;


import com.example.springboot.mybatisxml.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> queryAllUsers();
}