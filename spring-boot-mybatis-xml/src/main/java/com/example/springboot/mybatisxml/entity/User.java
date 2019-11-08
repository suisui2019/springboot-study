package com.example.springboot.mybatisxml.entity;

import lombok.Data;
/**
 * User实体类
 *
 * @Author: java_suisui
 *
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer sex;
    private String des;

}