package com.example.springbootjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userName;
    private String name;
    private String password;
}
