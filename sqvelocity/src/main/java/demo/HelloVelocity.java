package demo;

import java.io.StringWriter;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * @author top37 2018年11月30日15:42:51
 */
public class HelloVelocity {
    public static void main(String[] args) {

        //初始化 start
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        //初始化 end

        Template template = velocityEngine.getTemplate("For.vm", "UTF-8");
//        Template template = velocityEngine.getTemplate("HelloVelocity.vm", "UTF-8");

        //定义数据 start
        String[] allProducts = {"aqiang","bqiang","cqiang"};
        //定义数据 end

        VelocityContext context = new VelocityContext();
        context.put("name", "liang01.ma");
        context.put("date", new Date().toString());
        context.put("allProducts",allProducts);
        StringWriter writer = new StringWriter();

        template.merge(context, writer);

        //显示
        System.out.println(writer.toString());
    }
}


