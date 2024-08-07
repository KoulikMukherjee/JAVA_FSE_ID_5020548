package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.library..*(..)))")
    public Object logExecutionTime(ProceedingJoinPoint joinpoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinpoint.proceed();
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.println("Signature: " + joinpoint.getSignature() + "\nMethod Name: " + joinpoint.getSignature().getName() + "() --> Execution Time: " + executionTime + " ms");
        return proceed;
    }

}
