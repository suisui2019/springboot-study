package com.example.springboot.mybatisannotation.service.impl;

import com.example.springboot.mybatisannotation.dao.mapper.UserMapper;
import com.example.springboot.mybatisannotation.dao.mapper.UserRoleMapper;
import com.example.springboot.mybatisannotation.entity.User;
import com.example.springboot.mybatisannotation.entity.UserRole;
import com.example.springboot.mybatisannotation.service.UserRoleService;
import com.example.springboot.mybatisannotation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;



    /**
     * 增加用户角色
     */
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public int add(UserRole userRole) {
        return userRoleMapper.add(userRole);
    }
}
