package demo;

import demo.interfc.IConstant;
import demo.utils.CsvUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.util.List;
import java.util.Map;

//import org.junit.After;

@Slf4j
@RunWith(Parameterized.class)
public class FreemarkerDemoTest implements IConstant {

    //数据驱动 --
    @Parameterized.Parameter
    public Map<String, String> map;

    @Parameterized.Parameters
    public static List<Map<String, String>> data() throws Exception{
        return CsvUtils.readCsv("/csv/hello.csv");
//        return CsvUtils.readCsv("/csv/hello0.csv");
    }
    //数据驱动 --

    private static Configuration configuration;
    private StringWriter sw;

    @BeforeClass
    public static void beforeClass() throws IOException {
        configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File(CLASS_TEST_RESOURCES_PATH));
//        configuration.setDirectoryForTemplateLoading(new File("src/test/resources"));
    }

    @Before
    public void setUp() {
        sw = new StringWriter();
    }

    /**
     * 可以加载非ftl后缀的模板文件
     * @throws IOException 抛出io异常
     * @throws TemplateException 抛出模板异常
     */
    @Test
    public void testFreemarker() throws IOException, TemplateException {

        // step4 加载模版文件
        Template template = configuration.getTemplate("hello.xml");
        template.process(map, sw);

        log.info("\n"+sw.toString());

    }

    @Test
    public void testFreemarker0()throws IOException, TemplateException{
        Template template = configuration.getTemplate("hello.ftl");
        File docFile = new File(CLASS_TEST_PATH + "/" + map.get("className")+".java");
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));)
        {
            template.process(map, out);
        }
    }


    /**
     * 可以加载非ftl后缀的模板文件
     * @throws IOException 抛出io异常
     * @throws TemplateException 抛出模板异常
     */
    @Test
    public void testFreemarker1() throws IOException, TemplateException {

        // step4 加载模版文件
        Template template = configuration.getTemplate("/hello.ftl");
        template.process(map, sw);

        log.info("\n"+sw.toString());

    }

//    @After
//    public void tearDown() throws Exception {
//    }
}