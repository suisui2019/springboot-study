package com.example.mail.sendmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class SendMailApplication {

    public static void main(String[] args) {
        //java mail发邮件是附件名过长默认会被截断，附件名显示【tcmime.29121.29517.50430.bin】，主动设为false可正常显示附件名
        System.setProperty("mail.mime.splitlongparameters", "false");
        SpringApplication.run(SendMailApplication.class, args);
    }

}
