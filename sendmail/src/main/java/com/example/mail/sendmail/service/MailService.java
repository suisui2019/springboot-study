package com.example.mail.sendmail.service;


import com.example.mail.sendmail.dto.Email;

public interface MailService {


    /**
     * 发送邮件
     *
     * @Author: lifq
     */
    public void sendMail(Email email);

}