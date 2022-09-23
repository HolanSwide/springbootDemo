package com.holanswide.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/23
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    // 授权
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/hello").hasRole("1")
                .antMatchers("/all").hasRole("2");
        http.formLogin().loginPage("/login").loginProcessingUrl("/login");
        // 注销
        http.logout();
    }

    @Override
    // 认证
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("1","2")
                .and()
                .withUser("test").password(new BCryptPasswordEncoder().encode("123456")).roles("2");
    }
}
