package com.example.springboot.mybatisannotation.entity;

import lombok.Data;

/**
 * UserRole实体类
 *
 * @Author: java_suisui
 *
 */
@Data
public class UserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;

}