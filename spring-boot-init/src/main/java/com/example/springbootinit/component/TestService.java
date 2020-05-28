package com.example.springbootinit.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 */
@Slf4j
@Component
public class TestService {

    void getTestData() {
        System.out.println("TestService get data");
    }
}
