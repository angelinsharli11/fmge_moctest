package com.example.exam.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1) // 🔥 VERY IMPORTANT (higher priority)
public class ActuatorSecurityConfig {

    @Bean
    public SecurityFilterChain actuatorSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher(EndpointRequest.toAnyEndpoint()) // applies ONLY to actuator
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // allow without login
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
