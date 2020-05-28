package com.example.springbootinit.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)   //通过order值的大小来决定启动的顺序
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        askForLeave();
    }

    public void askForLeave(){
        System.out.println("项目启动了，执行了方法1111");
    }
}