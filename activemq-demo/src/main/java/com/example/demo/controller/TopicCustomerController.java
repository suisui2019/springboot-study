package com.example.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicCustomerController {
/*
 * 监听和接收  主题消息
 */
@JmsListener(destination = "active.topic")
public void readActiveTopic1(String message) {
    System.out.println("Customer1接受到：" + message);
}

/*
 * 监听和接收  主题消息
 */
@JmsListener(destination = "active.topic")
public void readActiveTopic2(String message) {
    System.out.println("Customer2接受到：" + message);
}
}