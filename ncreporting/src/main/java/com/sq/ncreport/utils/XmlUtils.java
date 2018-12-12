package com.sq.ncreport.utils;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.sq.ncreport.constant.Constant.Xml.XML_0;
import static com.sq.ncreport.constant.Constant.Xml.XML_1;

@Slf4j
public class XmlUtils {
    private XmlUtils(){}

    public static List<Element> getEleWhenErr(String xml) throws UnsupportedEncodingException, DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));//读取xml字符串，注意这里要转成输入流
        Element root = document.getRootElement();//获取根元素
        List<Element> Children = root.elements();//获取当前元素下的全部子元素

        for (Element child : Children) {//循环输出全部book的相关信息
            List<Element> es = child.elements();
            for (Element e : es) {
                String name = e.getName();//获取当前元素名
                String text = e.getText();//获取当前元素值
                if(name.equals("resultcode") && !text.equals("-31004")){
                    System.out.println(name + ":" + text);
                    return es;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) throws Exception {

        List<Element> es = getEleWhenErr(XML_1);
        System.out.println(es.get(4).getText());
    }

}
