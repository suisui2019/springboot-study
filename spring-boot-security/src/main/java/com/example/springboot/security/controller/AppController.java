package com.example.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AppController
 */
@RestController
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello,spring security!";
    }
}
