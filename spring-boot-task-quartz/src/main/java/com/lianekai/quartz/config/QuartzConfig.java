package com.lianekai.quartz.config;

import com.lianekai.quartz.factory.QuartzJobFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * 注册调度工厂
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/24 18:23
 */
public class QuartzConfig {
    @Autowired
    private QuartzJobFactory jobFactory;

    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        //获取配置属性
        PropertiesFactoryBean propertiesFactoryBean=new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.yml"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        //创建SchedulerFactoryBean
        SchedulerFactoryBean factory=new SchedulerFactoryBean();
        factory.setQuartzProperties(propertiesFactoryBean.getObject());
        /**支持在JOB实例中注入其他的业务对象*/
        factory.setJobFactory(jobFactory);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        //这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。
        factory.setWaitForJobsToCompleteOnShutdown(true);
        //是否覆盖己存在的Job
        factory.setOverwriteExistingJobs(false);
        //QuartzScheduler 延时启动，应用启动完后 QuartzScheduler 再启动
        factory.setStartupDelay(10);
        return factory;
    }
    /**
     * 通过SchedulerFactoryBean获取Scheduler的实例
     * @return
     * @throws IOException
     * @throws SchedulerException
     */
    @Bean(name = "scheduler")
    public Scheduler scheduler() throws IOException, SchedulerException {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();
        return scheduler;
    }
}
