/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.config;

import com.tgcoord.service.CustomUserDetailService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author natal
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOG = Logger.getLogger(SecurityConfig.class.getName());
    
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/v1/**").hasRole("USER")
                .antMatchers("/v1/*/admin/**").hasRole("ADMIN")
                .and().httpBasic();
    }
    
    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER","ADMIN")
                .and()
                .withUser("func").password("").roles("USER");
    }    
}

//      <html xmlns="http://www.w3.org/1999/xhtml"
//      xmlns:th="http://www.thymeleaf.org">
//<head>
//    <title>Your Title</title>
//    <link rel="stylesheet" th:href="@{/css/style.css}" />
//</head>