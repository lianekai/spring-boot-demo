package com.lianekai.aop.annotation;

import java.lang.annotation.*;

/**
 * 权限控制的自定义注解
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/06/15 22:38
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnno {
}
