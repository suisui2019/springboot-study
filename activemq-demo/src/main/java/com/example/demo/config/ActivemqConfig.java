package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * ActivemqConfig配置类
 */
@Configuration
public class ActivemqConfig {

/**
 * 点对点
 */
@Bean
public Queue queue() {
    return new ActiveMQQueue("active.queue");
}

/**
 * 发布/订阅
 */
@Bean
public Topic topic() {
    return new ActiveMQTopic("active.topic");
}

}
