package com.example.clientsservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //@Bean
    public InMemoryUserDetailsManager userDetailsManager(BCryptPasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
                User.builder().
                        passwordEncoder(encoder::encode)
                        .username("test")
                        .password("pass")
                        .roles(com.example.clientsservice.models.User.Role.USER.name())
                        .build(),
                User.builder().
                        passwordEncoder(encoder::encode)
                        .username("admin")
                        .password("admin")
                        .roles(com.example.clientsservice.models.User.Role.ADMIN.name())
                        .build());
    }

    @Bean
    public AuthenticationManager authManager(
            HttpSecurity security,
            BCryptPasswordEncoder encoder,
            UserDetailsService userDetailsService)
            throws Exception {
        System.err.println("AuthManager");

        return security
                .getSharedObject
                (AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder).
                and().build();

    }

    @Bean
    public WebSecurityCustomizer securityCustomizer(){
        return customizer ->
        customizer.debug(false)
                .ignoring()
                .antMatchers("css/**")
                .antMatchers("ui/config/**")
                .antMatchers("/registration")
                .antMatchers("/clients")
                .mvcMatchers(HttpMethod.POST, "/registration")
                ;
    }
}
