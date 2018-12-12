package com.sq.ncreport;

import com.sq.ncreport.cfg.CfgProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Application implements ApplicationListener<ContextRefreshedEvent> {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        CfgProperty cfgProperty = (CfgProperty)event.getApplicationContext().getBean("cfgProperty");
        log.info("session={}",cfgProperty.getSession());
        log.info("tempaddr={}",cfgProperty.getTempaddr());
        log.info("url={}",cfgProperty.getUrl());
        log.info("sender={}",cfgProperty.getSender());
        log.info("accepters={}",cfgProperty.getAccepters());
        log.info("sessionAlive={}",cfgProperty.getSessionAlive());
    }
}
