package com.miu.springsecurity.aspect;

import com.miu.springsecurity.service.OffensiveWordService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWordsAspect {



    private final OffensiveWordService offensiveWordService;
    @Pointcut("@annotation(com.miu.springsecurity.aspect.annotation.OffensiveWord)")
    public void OffensiveWordsAspect(){
    }

    @Around("OffensiveWordsAspect()")
    public Object filterOutOffensiveWord(ProceedingJoinPoint joinPoint)throws Throwable {
            if(offensiveWordService.checkIfBanned())
                return "You have been banned for about 15 minutes";
            Object[] signatureArgs = joinPoint.getArgs();
            offensiveWordService.scanOffensiveWord(signatureArgs);
            var result = joinPoint.proceed(signatureArgs);
            return result;
    }
}
