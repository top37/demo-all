package com.sq.ncreport.zmain;

import com.sq.ncreport.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;

import static com.sq.ncreport.constant.Constant.File.FILE_NAME_DEMO;

@Slf4j
public class MainStart {
    public static void main(String[] args) {
        log.info("hehe");
        log.info(DateTimeUtils.getCurDateBeforeOneDay());
        System.out.println(getFileName(1));
        System.out.println(getFileName(2));
        System.out.println(getFileName(3));
    }

    public static String getFileName(Integer i){
       return FILE_NAME_DEMO.replace("X",DateTimeUtils.getCurDateBeforeOneDay()).replace("N",i.toString());
    }
}
