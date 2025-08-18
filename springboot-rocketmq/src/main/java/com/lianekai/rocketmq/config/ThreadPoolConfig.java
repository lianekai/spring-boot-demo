package com.lianekai.rocketmq.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 17:22
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean("threadExecutor")
    public Executor buildExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("executor-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 40, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return TtlExecutors.getTtlExecutorService(threadPoolExecutor);
    }
}
