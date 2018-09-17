package com.adonai.service;

public interface MailService {

    //发送简单的邮件
    public void sendSimpleMail(String to, String subject, String content);

    //发送html格式邮件
    public void sendHtmlMail(String to, String subject, String content);

    //发送带附件的邮件
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    //发送带静态资源的邮件
    //发送正文中有静态资源（图片）的邮件
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
