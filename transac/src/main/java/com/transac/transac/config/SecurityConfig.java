package com.transac.transac.config;

import java.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/v1/auth/**").permitAll()  // Allow public access to register endpoint
                    .anyRequest().authenticated()
            )
            .csrf().disable();  // Disable CSRF for simplicity, enable it in production
        return http.build();
    }
    
   


}