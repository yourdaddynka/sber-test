package com.test.sber.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Объект, определяющий точки перехвата для всех методов в классах CompanyController и EmployeeController.
 */
public class AllMethodsPointCut {
    /**
     * Точка перехвата для всех методов из класса CompanyController.
     */
    @Pointcut("execution(* com.test.sber.controller.CompanyController.*(..))")
    public void allMethodsFromCompanyController() {
    }

    /**
     * Точка перехвата для всех методов из класса EmployeeController.
     */
    @Pointcut("execution(* com.test.sber.controller.EmployeeController.*(..))")
    public void allMethodsFromEntityController() {
    }

}
