package com.study.day01;

import org.springframework.stereotype.Service;

/**
 * @Auther: lifq
 * @Description:
 */
public class LinuxService implements ListService{
    public String showListCmd() {
        return  "ls";
    }
}
