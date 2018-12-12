package demo;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author top37 2018年11月30日15:42:51
 */
public class ForMapVelocity {

    private static VelocityEngine velocityEngine;
    private static Template template;

    static
    {
        //初始化 start
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        //初始化 end

        //初始模板 start
        template = velocityEngine.getTemplate("For1.vm", "UTF-8");
        //初始模板 end
    }

    public static void main(String[] args) {

        //定义数据 start
        Map<String,Object> ncReportContent = new LinkedHashMap<>();
        ncReportContent.put("1正常","正常");
        ncReportContent.put("2错误","错误");
        ncReportContent.put("3正常","正常");
        ncReportContent.put("4正常","正常");
        //定义数据 end

        VelocityContext context = new VelocityContext();
        context.put("ncReportContent",ncReportContent);
        StringWriter writer = new StringWriter();

        template.merge(context, writer);

        //显示
        System.out.println(writer.toString());
    }
}


