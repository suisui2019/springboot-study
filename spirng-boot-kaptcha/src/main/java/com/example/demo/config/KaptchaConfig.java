package com.example.demo.config;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

/**
 * KaptchaConfig
 */
@Configuration
public class KaptchaConfig implements WebMvcConfigurer {

    /**
     * 验证码 生成的bean
     */
    @Bean
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "100");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "30");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "22");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "6");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "LIGHT_GRAY");
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "WHITE");
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, "checkCode");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;
    }

}