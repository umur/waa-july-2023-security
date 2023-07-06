package com.miu.waa.lab3.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.waa.lab3.util.Util;

@Aspect
@Component
public class WaaOffensiveWords {

    @Pointcut("@annotation(com.miu.waa.lab3.aspect.annotation.OffensiveWord)")
    public void offensiveWordAnnotation() {

    }

    @Around("offensiveWordAnnotation()")
    public Object censorOffensiveWords(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();

        Object returningObject = proceedingJoinPoint.proceed(args);

        try {
            String jsonString = objectMapper.writeValueAsString(returningObject);

            for (String word : Constants.OFFENSIVE_WORDS) {
                jsonString = jsonString.replaceAll(word, Util.getStars(word.length()));
            }

            returningObject = objectMapper.readValue(jsonString, returningObject.getClass());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return returningObject;
    }
}
