package com.reset.spring.mvc_hibernate_aop.aspects.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCuts {
    /**
     * This method represents a pointcut for all methods from all DAO implementation classes.
     * It matches any execution of methods in classes within the package "com.reset.spring.mvc_hibernate_aop.dao"
     * and its sub-packages, with any return type and any number of parameters.
     * <p>
     * Usage:
     * To use this pointcut, simply add the @Pointcut annotation with this method as the value.
     * For example:
     *
     * @Pointcut(allMethodsFromAllDAOImplsPointCut()) public void someAdvicePointcut() {
     * // Advice implementation
     * }
     * <p>
     * This pointcut can be used in conjunction with the @Around, @Before, or @After advice annotations to intercept
     * the execution of methods in the specified DAO implementation classes.
     */
    @Pointcut("execution(* com.reset.spring.mvc_hibernate_aop.dao.*.*(..))")
    public void allMethodsFromAllDAOImplsPointCut() {

    }
}
