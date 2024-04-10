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
@Component("task1Handler")
public class Task1Strategy extends TaskAbstractStrategy {
    @Override
    public boolean handleJob(String code) {
        log.info("task1Handler 处理"+code);
        return false;
    }
}
