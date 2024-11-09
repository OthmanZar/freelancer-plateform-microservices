package com.freelance.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecConfig {

@Bean
    PasswordEncoder encoder(){

    return new BCryptPasswordEncoder();

}

@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{

    security.csrf(csrf->csrf.disable());
    security.authorizeHttpRequests(auth -> {
        auth.anyRequest().permitAll();

    });


    return security.build();


}

}
