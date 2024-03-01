package tn.esprit.testboutique.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Slf4j
public class TestAspect {

    @Around("execution(* tn.esprit.testboutique.Services.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Date start= new Date() ;
        Object obj = joinPoint.proceed();
        int time= new Date().compareTo(start);
        log.info("temps d'execution = "+time);
        return obj ;
    }
}
