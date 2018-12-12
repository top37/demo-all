package demo;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 最常见的问题：
 *     java.io.FileNotFoundException: xxx does not exist. 解决方法：要有耐心
 *     FreeMarker jar 最新的版本（2.3.23）提示 Configuration 方法被弃用
 * 代码自动生产基本原理：
 *     数据填充 freeMarker 占位符
 */
public class FreemarkerDemo1 {

    private static final String TEMPLATE_PATH = "src/main/java/demo/temp";
    private static final String CLASS_PATH = "src/main/java";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        StringWriter sw;
        try {
            // step2 获取模版路径
//            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // step4 加载模版文件
            Template template = configuration.getTemplate("/srctemp/demo.ftl");

            sw = new StringWriter();
            template.process(dataMap, sw);

            System.out.println(sw.toString());
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
