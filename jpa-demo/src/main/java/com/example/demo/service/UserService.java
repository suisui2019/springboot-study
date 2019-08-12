package com.example.demo.service;


import com.example.demo.entity.User;

public interface UserService {
    public User getUser(Integer id);

    public void deleteUser(Integer id);
}