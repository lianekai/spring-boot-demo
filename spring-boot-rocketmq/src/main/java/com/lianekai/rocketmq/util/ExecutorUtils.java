package com.lianekai.rocketmq.util;

import java.util.concurrent.Executor;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 17:29
 **/
public class ExecutorUtils {

    public static Executor getExecutor(){
        return SpringContextUtils.getBean("threadExecutor",Executor.class);
    }
}
