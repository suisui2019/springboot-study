package com.example.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String hello() {
        return "Hello,user!";
    }
}
