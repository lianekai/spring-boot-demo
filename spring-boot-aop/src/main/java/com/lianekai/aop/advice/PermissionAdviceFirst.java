package com.lianekai.aop.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 第一层权限校验
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/06/15 22:38
 */
@Aspect
/**定义一个切面*/
@Component
@Order(1)
public class PermissionAdviceFirst {
    // 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.lianekai.aop.annotation.PermissionAnno)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================第一个权限切面===================：");
        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        Long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id1->>>>>>>>>>>>>>>>>>>>>>" + id);
        System.out.println("name1->>>>>>>>>>>>>>>>>>>>>>" + name);

        // id小于0则抛出非法id的异常
        if (id < 0) {
            return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
        }
        return joinPoint.proceed();

    }

}
