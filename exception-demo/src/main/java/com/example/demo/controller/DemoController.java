package com.example.demo.controller;

import com.example.demo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DemoController {

    /**
     * 异常情况
     */
    @ResponseBody
    @RequestMapping(value = "/testException")
    public Result testException() {
        Result result = new Result(Result.RESULT_SUCCESS, "SUCCESS");
        //异常
        Integer.parseInt("abc");
        return result;
    }

    /**
     *正常情况
     */
    @ResponseBody
    @RequestMapping(value = "/testRight")
    public Result testRight() {
        Result result = new Result(Result.RESULT_SUCCESS, "SUCCESS");
        return result;
    }

}

