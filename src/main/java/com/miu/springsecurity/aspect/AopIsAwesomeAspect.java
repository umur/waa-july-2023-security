package com.miu.springsecurity.aspect;

import com.miu.springsecurity.exception.AopIsAwesomeHeaderException;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
@RequiredArgsConstructor
public class AopIsAwesomeAspect {
    private final HttpServletRequest request;
    @Pointcut("within(com.miu.springsecurity.service..*)")
    public void AopIsAwesomePointOut(){
    }

    @Before("AopIsAwesomePointOut()")
    public void IsAopAwesome(JoinPoint joinPoint) throws AopIsAwesomeHeaderException{
        System.out.println(request.getHeader("s"));
        if(request.getMethod().equalsIgnoreCase("POST")){
            if(request.getHeader("AOP-IS-AWESOME")==null){
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header not found");
            }
        }

    }
}
