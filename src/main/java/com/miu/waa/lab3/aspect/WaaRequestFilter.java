package com.miu.waa.lab3.aspect;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.exception.Exceptions;
import com.miu.waa.lab3.exception.ServiceException;
import com.miu.waa.lab3.service.OffensiveWordService;
import com.miu.waa.lab3.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaRequestFilter {
    private final OffensiveWordService offensiveWordService;
    private final SecurityUtil securityUtil;

    @Value("${offensive-word.limit:5}")
    private long limit;

    @Before("execution(* com.miu.waa.lab3.service.impl.*.create(..))")
    public void countOffensiveWords(JoinPoint joinPoint) throws Throwable {
        User user = securityUtil.getCurrentUser();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        ObjectMapper objectMapper = new ObjectMapper();

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < signature.getParameterTypes().length; i++) {
            Class clazz = signature.getParameterTypes()[i];

            if (clazz.getPackageName().equals("com.miu.waa.lab3.entity")) {
                Object obj = args[i];

                try {
                    String jsonString = objectMapper.writeValueAsString(obj);

                    for (String word : Constants.OFFENSIVE_WORDS) {
                        if (jsonString.contains(word)) {
                            var offensiveWord = offensiveWordService.validateOffensiveWords(user);

                            if (offensiveWord.getCount() >= limit) {
                                var exception = Exceptions.WORD_EXCEED;

                                var duration = Duration.between(LocalDateTime.now(), offensiveWord.getExpireDate());

                                throw new ServiceException(exception.getStatus(), exception.getCode(), exception
                                        .getMessage().replaceAll("%minutes%", Long.toString(duration.toMinutes())));
                            }

                            break;
                        }
                    }

                } catch (JsonProcessingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
