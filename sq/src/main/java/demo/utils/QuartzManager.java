package demo.utils;

import demo.quartz.job.HelloJob;
import demo.quartz.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 *
 * Created by 单强 2018年11月28日17:33:53
 */
public class QuartzManager {

    private static final String  JOB_GROUP_NAME = "JOB_GROUP_NAME";
    private static final String  TRIGGER_GROUP_NAME = "TRIGGER_GROUP_NAME";
    private static Scheduler scheduler;

    static {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加定时任务
     */
    public static void addJob(String jobName,String jobGroupName,String triggerName,String triggerGroupName,Class cls,String time){
        try {
            JobDetail jobDetail = newJob(cls).withIdentity(jobName, jobGroupName).build();
            CronTrigger cronTrigger
                    = newTrigger().withIdentity(triggerName, triggerGroupName).withSchedule(cronSchedule(time)).build();
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public static void addJob(String jobName,String triggerName,String groupName,Class cls,String time){
        addJob(jobName,groupName,triggerName,groupName,cls,time);
    }
    public static void addJob(String jobName,String triggerName,Class cls,String time){
        addJob(jobName,JOB_GROUP_NAME,triggerName,TRIGGER_GROUP_NAME,cls,time);
    }

    /**
     * 执行定时任务
     */
    public static void startJob(){
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除定时任务
     */
    public static boolean deleteJob(String jobName,String groupName){
        boolean result = false;
        try {
            JobKey jobKey = new JobKey(jobName,groupName);
            if(scheduler.checkExists(jobKey)){
                result = scheduler.deleteJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static  void deleteJob(String jobName){
        deleteJob(jobName,JOB_GROUP_NAME);
    }

    /**
     * 停止任务
     */
    public static void pauseJob(String jobName,String groupName){
        try {
            JobKey jobKey = new JobKey(jobName,groupName);
            if(scheduler.checkExists(jobKey)){
                scheduler.pauseJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public static void pauseJob(String jobName){
        pauseJob(jobName,JOB_GROUP_NAME);
    }

    /**
     * 再次启动Job
     */
    public static void resumeJob(String jobName,String groupName){
        try {
            JobKey jobKey = new JobKey(jobName,groupName);
            if(scheduler.checkExists(jobKey)){
                scheduler.resumeJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public static  void resumeJob(String jobName){
        resumeJob(jobName,JOB_GROUP_NAME);
    }

    public static void main(String[] args) {
//        QuartzManager.addJob("job2","trigger2",HelloJob.class,"0/2 * * * * ?");

//        QuartzManager.addJob("job1","trigger1",MyJob.class,"0/15 * * * * ?");
//        System.out.println("the concurrent no excute");
//        QuartzManager.startJob();
//
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        resumeJob("job1");
        startJob();

//        deleteJob("job1");
//        deleteJob("job2");
    }

}