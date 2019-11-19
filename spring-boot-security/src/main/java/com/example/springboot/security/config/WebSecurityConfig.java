package com.example.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置类
 * @Author java_suisui
 *
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置内存中的 用户名、密码和角色
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("user").password("123456").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("123456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/user").hasRole("USER") //访问 /user这个接口，需要有USER角色
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated() //剩余的其他接口，登录之后就能访问
                .and()
                .formLogin().defaultSuccessUrl("/hello");
    }
}