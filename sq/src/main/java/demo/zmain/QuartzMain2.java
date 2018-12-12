package demo.zmain;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import demo.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


public class QuartzMain2 {

    public static void main(String[] args)
            throws SchedulerException, ParseException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

//        JobDetail jobDetail = newJob(HelloJob.class)
//                .withIdentity("job1","group1")
//                .build();
//
//        /**
//         * 声明一个触发器
//         * 所设置的属性都是字面意思：
//         * startNow - 在scheduler.start()时立刻执行；
//         *
//         */
//        Trigger cronTrigger = newTrigger()
//                .withIdentity("trigger1","group1")
//                .withSchedule(cronSchedule("0 0/1 8-17 * * ?"))
//                .forJob(jobDetail)
//                .build();
//
//        scheduler.scheduleJob(cronTrigger);

//        scheduler.resumeJob(new JobKey("trigger1",
//                "group1"));

        scheduler.start();
    }


    public static void resumeJob() {
        try {

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            // ①获取调度器中所有的触发器组
            List<String> triggerGroups = scheduler.getTriggerGroupNames();
            // ②重新恢复在tgroup1组中，名为trigger1_1触发器的运行
            for (int i = 0; i < triggerGroups.size(); i++) {
                List<String> triggers = scheduler.getTriggerGroupNames();
                for (int j = 0; j < triggers.size(); j++) {
                    Trigger tg = scheduler.getTrigger(new TriggerKey(triggers
                            .get(j), triggerGroups.get(i)));
                    // ②-1:根据名称判断
                    if (tg instanceof SimpleTrigger
                            && tg.getDescription().equals("group1.trigger1")) {
                        // ②-1:恢复运行
                        scheduler.resumeJob(new JobKey(triggers.get(j),
                                triggerGroups.get(i)));
                    }
                }

            }
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
