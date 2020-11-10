package com.itheima.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/10 11:10
 */
@Configuration
@ComponentScan(basePackages = "com.itheima.security.springmvc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
    //在此处配置了除了 Controller的其他bean，比如：数据库连接池、事务管理器、业务bean等。
}
