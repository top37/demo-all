package com.sq.ncreport.service;

import com.sq.ncreport.cfg.CfgProperty;
import com.sq.ncreport.constant.Constant;
import com.sq.ncreport.pojo.ResponseData;
import com.sq.ncreport.utils.XmlUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

import static com.sq.ncreport.constant.Constant.Charset.UTF8;
import static com.sq.ncreport.constant.Constant.Http.SESSION;
import static com.sq.ncreport.utils.OprFileUtils.*;
import static io.restassured.RestAssured.given;

@Component
@Slf4j
public class HttpService {

    @Autowired
    private CfgProperty cfgProperty;

    /**
     * RequestSpecification 较特殊，即request属一次性消耗品，故在循环体中每次均需被赋值；
     * @return 返回三个已经被填充文件的路径
     * @throws IOException 抛出io异常
     */
    public File[] getResponseArr() throws IOException {
        File[] responseFileArr = new File[3];
        String content = "";
        //文件名称中分别对应1,2,3
        for(int i = 1;i < 4;i++){
            RequestSpecification request = given().cookie(SESSION, cfgProperty.getSession());
            log.info("\n下载：{}...\n url为：{}\n 当前session为：{}",getNCFileName(i),cfgProperty.getUrl()+getNCFileName(i),cfgProperty.getSession());

            //下载
            Response response = request.get(cfgProperty.getUrl()+getNCFileName(i));
            content = new String(response.asByteArray(),UTF8);
            log.info("文件内容为：\n{}",content);
            //保存入本地
            responseFileArr[i-1] = mkNCFile(cfgProperty.getTempaddr()+getNCFileName(i),content);
            log.info("已下载：{}到本地：{}下",getNCFileName(i),cfgProperty.getTempaddr());
        }
        return responseFileArr;
    }

    public File getResponse(Integer i) throws IOException {
        File file;
        RequestSpecification request = given().cookie(SESSION, cfgProperty.getSession());

        Response response  = request.get(cfgProperty.getUrl()+getNCFileName(i));
        log.info("文件内容为：\n{}",new String(response.asByteArray(),UTF8));
        file = mkNCFile(cfgProperty.getTempaddr()+getNCFileName(i),new String(response.asByteArray(),UTF8));
        log.info("已下载：{}到本地：{}下",getNCFileName(i),cfgProperty.getTempaddr());

        return file;
    }

    public ResponseData getResponseData() throws IOException, DocumentException {
        ResponseData responseData = new ResponseData();
        File[] files = new File[3];
        String[] strs = {"1_凭证正常","2_凭证正常","3_凭证正常"};
        String content = "";
        String fileName = "";
        //文件名称中分别对应1,2,3
        for(int i = 1;i < 4;i++){

            RequestSpecification request = given().cookie(SESSION, cfgProperty.getSession());
            fileName = getNCFileName(i);

            //下载
            Response response = request.get(cfgProperty.getUrl()+getNCFileName(i));
            content = new String(response.asByteArray(),UTF8);

            if(StringUtils.isEmpty(response.asString())){
                Response response1 = given().cookie(SESSION, cfgProperty.getSession())
                                            .get(cfgProperty.getUrl()+getErrNCFileName(i));
                content = new String(response1.asByteArray(),UTF8);
                fileName = getErrNCFileName(i);
            }

            log.info("\n下载：{}...\n url为：{}\n 当前session为：{}",fileName,cfgProperty.getUrl()+fileName,cfgProperty.getSession());
            log.info("文件内容为：\n{}",content);

            //获取第5个节点 - resultdescription所描述的内容
            if(content.contains("错误")) strs[i-1] = i+"_凭证报错:" +"\n"+ XmlUtils.getEleWhenErr(content).get(4).getText()+"\n"+"-----";

            //保存入本地
            files[i-1] = mkNCFile(cfgProperty.getTempaddr()+fileName,content);

            log.info("已下载：{}到本地：{}下",fileName,cfgProperty.getTempaddr());
        }

        responseData.setFiles(files);
        responseData.setStrs(strs);
        return responseData;
    }

    public Boolean keepAlive() throws IOException {
        Boolean flag = true;
        RequestSpecification request = given().cookie(SESSION, cfgProperty.getSession());
        Response response  = request.get(cfgProperty.getSessionAlive());
        if(!new String(response.asByteArray(),"utf-8").contains("资产负债表")) flag = false;

        return flag;
    }
}
