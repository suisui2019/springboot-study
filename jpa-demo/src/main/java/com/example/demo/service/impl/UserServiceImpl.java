package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    
    @Override
    public User getUser(Integer id) {
        //有两种方式：
        //1.调用crudRepository的接口
//        return repository.findOne(id);
        //2.调用我们自己写的接口
        return repository.getUser(id);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    
}