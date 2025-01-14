package com.example.securitydemo.usernamepassword.exbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * HTTP 요청을 보낼 때, 사용자 이름과 비밀번호를 Authorization 헤더에 Base64 인코딩하여 포함시킴 (보안 약함)
 */
@Configuration
@EnableWebSecurity
public class ExBasic {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
