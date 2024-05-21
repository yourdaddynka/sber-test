package com.test.sber.aop;

import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
@Order(1)
public class LoggAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggAspect.class);

    @Before("")
    public void beforeControllerMethodExecution(JoinPoint joinPoint) {

    }
}
