package com.example.clientsservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
/*@Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}*/

/*    @Bean
  public  InMemoryUserDetailsManager userDetailsManager(BCryptPasswordEncoder encoder){
       return new InMemoryUserDetailsManager(
       User.builder().
       passwordEncoder(encoder::encode)
       .username("test")
       .password("pass")
       .roles(Role.USER.name())
       .build(),
       User.builder().
       passwordEncoder(encoder::encode)
       .username("admin")
       .password("admin")
       .roles(Role.ADMIN.name())
       .build(
       );
    } */
}
