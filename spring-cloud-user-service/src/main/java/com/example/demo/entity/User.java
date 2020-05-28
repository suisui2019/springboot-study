package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: lifq
 * @Description:
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String password;
}
