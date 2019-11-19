package com.example.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminController
 */
@RestController
public class AdminController {

    @GetMapping("/admin")
    public String hello() {
        return "Hello,admin!";
    }
}
