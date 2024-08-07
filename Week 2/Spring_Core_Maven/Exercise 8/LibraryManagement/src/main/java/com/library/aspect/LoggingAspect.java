package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private long startTime;


    @Before("execution(* com.library..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
        System.out.println("\nMethod: " + joinPoint.getSignature().getName() + "() started at: " + this.startTime);
    }

    @After("execution(* com.library..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        long endTime = System.currentTimeMillis();
        System.out.println("Method: " + joinPoint.getSignature().getName() + "() ended at: " + endTime);
        System.out.println("Elapsed time: " + (endTime - this.startTime) + " ms");
    }
}
