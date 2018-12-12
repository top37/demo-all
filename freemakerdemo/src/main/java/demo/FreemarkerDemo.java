package demo;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 最常见的问题：
 *     java.io.FileNotFoundException: xxx does not exist. 解决方法：要有耐心
 *     FreeMarker jar 最新的版本（2.3.23）提示 Configuration 方法被弃用
 * 代码自动生产基本原理：
 *     数据填充 freeMarker 占位符
 */
public class FreemarkerDemo {

    private static final String TEMPLATE_PATH = "src/main/java/demo/temp";
    private static final String CLASS_PATH = "src/main/java/demo";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        StringWriter sw;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPath", "demo");
            dataMap.put("className", "AutoCodeDemo");
            dataMap.put("helloWorld", "通过简单的 <代码自动生产程序> 演示 FreeMarker的HelloWorld！");
            // step4 加载模版文件
            Template template = configuration.getTemplate("hello.xml");
            // step5 生成数据
//            File docFile = new File(CLASS_PATH + "\\" + "AutoCodeDemo.java");
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
//            // step6 输出文件
//            template.process(dataMap, out);
//            out = new OutputStreamWriter(System.out);

            sw = new StringWriter();
            template.process(dataMap, sw);

            System.out.println(sw.toString());
            System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^AutoCodeDemo1.java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
