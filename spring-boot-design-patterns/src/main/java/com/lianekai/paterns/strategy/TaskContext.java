package com.lianekai.paterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * todo
 *
 * @author lianyikai
 * @date 2023/11/20 23:34
 */
@Slf4j
@Component
public class TaskContext {

    @Resource
    private Map<String,TaskAbstractStrategy> taskStrategyMap;


    public void handle(String code){
        TaskAbstractStrategy strategy=taskStrategyMap.get(code);
        strategy.handleJob(code);
    }




}
