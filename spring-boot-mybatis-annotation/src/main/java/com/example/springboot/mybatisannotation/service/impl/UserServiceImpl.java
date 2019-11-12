package com.example.springboot.mybatisannotation.service.impl;

import com.example.springboot.mybatisannotation.dao.mapper.UserMapper;
import com.example.springboot.mybatisannotation.entity.User;
import com.example.springboot.mybatisannotation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUsers() {
        log.info("/queryAllUsers start...");
        return userMapper.queryAllUsers();
    }

    /**
     * 增加用户
     */
    @Override
    @Transactional
    public int add(User user) {
        return userMapper.add(user);
    }
}
