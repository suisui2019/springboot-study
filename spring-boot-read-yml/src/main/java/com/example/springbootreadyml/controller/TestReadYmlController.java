package com.example.springbootreadyml.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootreadyml.config.WxMpProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取yml文件的controller
 *
 * @Authro Java碎碎念
 */
@Slf4j
@RestController
public class TestReadYmlController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private WxMpProperties wxMpProperties;

    @RequestMapping("/readYml")
    public void readYml() {
        log.info("server.port=" + port);
        log.info("wxMpProperties=" + JSON.toJSONString(wxMpProperties));
    }
}


