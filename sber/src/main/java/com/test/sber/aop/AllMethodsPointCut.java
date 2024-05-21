package com.test.sber.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AllMethodsPointCut {
    @Pointcut("execution(* com.test.sber.controller.CompanyController.*(..))")
    public void allMethodsFromCompanyController() {
    }

    @Pointcut("execution(* com.test.sber.controller.EmployeeController.*(..))")
    public void allMethodsFromEntityController() {
    }

}
