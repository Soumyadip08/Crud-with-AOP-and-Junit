package com.xadmin.SpringBootCrud.aspect;

import com.xadmin.SpringBootCrud.Entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

//  @Pointcut("within(com.xadmin.SpringBootCrud.Service.*)")                        if we execute only service
//  @Pointcut("this(com.xadmin.SpringBootCrud.Employeeservice.)")                  if we execute only Employeeservice

    @Pointcut("execution(* com.xadmin.SpringBootCrud.Controller.*.*(..))")
    public void loggingPointCut(){
    }

//    @Before("loggingPointCut()")
//    public void before(JoinPoint joinPoint){
//        log.info("Before method invoked::"+ joinPoint.getSignature());
//    }

//    @After("loggingPointCut()")
//    public void after(JoinPoint joinPoint) {
//        log.info("After method invoked::" + joinPoint.getSignature());
//    }
//
//        @AfterReturning(value = "execution(* com.xadmin.SpringBootCrud.Controller.*.*(..))" , returning = "employee")
//       public void after(JoinPoint joinPoint , Employee employee) {
//          log.info("After method invoked::" + employee);
//       }


//    @AfterThrowing(value = "execution(* com.xadmin.SpringBootCrud.Controller.*.*(..))" , throwing = "e")
//    public void after(JoinPoint joinPoint , Exception e) {
//        log.info("After method invoked::" + e.getMessage());
//    }


    @Around("loggingPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around method invoked::"+ joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if (object instanceof Employee){
            log.info("Around method invoked ...." + joinPoint.getArgs()[0]);
        } else {
            log.info("None");
        }
        return object;
    }


}
