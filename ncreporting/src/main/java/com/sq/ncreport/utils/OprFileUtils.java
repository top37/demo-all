package com.sq.ncreport.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.sq.ncreport.constant.Constant.Charset.UTF8;
import static com.sq.ncreport.constant.Constant.File.*;

public class OprFileUtils {
    private OprFileUtils(){}

    public static String getNCFileName(Integer i){
        return FILE_NAME_DEMO.replace("X",DateTimeUtils.getCurDateBeforeOneDay()).replace("N",i.toString());
    }

    public static String getErrNCFileName(Integer i){
        return FILE_ERR_NAME_DEMO.replace("X",DateTimeUtils.getCurDateBeforeOneDay()).replace("N",i.toString());
    }

    public static File mkNCFile(String pathname,String data) throws IOException {
        FileUtils.writeStringToFile(new File(pathname),data,UTF8);
        return new File(pathname);
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtils.getCurDateBeforeOneDay());
    }
}
