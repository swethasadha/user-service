/*
 * package com.library.userservice.config;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig{
 * 
 * 
 * protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests() .antMatchers("/users/register",
 * "/users/login").permitAll() .anyRequest().authenticated(); } }
 * 
 */