package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务
 */
@Slf4j
@RestController
@RequestMapping("/provider")
public class UserController {

    static Map<Integer, User> userMap = new HashMap<>();

//    static {
//        //模拟数据库
//        User user1 = new User(1, "张三", "123456");
//        userMap.put(1, user1);
//        User user2 = new User(2, "李四", "123123");
//        userMap.put(2, user2);
//    }

    /**
     * 根据id 查询
     */
    @RequestMapping("/getUser")
    public String getUser(Integer id) {
        log.info("调用getUser接口,id={}",id);
        User user = userMap.get(id);
        return JSON.toJSONString(user);
    }

}
