package com.aop.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.awt.*;

@Aspect
@Component
public class DemoAspect {

    /*
        execution(public void addAccount()) => pointcut expression
        Various other ways to write point cut expressions (docs)
        https://docs.spring.io/spring/docs/2.0.x/reference/aop.html (6.2.3)
    */

    @Before("execution(public void com.aop.dao.AccountDao.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println(getClass() + " >>= called before addAccount =<< ");
    }

/*
    @After("execution(public void com.aop.dao.AccountDao.addAccount())")
    public void afterAddAccountAdvice(){
        System.out.println(getClass() + " >>= called after addAccount =<< ");
    }
*/

    @Around("execution(public void com.aop.dao.AccountDao.addAccount())")
    public void aroundAddAccountAdvice(){
        System.out.println("here in aroundfunction");
        System.out.println(getClass() + " >>= Before and after addAccount =<<");
    }

    @AfterReturning(value = "execution(* com.aop.dao.AccountDao.*(..))",returning = "returnValue")
    public void afterAddUser(JoinPoint joinPoint, Object returnValue){
        System.out.println("METHOD SIGNATURE : " + joinPoint.getSignature());
        System.out.println("Returning value : " + returnValue);
    }

    @AfterThrowing(value = "execution(* com.aop.dao.AccountDao.*(..))", throwing = "error")
    public void customException(JoinPoint joinPoint, Throwable error) {
        System.out.println("METHOD SIGNATURE : " + joinPoint.getSignature());
        System.out.println("ERROR OCCURED :" + error);
    }

}
