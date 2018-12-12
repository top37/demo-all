package demo.zmain;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


import demo.quartz.job.HelloJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //从调度程序工厂获取一个调度程序实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        System.out.println(scheduler.getSchedulerName());

        /**
         * 定义一个JobDetail,绑定到自定义job（HelloJob)；
         * 此处只做声明，并不会立刻创建HelloJob实例；
         * 创建实例是在scheduler安排任务触发；
         */
        JobDetail jobDetail = newJob(HelloJob.class)
                            .withIdentity("job1","group1")
                            .build();

        /**
         * 声明一个触发器
         * 所设置的属性都是字面意思：
         * startNow - 在scheduler.start()时立刻执行；
         */
        Trigger trigger = newTrigger()
                        .withIdentity("trigger1","group1")
                        .startNow()
                        .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                        .build();

        scheduler.scheduleJob(jobDetail,trigger);

        scheduler.start();


        Thread.sleep(20000);

        scheduler.shutdown();



    }
}
