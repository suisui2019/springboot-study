package com.example.springboot.mybatisannotation.service;


import com.example.springboot.mybatisannotation.entity.UserRole;

public interface UserRoleService {

    /**
     * 增加用户角色
     */
    int add(UserRole userRole);
}