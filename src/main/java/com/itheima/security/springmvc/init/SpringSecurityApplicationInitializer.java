package com.itheima.security.springmvc.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/15 23:37
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityApplicationInitializer() {
        /**
         * 若当前环境没有使用Spring或Spring MVC，
         * 则需要将 WebSecurityConfig(Spring Security配置类) 传入超类，
         * 以确保获取配置，并创建spring context。
         */
        //super(WebSecurityConfig.class);
    }
}
