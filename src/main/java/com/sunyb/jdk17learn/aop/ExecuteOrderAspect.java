package com.sunyb.jdk17learn.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yb.Sun
 * @date 2023/7/31 17:24
 */
@Slf4j
@Aspect
@Component
public class ExecuteOrderAspect {

    @Pointcut("execution(* com.sunyb.jdk17learn..service.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before(){
        log.info("------- this is before! -------");
    }

    @After("pointCut()")
    public void after(){
        log.info("------- this is after! -------");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(IllegalArgumentException ex){
        log.info("------- this is afterThrowing! -------");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        log.info("------- this is afterReturning! -------");
    }

    @Around("pointCut()")
    @SneakyThrows({Throwable.class})
    public Object around(ProceedingJoinPoint pjp){

        try {
            log.info("------- this is around - before! -------");
            return pjp.proceed();
        }finally {
            log.info("------- this is around - after! -------");
        }
    }

}
