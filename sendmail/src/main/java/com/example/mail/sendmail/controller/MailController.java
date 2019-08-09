package com.example.mail.sendmail.controller;

import com.example.mail.sendmail.dto.Email;
import com.example.mail.sendmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: java碎碎念
 * @Description:
 */
@Controller
public class MailController {

    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/sendMail")
    public String sendEmail() {
        Email email_email = new Email();
        List<String> addressList = new ArrayList<String>();
        addressList.add("xxx@163.com");
        email_email.setToAddress(addressList);
        email_email.setSubject("java碎碎念-主题测试");// 主题
        email_email.setContent("你好！<br><br> 测试邮件发送成功！");
        // 发送邮件
        mailService.sendMail(email_email);

        return "ok";
    }
}
