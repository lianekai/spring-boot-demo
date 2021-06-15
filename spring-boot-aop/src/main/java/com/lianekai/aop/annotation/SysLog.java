package com.lianekai.aop.annotation;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/06/14 15:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
