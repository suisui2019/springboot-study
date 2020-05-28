package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    @org.junit.Test
    public void testFastJson() {
        Map<String, Object> dataMap = new HashMap<>();
        List<User> userList1 = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId(i);
            userList1.add(user);
            userList2.add(user);
        }
        dataMap.put("userList1", userList1);
        dataMap.put("userList2", userList2);

        System.out.println(JSON.toJSONString(dataMap));
    }


}

