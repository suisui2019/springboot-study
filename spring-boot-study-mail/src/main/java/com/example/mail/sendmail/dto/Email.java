package com.example.mail.sendmail.dto;

import java.io.File;
import java.util.List;

/**
 * Email实体类
 *
 * @Author: lifq
 */
public class Email {

    /**
     * 发件人地址(为空时自动调用配置文件中设置的发件人)
     */
//    private String fromAddress;

    /**
     * 收件人地址
     */
    private List<String> toAddress;

    /**
     * 抄送人地址
     */
    private List<String> ccAddress;

    /**
     * 密送人地址
     */
    private List<String> bccAddress;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 附件
     */
    private List<File> attachments;


    public List<String> getToAddress() {

        return toAddress;
    }

    public void setToAddress(List<String> toAddress) {

        this.toAddress = toAddress;
    }

    public List<String> getCcAddress() {

        return ccAddress;
    }

    public void setCcAddress(List<String> ccAddress) {

        this.ccAddress = ccAddress;
    }

    public List<String> getBccAddress() {

        return bccAddress;
    }

    public void setBccAddress(List<String> bccAddress) {

        this.bccAddress = bccAddress;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {

        this.subject = subject;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public List<File> getAttachments() {

        return attachments;
    }

    public void setAttachments(List<File> attachments) {

        this.attachments = attachments;
    }

}
