package com.wbx.learnsecurity.config;/*
 *@author 王炳祥
 *@createTime
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
//aop拦截器
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只能有权限的人才能访问
        //请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAuthority("user");

        //没有权限默认会到登录页面，需要开启登录的页面
        http.formLogin();

        //注销
//        http.logout();

    }

    //认证 spring2.1.x 可以直接使用
    //密码编码：PasswordEncoder
    //在spring security 5.0+ 新增了很多加密方法


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //这些数据正常应该从数据库中拿
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("wbx").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
//                .and()
//                .withUser("xy").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
//    }

    @Autowired
    private DataSource dataSource;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {  //对密码加密    和   密码进行匹配
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // ensure the passwords are encoded properly

        auth.jdbcAuthentication().dataSource(dataSource);

    }
}
