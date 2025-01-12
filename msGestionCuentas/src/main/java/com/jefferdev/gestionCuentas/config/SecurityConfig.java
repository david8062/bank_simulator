/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

/**
 *
 * @author jeffer-dev
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.csrf(csrf -> csrf
        				.ignoringRequestMatchers( "/api/**")
        				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        				.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()))
        	.authorizeHttpRequests(auth -> {
                auth.anyRequest().authenticated();
        	})
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
