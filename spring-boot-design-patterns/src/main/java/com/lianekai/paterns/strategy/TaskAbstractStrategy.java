package com.lianekai.paterns.strategy;

/**
 * 处理任务抽象类
 *
 * @author lianyikai
 * @date 2023/11/20 23:26
 */
public abstract class TaskAbstractStrategy {
    /**
     * 处理任务
     *
     * @param code
     * @return boolean
     */
    abstract public boolean handleJob(String code);
}
