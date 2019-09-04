package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 异常全局处理类
 *
 * @author
 **/
@Slf4j
@ControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handlerException(HttpServletResponse response, Exception e) throws Exception {
        log.info("异常信息", e);
        Result result = new Result(Result.RESULT_FAIL, "error :" + e.getMessage());
        return result;
    }
}
