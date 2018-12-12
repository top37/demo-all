package com.sq.ncreport.scheduling;

import com.sq.ncreport.cfg.CfgProperty;
import com.sq.ncreport.service.EmailService;
import com.sq.ncreport.service.HttpService;
import com.sq.ncreport.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.sq.ncreport.constant.Constant.Http._1;

@Slf4j
@Component
public class Scheduling{

    @Autowired
    private HttpService httpService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ServiceUtils serviceUtils;

    //每天八点半发送邮件
    @Scheduled(cron = "${app.everyDayScheduled}")
   public void everyDayScheduled()throws Exception{
       log.info("every day nc log");
        //        emailService.sendAttachmentsMail(httpService.getResponseArr());
        emailService.sendAttachmentsMail1(httpService.getResponseData());
   }

    //每半个小时探活一次，保证session存活,容错率较低，需在退出前做些挣扎
//    @Scheduled(fixedRate = 1800000)
    //10min
    @Scheduled(fixedRate = 600000)
//    @Scheduled(fixedRate = 3000)
    public void keepAliveScheduled() throws Exception {
        log.info("keep alive?");
        if(httpService.keepAlive()){
            log.info("I am Alive");
        } else {
            serviceUtils.struggle(0);
        }
    }

}
