package com.lianekai.apollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyk
 * @version: 1.0
 * @date 11:09
 */
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger( HelloController.class );

    @Value( "${server.port}" )
    String port;

    @GetMapping("hi")
    public String hi(String name) {

        logger.debug( "debug log..." );
        logger.info( "info log..." );
        logger.warn( "warn log..." );

        return "hi " + name + " ,i am from port:" + port;
    }

}
