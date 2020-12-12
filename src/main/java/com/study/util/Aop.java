package com.study.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * springboot的aop只需要导入spring-boot-starter-aop依赖，再编写这个切面类就好
 */
@Component
@Aspect
@Slf4j
public class Aop {

    @Pointcut("execution(* *..*.*ServiceImpl.*(..))")
    public void pt2() {

    }

    @Before("pt2()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        /**这里不可以用debug打印，因为springboot默认的日志级别是info*/
        log.info("前置通知的方法名为：{}，参数为：{}", methodName, argList);
    }

    @AfterThrowing(pointcut = "pt2()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("异常通知的方法名为：{}，参数为：{}，异常为：{}", methodName, argList, ex);
    }

    @AfterReturning(pointcut = "pt2()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("后置通知的方法名为：{}，参数为：{}，返回为：{}", methodName, argList, result);
    }

    @After("pt2()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("最终通知的方法名为：{}，参数为：{}", methodName, argList);
    }
}
