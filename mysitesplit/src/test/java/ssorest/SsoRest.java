package ssorest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.*;

public class SsoRest {
    @Test
    public void getHttpTest() throws IOException {

//        Response response = given().cookie("JSESSIONID", "2AF26CC279E9B34561827D8472D16860").get("http://account.gomemyf.com/push/nclog/downReceipt?fileName=BkMsg_20181029voucher_3_(1).xml");
        RequestSpecification request = given().cookie("SESSION", "212f5979-73a5-44aa-a24d-3b88fe4d8e60");
//        Response response0 = request.get("http://sso-n.gomefinance.com.cn/");
////        // 打印出 response 的body response.print();
//        response0.print();
//        Response response  = request.get("http://account.gomemyf.com/push/nclog/downReceipt?fileName=BkMsg_20181029voucher_3_(1).xml");
        Response response  = request.get("http://account.gomemyf.com");
        System.out.println(new String(response.asByteArray(),"utf-8"));
//        System.out.println("时间为："+response.getDetailedCookie("").getExpiryDate());
        System.out.println("时间为："+response.getDetailedCookies());
        if(new String(response.asByteArray(),"utf-8").contains("资产负债表"))
        System.out.println("I live");
//        response.print();
//        InputStream input = response.asInputStream();
//        byte[] b = new byte[1024];
//        int len = 0;
//        StringBuffer sb = new StringBuffer("");
//
//        while ((len = input.read(b)) > 0) {
//            System.out.println(len);
//            sb.append(new String(b, 0, len));
//        }
//        System.out.println(sb);
    }

}
