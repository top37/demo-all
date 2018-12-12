package email;

import demo.EmailsenderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmailsenderApplication.class)
public class EmailsenderApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("top37@qq.com");
        message.setTo("top37@qq.com","");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        message.setText("测试邮件内容1");

        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("top37@qq.com");
        helper.setTo("top37@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\top37\\AppData\\Local\\Temp\\BkMsg_20181029voucher_2_(1).xml"));
        helper.addAttachment("BkMsg_20181029voucher_2_(1).xml", file);
        helper.addAttachment("BkMsg_20181029voucher_2_(2).xml", file);

        mailSender.send(mimeMessage);

    }


}
