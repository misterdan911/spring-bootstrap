package com.myspring.bootstrap.config;

import com.myspring.bootstrap.shared.jwtutils.JwtAuthenticationEntryPoint;
import com.myspring.bootstrap.shared.jwtutils.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
            // disable csrf
            .csrf(csrf -> csrf.disable())
            // no session management
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    // Allows all requests to endpoints starting with /api/auth/ without requiring authentication (public endpoints, e.g., login or register)
                    .requestMatchers("/api/auth/**").permitAll()
                    // Requires authentication for all other requests.
                    .anyRequest().authenticated()
            )
            // Send a 401 error response if user is not authentic.
             .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
            // filter the request and add authentication token
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}

