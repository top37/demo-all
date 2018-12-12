package com.sq.ncreport.utils;

import com.sq.ncreport.service.EmailService;
import com.sq.ncreport.service.HttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class ServiceUtils {

    @Autowired
    private HttpService httpService;

    @Autowired
    private EmailService emailService;

    private ServiceUtils() {
    }

    /**
     * 挣扎
     * @param i=0 挣扎4次,每次10min
     */
    public void struggle(Integer i) throws Exception {
        if(i == 3) {
            log.info("go dead");
            emailService.sendSimpleMail();
            System.exit(0);
        }
        stop(600);
        if(httpService.keepAlive()){
            log.info("I am Alive");
            return;
        }else{
            log.info("I am struggling");
            struggle(i+1);
        }

    }


    public static void stop(Integer s){
        try {
            Thread.sleep(s*1000);
        } catch (InterruptedException e) {
            log.info("睡眠不足...\n{}",e.getMessage());

        }
    }
}
