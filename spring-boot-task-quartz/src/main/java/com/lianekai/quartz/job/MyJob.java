package com.lianekai.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 16:12
 */
@Slf4j
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("即将去扫描数据库啦~~");
    }

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail=JobBuilder.newJob(MyJob.class).withIdentity("job1","group1" ).build();

        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)
                .repeatForever()).build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);

        // 调度器开始调度任务
        scheduler.start();
    }
}
