package com.lianekai.paterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * todo
 *
 * @author lianyikai
 * @date 2023/11/20 23:28
 */
@Slf4j
@Component("task2Handler")
public class Task2Strategy extends TaskAbstractStrategy {
    @Override
    public boolean handleJob(String code) {
        log.info("task2Handler 处理"+code);
        return false;
    }
}
