package com.liangtengyu.config;

import com.liangtengyu.config.handler.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: lty
 * @Date: 2020/12/24 16:19
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationManager myAuthenticationManager; //登录身份验证管理器


    @Autowired
    AuthSuccessHandler authSuccessHandler;//登录成功处理器

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(myAuthenticationManager);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //"/login"不进行权限验证
                .antMatchers("/login").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .anyRequest().authenticated()   //其他的需要登陆后才能访问
                .and()
                .formLogin()
                //loginProcessingUrl用于指定前后端分离的时候调用后台登录接口的名称
                .loginProcessingUrl("/login")
                //配置登录成功的自定义处理类
                .successHandler(authSuccessHandler)
                //配置登录失败的自定义处理类

                .and()
                //loginProcessingUrl用于指定前后端分离的时候调用后台注销接口的名称
                .logout().logoutUrl("/logout")

                .and()
                //配置没有权限的自定义处理类

                .cors()//新加入
                .and()
                .csrf().disable();// 取消跨站请求伪造防护
    }

}
