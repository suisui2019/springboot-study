package com.example.springbootinit.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        hello();
    }

    public void hello(){
        System.out.println("项目又启动了，这次使用的是：继承 ApplicationRunner");
    }
}
