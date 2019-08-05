package com.study.day01;

import org.springframework.stereotype.Service;

/**
 * @Auther: lifq
 * @Description:
 */
public class WindowsService implements ListService{
    public String showListCmd() {
        return  "dir";
    }
}
