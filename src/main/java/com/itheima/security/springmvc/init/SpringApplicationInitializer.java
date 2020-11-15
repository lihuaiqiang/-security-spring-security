package com.itheima.security.springmvc.init;

import com.itheima.security.springmvc.config.ApplicationConfig;
import com.itheima.security.springmvc.config.WebConfig;
import com.itheima.security.springmvc.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/10 15:34
 * <p>
 * Spring容器初始化类，此类实现 WebApplicationInitializer接口，Spring容器启动时加载 WebApplicationInitializer接口的所有实现类。
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring容器，相当于加载 applicationContext.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};//指定 rootContext的配置类
    }

    /**
     * servletContext，相当于加载 springmvc.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};//指定 servletContext的配置类
    }

    /**
     * url-mapping
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
