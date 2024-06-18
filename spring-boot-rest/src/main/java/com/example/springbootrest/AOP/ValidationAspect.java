package com.example.springbootrest.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution (* com.example.springbootrest.service.JobService.getJobs(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int postId ) throws Throwable {

        if (postId<0) {
            LOGGER.info("Post ID is negative.. Updating to new value");
            postId = -postId;
            LOGGER.info("Updated value "+postId);
        }

        Object obj = joinPoint.proceed(new Object[] {postId});

        return obj;
    }
}
