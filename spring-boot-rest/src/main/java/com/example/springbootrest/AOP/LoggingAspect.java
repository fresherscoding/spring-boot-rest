package com.example.springbootrest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public static final Logger LOGGER  = LoggerFactory.getLogger(LoggingAspect.class);

    //data type, class-name.method-name (arguments)

    @Before("execution (* com.example.springbootrest.service.JobService.*(..))")
    public void loggMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method Called : "+joinPoint.getSignature().getName());
    }

    @After("execution (* com.example.springbootrest.service.JobService.*(..))")
    public void logMethodExce(JoinPoint joinPoint){
        LOGGER.info("Method executed : "+joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution (* com.example.springbootrest.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint joinPoint){
        LOGGER.info("Method has issues : "+joinPoint.getSignature().getName());
    }

    @AfterReturning("execution (* com.example.springbootrest.service.JobService.*(..))")
    public void logMethodSuccess(JoinPoint joinPoint){
        LOGGER.info("Method executed successfully : "+joinPoint.getSignature().getName());
    }
}
