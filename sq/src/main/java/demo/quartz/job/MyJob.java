package demo.quartz.job;

import org.quartz.*;
import java.text.SimpleDateFormat;
/**
 *
 * Created by l1 on 2016/10/8.
 */
public class MyJob implements Job{
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // job 的名字
        String jobName = context.getJobDetail().getKey().getName();

        // 任务执行的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");
        String jobRunTime = dateFormat.format(java.util.Calendar.getInstance().getTime());

        // 输出任务执行情况
        System.out.println("任务 : " + jobName + " 在  " +jobRunTime + " 执行了 ");
    }
}
