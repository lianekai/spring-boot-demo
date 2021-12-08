package com.lianekai.es;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/18 23:39
 */
@SpringBootApplication
public class ElasticSearchApplication {
    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(ElasticSearchApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);
    }
}
