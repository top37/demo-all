package com.sq.ncreport.service;

import com.sq.ncreport.cfg.CfgProperty;
import com.sq.ncreport.pojo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by kiranreddy on 22/04/17.
 */
@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private CfgProperty cfgProperty;

    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(cfgProperty.getSender());
        message.setTo(cfgProperty.getAccepters().split(","));
        message.setSubject("主题：dead");
        message.setText("I am over");

        mailSender.send(message);
    }

    public void sendAttachmentsMail(File... files) throws Exception {
        log.info("发送邮件...start");

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(cfgProperty.getSender());
        helper.setTo(cfgProperty.getAccepters().split(","));
        helper.setSubject("主题：ncreport");
        helper.setText("NC处理");

        for(File f : files){
            log.info("发送："+f.getName());
            helper.addAttachment(f.getName(), new FileSystemResource(f));
        }
        mailSender.send(mimeMessage);

        log.info("发送邮件...end");
    }

    public void sendAttachmentsMail1(ResponseData responseData) throws Exception {
        log.info("发送邮件...start");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        StringBuilder text = new StringBuilder("");
        for(String s : responseData.getStrs()) text.append(s).append("\n");

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(cfgProperty.getSender());
        helper.setTo(cfgProperty.getAccepters().split(","));
        helper.setSubject("主题：ncreport");
        helper.setText(text.toString());

        for(File f : responseData.getFiles()){
            log.info("发送："+f.getName());
            helper.addAttachment(f.getName(), new FileSystemResource(f));
        }
        mailSender.send(mimeMessage);

        log.info("发送邮件...end");
    }
}

