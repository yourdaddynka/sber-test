package com.test.sber.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Конфигурация для автоматической активации аспектов и сканирования пакетов в проекте.
 */
@Configuration
@ComponentScan(basePackages = "com.test.sber")
@EnableAspectJAutoProxy
public class MyConfig {
}