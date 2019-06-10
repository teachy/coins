package com.teachy.coins.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.teachy.coins.tasks..*.*(..))")
    public void log() {
    }

    @Around("log()")
    public void doTasks(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        String name = signature.getName();
        logger.info("begin function:{}", name);
        try {
            long begin = System.currentTimeMillis();
            proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("{} is use:{} second", name, (end - begin) / 1000);
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
        }
        logger.info("complete function:{}\n", name);
    }
}
