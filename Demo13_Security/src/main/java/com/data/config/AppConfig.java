package com.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // cross site request forgery: chặn việc request giả mạo
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests().requestMatchers("account")
                .permitAll();

        httpSecurity.authorizeRequests().requestMatchers("/product/**")
                .hasRole("ADMIN");

        // tất cả request đều phải xác thực gửi username/password
        httpSecurity.authorizeRequests().anyRequest().authenticated();

        httpSecurity.httpBasic();
        return httpSecurity.build();
    }
}
