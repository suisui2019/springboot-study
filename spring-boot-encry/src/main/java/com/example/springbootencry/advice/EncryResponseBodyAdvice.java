package com.example.springbootencry.advice;

import com.alibaba.fastjson.JSON;
import com.example.springbootencry.util.DesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

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
public class EncryResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //通过 ServerHttpRequest的实现类ServletServerHttpRequest 获得HttpServletRequest
        ServletServerHttpRequest sshr = (ServletServerHttpRequest) serverHttpRequest;
        //此处获取到request 是为了取到在拦截器里面设置的一个对象 是我项目需要,可以忽略
        HttpServletRequest request = sshr.getServletRequest();

        String returnStr = "";

        try {
            //添加encry header，告诉前端数据已加密
            serverHttpResponse.getHeaders().add("encry", "true");
            String srcData = JSON.toJSONString(obj);
            //加密
            returnStr = DesUtil.encrypt(srcData);
            log.info("接口={},原始数据={},加密后数据={}", request.getRequestURI(), srcData, returnStr);

        } catch (Exception e) {
            log.error("异常！", e);
        }
        return returnStr;
    }


}