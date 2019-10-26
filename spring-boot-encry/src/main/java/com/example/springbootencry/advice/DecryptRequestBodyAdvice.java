package com.example.springbootencry.advice;

import com.alibaba.fastjson.JSON;
import com.example.springbootencry.util.DesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 请求参数 解密操作
 *
 * @Author: Java碎碎念
 * @Date: 2019/10/24 21:31
 *
 */
@Component
@ControllerAdvice(basePackages = "com.example.springbootencry.controller")
@Slf4j
public class DecryptRequestBodyAdvice implements RequestBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> selectedConverterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        String dealData = null;
        try {
            //解密操作
            Map<String,String> dataMap = (Map)body;
            log.info("接收到原始请求数据={}", JSON.toJSONString(dataMap));
            String srcData = dataMap.get("data");
            dealData = DesUtil.decrypt(srcData);
            log.info("解密后数据={}",dealData);
        } catch (Exception e) {
            log.error("异常！", e);
        }
        return dealData;
    }


    @Override
    public Object handleEmptyBody(@Nullable Object var1, HttpInputMessage var2, MethodParameter var3, Type var4, Class<? extends HttpMessageConverter<?>> var5) {
        return var1;
    }


}