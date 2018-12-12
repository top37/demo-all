package demo;

import demo.job.HelloJob;
import org.quartz.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzMain {
    private static SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

    public static void main(String[] args) throws SchedulerException {
        Scheduler sched = schedFact.getScheduler();
        sched.start();
        // define the job and tie it to our HelloJob class - tie:关联，联系
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Trigger the job to run now, and then every 40 seconds - trigger：触发
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
