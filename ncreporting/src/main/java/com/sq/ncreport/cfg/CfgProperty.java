package com.sq.ncreport.cfg;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class CfgProperty {
    @Value("${app.session}")
    private String session;

    @Value("${app.url}")
    private String url;

    @Value("${app.tempaddr}")
    private String tempaddr;

    @Value("${app.qq.sender}")
    private String sender;

    @Value("${app.qq.accepters}")
    private String accepters;

    @Value("${app.sessionAlive}")
    private String sessionAlive;

}
