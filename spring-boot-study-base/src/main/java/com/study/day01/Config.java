package com.study.day01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: lifq
 * @Description:
 */
@Configuration
public class Config {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService window() {
        return new WindowsService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linux() {
        return new LinuxService();
    }
}
