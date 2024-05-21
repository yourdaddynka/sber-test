package com.test.sber.aop;

import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@AllArgsConstructor
@Order(1)
public class LoggAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggAspect.class);

    @Before("com.test.sber.aop.AllMethodsPointCut.allMethodsFromCompanyController() " +
            "|| com.test.sber.aop.AllMethodsPointCut.allMethodsFromEntityController()")
    public void beforeControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Before execution of method: " + methodName);
        LOGGER.info("With arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(pointcut = "com.test.sber.aop.AllMethodsPointCut.allMethodsFromEntityController()" +
            "|| com.test.sber.aop.AllMethodsPointCut.allMethodsFromCompanyController()", throwing = "ex")
    public void logAfterThrowingFromController(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.error("Exception in method: " + methodName);
        LOGGER.error("Exception message: " + ex.getMessage());
    }
}
