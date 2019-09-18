package com.example.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueCustomerController {
/*
 * 监听和接收  队列消息
 */
@JmsListener(destination="active.queue")
public void readActiveQueue(String message) {
    System.out.println("接受到：" + message);
}
}