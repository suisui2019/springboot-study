package com.example.springbootinit.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 */

@Component
public class PostConstructInit {

    @Autowired
    TestService testService;

    @PostConstruct
    public void init() {
        System.out.println("PostConstructInit  init");
        testService.getTestData();
        System.out.println("PostConstructInit  end");
    }
}
