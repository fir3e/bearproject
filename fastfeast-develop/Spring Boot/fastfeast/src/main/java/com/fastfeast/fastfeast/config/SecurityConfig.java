package com.fastfeast.fastfeast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fastfeast.fastfeast.user.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests().anyRequest().permitAll();
    // authCustomizer -> authCustomizer
    // .requestMatchers(HttpMethod.POST, "/index/**").permitAll()
    // .requestMatchers(HttpMethod.GET, "/index/**").permitAll());
    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

}