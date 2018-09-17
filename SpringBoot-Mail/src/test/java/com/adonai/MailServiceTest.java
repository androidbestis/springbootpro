package com.adonai;

import com.adonai.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    //thymeleaf模板引擎
    @Autowired
    private TemplateEngine templateEngine;


    /**
     * 测试简单文本邮件
     * @throws Exception
     */
    @Test
    public void testSimpleMail() throws Exception{
        mailService.sendSimpleMail("2272799702@qq.com","古珀平台"," hello this is simple mail");
    }

    /**
     * 测试html格式邮件
     * @throws Exception
     */
    @Test
    public void testHtmlMail() throws Exception{
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("2272799702@qq.com","古珀医学",content);
    }

    /**
     * 测试带附件的邮件
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception{
        String filePath="E:\\tmp\\application.log";
        mailService.sendAttachmentsMail("2272799702@qq.com", "古珀平台主题带附件的邮件", "有附件，请查收！", filePath);
    }


    /**
     * 测试带静态资源的邮件
     * 带图片
     * @throws Exception
     */
    @Test
    public void sendInlineResourceMail() throws  Exception{
        //添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\timg.jpg";

        mailService.sendInlineResourceMail("2272799702@qq.com", "古珀平台", content, imgPath, rscId);
    }

    /**
     * 测试使用Thymeleaf模板的邮件
     */
    @Test
    public void sendTemplateMail() throws Exception{
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("2272799702@qq.com","古珀平台",emailContent);
    }
}
