package product.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Aspect
@Component
public class ProfanityFilterAspect {

    private static List<String> profanicWords = List.of("fuck", "bitch");

   private String createStringProfanity(int length) {
       StringBuilder newValue = new StringBuilder();
       newValue.append("*".repeat(Math.max(0, length)));
       return newValue.toString();
   }

    @Pointcut(value = "@annotation(product.annotation.ProfanityFilter))")
    void a(){}

    @Before("a()")
    public void around(JoinPoint joinPoint){

        var args = joinPoint.getArgs();

        for(Object arg: args){
            for(Field field: arg.getClass().getDeclaredFields()){
                field.setAccessible(true);
                if (field.getType() == String.class) {
                    String value = null;

                    try {
                        value = (String) field.get(arg);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }


                    String finalValue = value;

                    for(String profanity: profanicWords){
                        finalValue = finalValue.replaceAll(String.format("(?i)%s", profanity), createStringProfanity(profanity.length()));
                    }

                    try {
                        field.set(arg, finalValue);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

}
