package com.lianekai.aop.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 通知处理切面类
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/06/15 20:56
 */
@Aspect     /**定义一个切面*/
@Component
public class LogAdvice {
    /**定义一个切点*/
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut(){
    }

    @Before("logAdvicePointcut()")
    public void logAdvice(){
        System.out.println("在进入getMapping 请求之前执行了哦");
    }

    /**定义一个切点*/
    @Pointcut("@annotation(com.lianekai.aop.annotation.SysLog)")
    private void logAdvicePointcutBiz(){
    }

    @After("logAdvicePointcutBiz()")
    public void logAdvice1(){
        System.out.println("在进入getMapping 请求之后执行了哦");
    }

}
