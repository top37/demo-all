package demo.quartz.job;

import demo.utils.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 实现org.quartz.Job接口，声明该类是一个可执行任务类
 *
 * @author Administrator
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("现在是北京时间:" + DateUtil.getCurrDateTime() + " - helloJob任务执行");
    }
}

