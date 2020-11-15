package com.itheima.security.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/15 23:12
 *
 * 安全配置类：
 * spring security提供了用户名密码登录、退出、会话管理等认证功能，只需要配置即可使用。
 * 配置完，需要加载到Spring的容器中。
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @return
     * 定义用户信息服务（查询用户信息）
     * UserDetailsService：用来查询用户信息的，可以是去数据库中查询，也可以是去内存中查询用户信息
     */
    @Bean
    public UserDetailsService userDetailsService() {
        //定义基于内存的用户信息查询
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    /**
     * @return
     * 密码编码器：用来定义比对 “数据库中的密码和用户输入的密码” 的方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();//字符串直接比对，不对密码进行编码（加密算法）。其他的比如MD5等。
    }

    /**
     *
     * @param http
     * @throws Exception
     * 安全拦截机制（最重要）
     * 这个就相当于在基于session的认证方式中定义拦截器的策略
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过  url匹配/r/**的资源，经过认证后才能访问。
                .anyRequest().permitAll()//除了/r/**，其它的请求可以访问
                .and()
                .formLogin()//允许表单登录
                .successForwardUrl("/login-success");//自定义登录成功的页面地址

    }
}
