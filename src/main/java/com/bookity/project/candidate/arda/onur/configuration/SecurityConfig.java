package com.bookity.project.candidate.arda.onur.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


@Bean
public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(authorizationManagerRequestMatcher-> authorizationManagerRequestMatcher
                    .requestMatchers("/login","/signup","/users","/confirmations").permitAll()
                    .requestMatchers("/index").authenticated())
            .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                    .loginPage("/login")
                    .defaultSuccessUrl("/index",true)
                    .failureUrl("/error"))
            .build();

}
}
