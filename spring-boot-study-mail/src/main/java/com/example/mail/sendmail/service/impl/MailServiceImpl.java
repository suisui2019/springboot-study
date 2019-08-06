package com.example.mail.sendmail.service.impl;

import com.example.mail.sendmail.dto.Email;
import com.example.mail.sendmail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;

/**
 * 邮件实现类
 *
 * @Auther: java碎碎念
 * @Description:
 */
@Service
public class MailServiceImpl implements MailService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailUserName;

    Logger log = LoggerFactory.getLogger(MailServiceImpl.class);


    /**
     * 发送邮件
     *
     * @Author: java碎碎念
     */
    public void sendMail(Email email) {
        long start = System.currentTimeMillis();
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(mailUserName);
            helper.setTo(email.getToAddress().toArray(new String[email.getToAddress().size()]));
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);

            if (null != email.getAttachments() && email.getAttachments().size() > 0) {
                for (File curFile : email.getAttachments()) {
                    FileSystemResource file = new FileSystemResource(curFile);
                    helper.addAttachment(MimeUtility.encodeWord(file.getFilename(), "utf-8", "B"), file);
                }
            }
            log.info("邮件开始发送");
            javaMailSender.send(mimeMessage);
            long sendMillTimes = System.currentTimeMillis() - start;
            log.info("邮件发送成功,sendTimes=" + sendMillTimes);
        } catch (Exception e) {
            log.error("发送html邮件时发生异常！", e);
        }
    }

}
