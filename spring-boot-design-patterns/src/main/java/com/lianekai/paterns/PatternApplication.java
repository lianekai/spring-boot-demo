package com.lianekai.paterns;

import com.lianekai.paterns.strategy.TaskContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * 设计模式应用
 *
 * @author lianyikai
 * @date 2023/11/20 23:20
 */
@SpringBootApplication
public class PatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternApplication.class,args);
    }
}