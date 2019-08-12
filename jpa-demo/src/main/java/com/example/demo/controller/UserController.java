package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

    /**
     * 根据id 查询
     */
    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return service.getUser(id);
    }

    /**
     * 根据id 删除
     */
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        service.deleteUser(id);
        return "删除成功！";
    }

}