package com.reset.spring.mvc_hibernate_aop.aspects;

//import com.reset.spring.mvc_hibernate_aop.aspects.pointcuts.PointCuts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /**
     * This method is an advice that is executed around all repository methods.
     * It intercepts the method call, prints the name of the method, executes the method,
     * and then prints the end of the method execution. Returns the result of the intercepted method.
     *
     * @param joinPoint the join point at which this advice is being executed
     * @return the result of the intercepted method
     * @throws Throwable if any error occurs during the method interception
     */
    @Around(value = "com.reset.spring.mvc_hibernate_aop.aspects.pointcuts." +
            "PointCuts.allMethodsFromAllDAOImplsPointCut()")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of \"" + methodName + "\" method");
        Object targetMethodResult = joinPoint.proceed(); //Запуск метода и сохранение его возвращаемых данных
        System.out.println("End of \"" + methodName + "\" method");

        return targetMethodResult;
    }
}
