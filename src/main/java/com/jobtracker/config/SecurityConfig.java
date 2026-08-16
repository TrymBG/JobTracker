package com.jobtracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 */

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.authorizeHttpRequests(auth -> auth
            // Rules are evaluated top to bottom, first match wins. 
            // The permitAll() rule must come before the anyRequest() 

            .requestMatchers("/api/auth/register").permitAll()
            .anyRequest().authenticated()
            );
    
        // stateless JWT auth doesnt use cookies/sessions, so CSRF protection is not needed
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

}
