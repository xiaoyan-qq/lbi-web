/**************************************
 * Copyright (C), Navinfo
 * Package: com.pl.admin.config
 * Author: liumingkai05559
 * Date: Created in 2018/6/4 13:38
 **************************************/
package com.lbi.tile.config;


import com.lbi.tile.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/*************************************
 * Class Name: SecurityConfiguration
 * Description:〈安全配置〉
 * @author liumingkai
 * @create 2018/6/4
 * @since 1.0.0
 ************************************/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource(name="userService")
    UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**");
        web.ignoring().antMatchers("/scripts/**");
        web.ignoring().antMatchers("/");
        web.ignoring().antMatchers("/data/**");
        web.ignoring().antMatchers("/log/**");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and().rememberMe().tokenValiditySeconds(60 * 10)
                .and().logout().logoutSuccessUrl("/").permitAll();
        http.csrf().disable();
    }
}
