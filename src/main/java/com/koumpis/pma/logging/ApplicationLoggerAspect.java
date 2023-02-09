package com.koumpis.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.koumpis.pma.controllers..*)" + "within (com.koumpis.pma.repositories..*)")
    public void definePackagePointcuts() {

    }

    @After("definePackagePointcuts()")
    public void log(JoinPoint joinPoint) {
        logger.debug(" --- ---- ---- ---- ---- ---- ---- ---- ");
        logger.debug("\n -- ** -- ** Before method Exec. ** -- ** --");
        logger.debug("\n {}.{} with args = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        logger.debug("-------------------------------------------- --------------------- \n");
    }

    @Around("definePackagePointcuts()")
    private Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("\n\n\n Running before");
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.debug("\n\n\n\n Running after!");
        return object;
    }
}