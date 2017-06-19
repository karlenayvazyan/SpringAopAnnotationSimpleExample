package am.ak.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by karlen on 6/11/17.
 */
@Aspect
public class NotVeryUsefulAspect {

    @Before("execution(public void setName(..))")
    private void beforeSetName() {
        System.out.println("set name pointcat");
    }

    @AfterReturning(pointcut = "execution(public String getName(..))", returning = "name")
    private void afterGetName(String name) {
        System.out.println("get name pointcat which value is: " + name);
    }

    @AfterThrowing(pointcut = "execution(public * *(..))", throwing = "ex")
    private void afterThrowingException(RuntimeException ex) {
        System.out.println("After throwing exception: " + ex.getMessage());
    }

    @After("execution(public String getName(..))")
    private void after() {
        System.out.println("after");
    }

    @Around("execution(public String getName(..))")
    private Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long time = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println(System.nanoTime() - time);
        proceed = "kal";
        return proceed;
    }
}
